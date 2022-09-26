package com.abc.controller;
import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.abc.DAO.UserService;
import com.abc.dto.UserDto;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head>Login</head></body>");
		out.println("<body>");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String useremail=request.getParameter("useremail");
		String usermobile=request.getParameter("usermobile");
		
		UserDto  user = new UserDto ();
		user.setUsername(username);
		user.setPassword(password);
		user.setUsermail(useremail);
		user.setUsermobile(usermobile);
		
		UserService service = new UserService();
		
		boolean status = service.registerData(user);
		
		if(status)
		{
			out.println("<h1 style='color:green;text-align:center;'>Registration successfull</h1>");
		}
		else
		{
			out.println("<h1 style='color:red;text-align:center;'>Registration failed</h1>");
		}
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
		
		
	}

}
