package com.login.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginService {

	public boolean check(String uname,String pass)
	
	{
		String url = "jdbc:mysql://localhost:3306/demo";
		String u = "root";
		String p = "root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,u,p);  
			PreparedStatement stmt=con.prepareStatement("select * from users where userid=? and pwd=?");  
			stmt.setString(1, uname);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				return true;
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return false;
	}
	
}
