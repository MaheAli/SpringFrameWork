package com.login.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.register.view.RegisterView;

public class UpdateService {
	public boolean update(RegisterView rv)
	{
		String url = "jdbc:mysql://localhost:3306/demo";
		String u = "root";
		String p = "root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 
			String query="update Employee set First_Name=?,Last_Name=?,Salary=? where id=?";
			Connection con=DriverManager.getConnection(url,u,p);
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, rv.getFirst_Name());
			stmt.setString(2, rv.getLast_Name());
			stmt.setInt(3,  rv.getSalary());
			stmt.setString(4,  rv.getID());
			
			int rs=stmt.executeUpdate();
			  
			 
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con=DriverManager.getConnection(url,u,p);  
//			PreparedStatement stmt=con.prepareStatement("update user set fname=?,gender=?,department=?,email=?,phone=? where id=?"); 
//			 
//			stmt.setString(1, rv.getFirstname());
// 
//			stmt.setString(2, rv.getGender());
//		 
//			stmt.setString(3, rv.getDepartment());
// 
//			stmt.setString(4, rv.getEmail());
//			stmt.setLong(5, rv.getPhone());
// 
//			stmt.setInt(6,  rv.getId());
//			 
//			
//		 
//			int rs=stmt.executeUpdate();
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

