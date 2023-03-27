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
import com.flightwebapp.model.Airlines;
import com.flightwebapp.model.Flight;
import com.flightwebapp.model.Place;
import com.flightwebapp.utils.FlightUtil;


@WebServlet("/FlightDelete")
public class FlightDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = FlightUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int flightid=Integer.parseInt(request.getParameter("flightid"));
		Flight flight=session.get(Flight.class,flightid);

		session.delete(flight);
		session.getTransaction().commit();
		session.close();
		request.setAttribute("message","Flight Deleted Successfully");
		RequestDispatcher rd = request.getRequestDispatcher("flightConfirm.jsp");
		rd.include(request, response);
	}

}
