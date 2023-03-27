package com.flightwebapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.flightwebapp.model.AdLogin;
import com.flightwebapp.model.Place;
import com.flightwebapp.utils.FlightUtil;


@WebServlet("/PlaceDelete")
public class PlaceDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = FlightUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int placeid=Integer.parseInt(request.getParameter("placeid"));
		Place place=session.get(Place.class,placeid);

		session.delete(place);
		session.getTransaction().commit();
		session.close();
		request.setAttribute("message","Place Deleted Successfully");
		RequestDispatcher rd = request.getRequestDispatcher("placeConfirm.jsp");
		rd.include(request, response);
	}

}
