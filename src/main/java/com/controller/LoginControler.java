package com.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.beanClass.LoginBean;
import com.db.LoginDb;




@WebServlet("/LoginControler")
public class LoginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginControler() {
        super();
      
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("txt_username");
		String password=request.getParameter("txt_password");
		
		
		LoginBean Lb = new LoginBean();
		Lb.setUsername(username);
		Lb.setPassword(password);
		
		LoginDb Ld = new LoginDb();
		String msg = Ld.authorizeLogin(Lb);
		
		
		if(msg.equals("Successfully Login")) {
			
			request.getRequestDispatcher("profile.html").forward(request, response);
		}
		
		else {
		
		request.getRequestDispatcher("login.html").include(request, response);
		
	}


}
}

