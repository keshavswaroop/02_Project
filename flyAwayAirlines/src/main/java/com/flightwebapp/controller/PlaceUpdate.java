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

import com.flightwebapp.model.Place;
import com.flightwebapp.utils.FlightUtil;

@WebServlet("/PlaceUpdate")
public class PlaceUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int placeid=Integer.parseInt(request.getParameter("placeid"));
		HttpSession usersession = request.getSession();
		usersession.setAttribute("placeid", placeid);
		RequestDispatcher rd = request.getRequestDispatcher("updateplace.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession usersession = request.getSession();
		int placeid=(int) usersession.getAttribute("placeid");
		String name=request.getParameter("name");
		System.out.println(placeid);
		Session session = FlightUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Place place=session.get(Place.class,placeid);
		place.setName(name);
		session.update(place);
		session.getTransaction().commit();
		session.close();
		request.setAttribute("message","Place Updated Successfully");
		RequestDispatcher rd = request.getRequestDispatcher("placeConfirm.jsp");
		rd.forward(request, response);

	}

}
