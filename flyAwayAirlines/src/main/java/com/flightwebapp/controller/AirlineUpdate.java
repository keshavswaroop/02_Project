package com.flightwebapp.controller;

import java.io.IOException;

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

@WebServlet("/AirlineUpdate")
public class AirlineUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int airlineid=Integer.parseInt(request.getParameter("airlineid"));

		HttpSession usersession = request.getSession();
		usersession.setAttribute("airlineid", airlineid);
		RequestDispatcher rd = request.getRequestDispatcher("updateAirline.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession usersession = request.getSession();
		int airlineid=(int) usersession.getAttribute("airlineid");
		String name=request.getParameter("name");
		String country=request.getParameter("country");
		System.out.println(airlineid);
		Session session = FlightUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Airlines airline=session.get(Airlines.class,airlineid);
		airline.setName(name);
		airline.setCountry(country);
		session.update(airline);
		session.getTransaction().commit();
		session.close();
		request.setAttribute("message","Airline Updated Successfully");
		RequestDispatcher rd = request.getRequestDispatcher("airlinesConfirm.jsp");
		rd.forward(request, response);

	}

}
