package com.login.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.register.view.RegisterView;

public class DeleteService {
	public boolean update(RegisterView rv)
	{
		String url = "jdbc:mysql://localhost:3306/demo";
		String u = "root";
		String p = "root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 
			String query="Update Employee set flag = 0 where ID=?";
			Connection con=DriverManager.getConnection(url,u,p);
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1,  rv.getID());
			
			int rs=stmt.executeUpdate();

				return true;
			

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return false;
	}
	


}


