package com.flightwebapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.flightwebapp.model.Place;
import com.flightwebapp.model.User;
import com.flightwebapp.utils.FlightUtil;

@WebServlet("/BookingDetails")
public class BookingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = FlightUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		List<User> user = session.createQuery("from User").list();
		
		session.close();
		request.setAttribute("useList", user);
		RequestDispatcher rd=request.getRequestDispatcher("bookingDetails.jsp");
		rd.forward(request, response);
	}


}
