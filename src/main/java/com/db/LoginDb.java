package com.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.beanClass.LoginBean;


public class LoginDb {
	public String authorizeLogin(LoginBean LD) {
		
		String username =  LD.getUsername();
		String passsword = LD.getPassword();
		
		
		String DBusername="";
		String DBpassword="";
		
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web","root","priya@1126");
		
			PreparedStatement stm1=conn.prepareStatement("SELECT*FROM webdetail WHERE username=?  AND password=?");
			
			stm1.setString(1, username);
			stm1.setString(2, passsword);
			
			ResultSet rs=stm1.executeQuery();
			
			while(rs.next()) {
				DBusername = rs .getString("username");
				DBpassword = rs .getString("password");
				
				if(username.equals(DBusername)&& DBpassword.equals(DBpassword)) {
					return "Successfully Login";	
				}
			}
			
		}
		
		
		catch(SQLException | ClassNotFoundException e ) {
			//TODO Auto-generated catch block
				e.printStackTrace();
		
		}
	
	 return "WORNG  USERNAME AND PASSWORD";
	
	
	
	
	
	
	
	
	}


}
