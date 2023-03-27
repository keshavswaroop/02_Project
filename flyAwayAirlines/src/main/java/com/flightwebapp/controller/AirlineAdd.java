package com.flightwebapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.flightwebapp.model.AdLogin;
import com.flightwebapp.model.Airlines;
import com.flightwebapp.model.Place;
import com.flightwebapp.utils.FlightUtil;

@WebServlet("/AirlineAdd")
public class AirlineAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int flightid = Integer.parseInt(request.getParameter("flightid"));

		HttpSession usersession = request.getSession();
		usersession.setAttribute("flightid", flightid);

		Session session = FlightUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Airlines> airlines = session.createQuery("from Airlines").list();

		session.close();
		session.beginTransaction();
		List<Place> sourcePlaces = session.createQuery("from Place").list();

		session.close();
		session.beginTransaction();
		List<Place> destinationPlaces = session.createQuery("from Place").list();

		session.close();
		request.setAttribute("airlines", airlines);
		request.setAttribute("sourcePlaces", sourcePlaces);
		request.setAttribute("destinationPlaces", destinationPlaces);
		RequestDispatcher rd = request.getRequestDispatcher("insertFlight.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Session session = FlightUtil.getSessionFactory().openSession();

		session.beginTransaction();
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		Airlines airline = new Airlines(name, country);
		session.save(airline);
		session.getTransaction().commit();
		session.close();
		request.setAttribute("message","New Airline Added Successfully");
		RequestDispatcher rd = request.getRequestDispatcher("airlinesConfirm.jsp");
		rd.forward(request, response);
	}

}
