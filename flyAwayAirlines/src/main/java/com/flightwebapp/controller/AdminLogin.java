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
import com.flightwebapp.utils.FlightUtil;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		adminLoginVerification(request, response);
		validateUser(request, response);
	}

	private void adminLoginVerification(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = FlightUtil.getSessionFactory().openSession();

		session.beginTransaction();
		String name = "FlyAway";
		String email = "simplilearn@gmail.com";
		String password = "admin";
		AdLogin adlogin = new AdLogin(name, email, password);
		session.save(adlogin);
		session.getTransaction().commit();
		session.close();

	}

	public void validateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = FlightUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<AdLogin> login = session.createQuery("from AdLogin").list();

		session.close();
		String emailform = request.getParameter("email");
		String passwordform = request.getParameter("password");


		if ((login.get(0).getEmail()).equals(emailform) && (login.get(0).getPassword()).equals(passwordform)) {
			HttpSession usersession = request.getSession();
			usersession.setAttribute("LoginCredentials", login.get(0));
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("adminLogin.html");
			rd.include(request, response);
		}
	}

}
