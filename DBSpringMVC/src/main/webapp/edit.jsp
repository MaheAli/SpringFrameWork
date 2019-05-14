<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.Connection , java.sql.DriverManager, java.sql.*,  java.sql.ResultSet"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post"> 
<h3>
UPDATE EMPLOEE DETAILS
</h3>
	<%
try
{
 
	
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/demo";
String u="root";
String p="root";
String query="select * from Employee where ID=?";
Connection con=DriverManager.getConnection(url,u,p);
PreparedStatement stmt=con.prepareStatement(query);
stmt.setString(1, request.getParameter("ID"));
ResultSet rs=stmt.executeQuery();
while(rs.next())
{
%>

<table border="3">
<tr>
 	<td>ID</td>
 	<td><input class="form-control" type="text" name="ID" id="ID" placeholder="ID" required="required" value='<%=rs.getString("ID") %>'>	</td>
</tr>
<tr>
 	<td>First Name</td>
 	<td><input class="form-control" type="text" name="First_Name" id="fname-txt" placeholder="First name" required="required" value='<%=rs.getString("First_Name") %>'>	</td>
</tr>
<tr>
 	<td>Last Name</td>
 	<td><input class="form-control" type="text" name="Last_Name" id="fname-txt" placeholder="Last Name" required="required" value='<%=rs.getString("Last_Name") %>'>	</td>
</tr>
<tr>
 	<td>Salary</td>
 	<td><input class="form-control" type="text" name="Salary" id="fname-txt" placeholder="Salary" required="required" value='<%=rs.getInt("Salary") %>'>	</td>
</tr>

<%
}
%>
 	
</table><br>
	<input type="submit" value="Update" >
<%
    rs.close();
    stmt.close();
    con.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }

%>
</form>
</body>
</html>