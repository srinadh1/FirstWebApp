<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList,com.sri.servlets.Item"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
    background-color: #f1f1c1;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Displaying Items</title>
</head>
<body>
<table style="width:60%">
  <%
  ArrayList<Item> items=(ArrayList<Item>)request.getSession().getAttribute("list"); 
	
	 for(Item item:items){%>
		<tr>
		<td><%= item.getName()%></td>
		<td><%= item.getPrice() %></td>
		<td><%= item.getQuantity() %></td>
		</tr>
  <% }%>
</table>
</body>
</html>