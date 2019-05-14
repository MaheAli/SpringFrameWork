package com.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteService {

public boolean check()
	
	{
		String url = "jdbc:mysql://localhost:3306/demo";
		String u = "root";
		String p = "root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,u,p);  
			PreparedStatement stmt=con.prepareStatement("Update Employee set flag = 0 where ID=?;");  
			stmt.setString(1, "ID");
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
