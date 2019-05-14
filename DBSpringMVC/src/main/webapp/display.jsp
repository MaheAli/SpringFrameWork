<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Info</title>
</head>
<body>

</body>
<form method="post">
 <%--  Welcome ${uname} <br> <br> --%>

<h3>Employee Details</h3> <br>
<table border="2">
<tr>
<td>ID</td>
<td>First NAME</td>
<td>Last_Name</td>
<td>Salary</td>
</tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost/demo";
String username="root";
String password="root";
String query="select * from Employee where flag=1";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();

ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
    <tr>
    <td><%=rs.getString("ID") %></td>
    <td><%=rs.getString("First_Name") %></td>
    <td><%=rs.getString("Last_Name") %></td>
    <td><%=rs.getString("Salary") %></td>
    <td><input type="button" onclick="location.href='edit.jsp?ID=<%=rs.getString("ID") %>';" value="Edit" /></td>
    <td><input type="button" onclick="location.href='delete1.jsp?ID=<%=rs.getString("ID") %>';" value="Delete" ></td>
</tr> 

        <%

}
%>
    </table>
    <%
    rs.close();
    stmt.close();
    conn.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }




%>

</form>
</html> 