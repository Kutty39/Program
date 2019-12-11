package com.blbz.webapageapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.blbz.webapageapp.model.WebPageAppModel.dbAction;

@WebServlet("/login")
public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usr = request.getParameter("username");
		String pas = request.getParameter("password");
		HttpSession sn = dbAction().userValidation(usr, pas, request.getSession(true));
		if (sn.getAttribute("user") != null) {
			request.getRequestDispatcher("profilepage.jsp").forward(request, response);
		}else {
			request.setAttribute("regsucs","error");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
