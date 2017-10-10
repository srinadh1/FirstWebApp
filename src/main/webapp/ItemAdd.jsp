<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table,th,tr,td{
 border: 1px solid black;
    background-color: #f1f1c1;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="obj"  scope="application" class="com.sri.servlets.Item"/>  

<jsp:setProperty property="*" name="obj"/>
<table width="65%">
<tr>

<td><jsp:getProperty property="barcode" name="obj"/></td>
<td><jsp:getProperty property="name" name="obj"/></td>
<td><jsp:getProperty property="price" name="obj"/></td>
<td><jsp:getProperty property="quantity" name="obj"/></td>
</tr>
</table>
</body>
</html>