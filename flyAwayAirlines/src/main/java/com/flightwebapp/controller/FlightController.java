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


import com.flightwebapp.model.Flight;
import com.flightwebapp.utils.FlightUtil;

@WebServlet("/FlightController")
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = FlightUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Flight> flight = session.createQuery("from Flight").list();
		
		session.close();

		HttpSession usersession = request.getSession();
		usersession.setAttribute("flights",flight );
		System.out.println("dispatched");
		RequestDispatcher rd = request.getRequestDispatcher("flight.jsp");
		rd.forward(request, response);
		
	}

}
