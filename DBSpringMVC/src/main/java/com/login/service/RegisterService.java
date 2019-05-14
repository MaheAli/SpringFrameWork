package com.login.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.register.view.RegisterView;


public class RegisterService {

	public boolean register(RegisterView rv)
	
	{
		String url = "jdbc:mysql://localhost:3306/demo";
		String u = "root";
		String p = "root";
		
		try
		{
			 
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,u,p);  
			PreparedStatement stmt=con.prepareStatement("insert into Employee values(?,?,?,?,?)");
			stmt.setString(1, rv.getID());
			stmt.setString(2, rv.getFirst_Name());
			stmt.setString(3, rv.getLast_Name());
			stmt.setInt(4, rv.getSalary());
			stmt.setInt(5, 1);
			
			int rs = stmt.executeUpdate();
			//if(rs.next())
			////{
				return true;
			//}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return false;
	}
	
}