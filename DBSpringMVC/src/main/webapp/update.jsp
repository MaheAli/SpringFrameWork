<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.sql.*" %>
<%

		String url = "jdbc:mysql://localhost:3306/demo";
		String u = "root";
		String p = "root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,u,p);  
			PreparedStatement stmt=con.prepareStatement("Update Employee set First_Name=?,Last_Name=?,Salary=? where ID=?;");  
			//stmt.setString(1, "ID");
			stmt.setString(1, request.getParameter("ID"));
			stmt.setString(2, request.getParameter("First_Name"));
			stmt.setString(3, request.getParameter("Last_Name"));
			stmt.setString(4, request.getParameter("Salary"));
			
			int rs = stmt.executeUpdate();
			//if(rs.next())
			//{
				%>
				Deleted Successfully.Go to Employee data <a href=display.jsp"> here</a>
				
				<%
			//}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
%>
</body>
</html>