package com.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.beanClass.RegisterBean;
import com.db.RegisterDb;




@WebServlet("/RegisterControler")
public class RegisterControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterBean RB;
       
       public RegisterControler() {
        super();
        
    }


		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("txt_firstname");
		String lastname = request.getParameter("txt_lastname");
		String username = request.getParameter("txt_username");
		String password = request.getParameter("txt_password");
		
		
		RegisterBean Rb = new RegisterBean();
		Rb.setFirstname(firstname);
		Rb.setLastname(lastname);
		Rb.setUsername(username);
		Rb.setPassword(password);
		
		RegisterDb Rd = new RegisterDb();


		String msg = Rd.authorizeRegister(Rb);
			
		if(msg.equals("Successfully Register")) {
			request.getRequestDispatcher("login.html").forward(request, response);	
		}
		
		else {
			request.getRequestDispatcher("Register.html").include(request, response);
		}
		
		
		
	}


}

