package com.flightwebapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.flightwebapp.model.Airlines;
import com.flightwebapp.model.Flight;
import com.flightwebapp.model.User;
import com.flightwebapp.utils.FlightUtil;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int flightid=Integer.parseInt(request.getParameter("flightid"));

		HttpSession usersession = request.getSession();
		usersession.setAttribute("flightid", flightid);
		RequestDispatcher rd = request.getRequestDispatcher("userLogin.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address = request.getParameter("address");
		
		Session session = FlightUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		HttpSession usersession = request.getSession();
		
		int flightid=(int) usersession.getAttribute("flightid");
		Flight flight=session.get(Flight.class,flightid);
		int seats=(int) usersession.getAttribute("seats");
		int total = seats*flight.getPrice();
		
		
		User user = new User(name,email,phone,address,flight);
		session.save(user);
		session.getTransaction().commit();
		session.close();
		usersession.setAttribute("user", user);
		usersession.setAttribute("total", total);
		RequestDispatcher rd = request.getRequestDispatcher("confirmation.jsp");
		rd.include(request, response);
	}

}
