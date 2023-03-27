package com.flightwebapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.flightwebapp.model.Airlines;
import com.flightwebapp.model.Flight;
import com.flightwebapp.model.Place;
import com.flightwebapp.utils.FlightUtil;

@WebServlet("/FlightUpdate")
public class FlightUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int flightid=Integer.parseInt(request.getParameter("flightid"));
		
		HttpSession usersession = request.getSession();
		usersession.setAttribute("flightid", flightid);
		
		Session session = FlightUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Airlines> airlines = session.createQuery("from Airlines").list();


		List<Place> sourcePlaces = session.createQuery("from Place").list();


		List<Place> destinationPlaces = session.createQuery("from Place").list();

		session.close();
		request.setAttribute("airlines", airlines);
		request.setAttribute("sourcePlaces", sourcePlaces);
		request.setAttribute("destinationPlaces",destinationPlaces);
		RequestDispatcher rd = request.getRequestDispatcher("updateFlight.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession usersession = request.getSession();
		int flightid=(int) usersession.getAttribute("flightid");
		
		String sourcePlace=request.getParameter("sourceplace");
		String destinationPlace=request.getParameter("destinationplace");
		String airlines = request.getParameter("airlines");
		int ticketPrice = Integer.parseInt(request.getParameter("price"));
		LocalDate date=LocalDate.parse(request.getParameter("date"));
		System.out.println(flightid);
		
		Session session = FlightUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		String hql = "from Place where name = '" + destinationPlace + "'";
		List<Place> dp= session.createQuery(hql).list();
		
		String hql2="from Place where name = '" + sourcePlace + "'";
		List<Place> sp = session.createQuery(hql2).list();

		String hql3="from Airlines where name = '" + airlines + "'";
		List<Airlines> a = session.createQuery(hql3).list();
		
		Flight flight=session.get(Flight.class,flightid);
		flight.setAirline(a.get(0));
		flight.setSourcePlace(sp.get(0));
		flight.setDestinationPlace(dp.get(0));
		flight.setDepartureTime(date);
		flight.setPrice(ticketPrice);
		session.update(flight);
		session.getTransaction().commit();
		session.close();
		request.setAttribute("message","Flight Updated Successfully");
		RequestDispatcher rd = request.getRequestDispatcher("flightConfirm.jsp");
		rd.forward(request, response);

	}

}
