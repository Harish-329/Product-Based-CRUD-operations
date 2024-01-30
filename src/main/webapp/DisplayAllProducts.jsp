<%@page import="com.jsp.MVCProjects.EntityOrComponent.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend><h1>PRODUCT DETAIL'S</h1></legend>
	
	<% List<Product> list = (List<Product>) request.getAttribute("productslist"); %>
	
		<a href="index.jsp">Go to Main Menu</a>
		<br><br>
	
	<table border="">
		<tr>
			<th>Product-Id</th>
			<th>Product-Name</th>
			<th>Product-Price</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		
	<% for(Product prod : list) 
		   { %>
		<tr>
			<td><%=prod.getProductId()%></td>
			<td><%=prod.getProductName()%></td>
			<td><%=prod.getProductPrice()%></td>
			<td><a href="update?productId=<%=prod.getProductId()%>">U Can Update</a></td>
			<td><a href="delete?productId=<%=prod.getProductId()%>">Can u Delete</a></td>
		</tr>
		<% } %>
	</table>
	</fieldset>
</body>
</html>