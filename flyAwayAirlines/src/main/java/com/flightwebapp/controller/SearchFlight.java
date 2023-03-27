package com.flightwebapp.controller;

import java.io.IOException;
import java.time.LocalDate;
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
import com.flightwebapp.model.Place;
import com.flightwebapp.utils.FlightUtil;

@WebServlet("/SearchFlight")
public class SearchFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Session session = FlightUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Place> sourcePlaces = session.createQuery("from Place").list();

		List<Place> destinationPlaces = session.createQuery("from Place").list();

		session.close();
		request.setAttribute("sourcePlaces", sourcePlaces);
		request.setAttribute("destinationPlaces", destinationPlaces);
		RequestDispatcher rd = request.getRequestDispatcher("searchFlight.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sourcePlace=request.getParameter("sourcePlace");
		String destinationPlace=request.getParameter("destinationPlace");
		LocalDate date=LocalDate.parse(request.getParameter("date"));
		int seats= Integer.parseInt(request.getParameter("seats"));
		
		Session session = FlightUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		String hql3="from Flight where sourcePlace.name = '" + sourcePlace + "' and destinationPlace.name = '" + destinationPlace + "' and departureTime = '" + date + "'";
		List<Airlines> a = session.createQuery(hql3).list();
		session.close();
		System.out.println(a);
		HttpSession usersession = request.getSession();
		usersession.setAttribute("flightDetails", a);
		usersession.setAttribute("seats", seats);
		RequestDispatcher rd=request.getRequestDispatcher("displayFlights.jsp");
		rd.include(request,response);
	}

}
