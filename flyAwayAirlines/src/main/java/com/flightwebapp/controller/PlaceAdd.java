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

@WebServlet("/PlaceAdd")
public class PlaceAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.setAttribute("message","New Place Added Successfully");
	RequestDispatcher rd = request.getRequestDispatcher("placeConfirm.jsp");
	rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Session session = FlightUtil.getSessionFactory().openSession();

		session.beginTransaction();
		String name =	request.getParameter("name");
		Place place = new Place(name);
		session.save(place);
		session.getTransaction().commit();
		session.close();
		
		doGet(request, response);
	}

}
