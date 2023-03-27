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
import com.flightwebapp.model.Place;
import com.flightwebapp.utils.FlightUtil;

@WebServlet("/PlaceController")
public class PlaceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = FlightUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Place> places = session.createQuery("from Place").list();

		session.close();

		HttpSession usersession = request.getSession();
		usersession.setAttribute("places",places );
		System.out.println("dispatched");
		RequestDispatcher rd = request.getRequestDispatcher("places.jsp");
		rd.forward(request, response);
		
	}

}
