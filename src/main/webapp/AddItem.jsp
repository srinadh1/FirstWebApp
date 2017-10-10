<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item Form</title>
</head>
<body>
<form method='post' action='/FirstWebApp/AddItem'>
<p>Customer ID:</p>
<input type="text" name="id">
<p>Customer Name:</p> 
<input type="text" name="name">
<p>Price:</p>
<input type="text" name="price">
<p>Quantity:</p>
<input type="text" name="quantity">
<input type="submit" value="SUBMIT">
</form>
</body>
</html>