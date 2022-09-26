package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.DAO.UserService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head>Login</head></body>");
		out.println("<body>");
		
		
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("upwd");
		
		UserService service = new UserService();
		boolean status = service.checklogin(uname, pwd);
		
		if(status)
		{
			out.println("<h1 style='color:green;text-align:center;'>LOGIN SUCCESSFULL</h1>");
		}
		else
		{
			out.println("<h1 style='color:red;text-align:center;'>LOGIN FAILED</h1>");
			out.println("<h1 style='color:red;text-align:center;'><a href='Loginfrom.html'>|LOGIN PAGE|</h1>");
		}
	}

}
