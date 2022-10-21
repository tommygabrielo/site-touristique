package net.site.controller;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.rmi.ServerException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		
		if(action == "/logginOK") {
			toConnect(request, response);
		}
		else {
			maLogin(request, response);
		}
	}

	//maLogins
	private void maLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		
		dispatcher.forward(request, response);
		
	}

	private void toConnect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String val = request.getParameter("OK");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/sites.jsp");
		
		dispatcher.forward(request, response);
		
	}


}
