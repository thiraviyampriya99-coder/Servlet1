package com.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.beanClass.RegisterBean;


public class RegisterDb {
	
	public String authorizeRegister(RegisterBean RD) {
		
		String firstname = RD.getFirstname();
		String lastname = RD.getLastname();
		String username = RD.getUsername();
		String password = RD.getPassword();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","priya@1126");
			
			PreparedStatement stm1 = conn.prepareStatement("INSERT INTO webdetail(firstname,lastname,username,password)VALUES(?,?,?,?)");
	
			
			stm1.setString(1,firstname);
			stm1.setString(2,lastname);
			
			stm1.setString(3,username);
			
			stm1.setString(4,password);
			
			
			stm1.executeUpdate();
			return "Successfully Register";
			
		}
		  
		
		catch(SQLException | ClassNotFoundException e) {
			
			//TODO Auto-generated catch block
			e.printStackTrace();	
		}
		
		return "FAILED REGISTER";
	}
}
	
