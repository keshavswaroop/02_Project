package com.flightwebapp.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.flightwebapp.model.AdLogin;
import com.flightwebapp.utils.FlightUtil;


@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = FlightUtil.getSessionFactory().openSession();
		String newPassword= request.getParameter("newpassword");
		session.beginTransaction();
		AdLogin admin=session.get(AdLogin.class,1);
		admin.setPassword(newPassword);
		session.update(admin);
		session.getTransaction().commit();
		session.close();
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
