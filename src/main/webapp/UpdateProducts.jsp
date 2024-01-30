<%@page import="com.jsp.MVCProjects.EntityOrComponent.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% Product product = (Product)request.getAttribute("ProductsList"); %>

<form action=saveupdate method="post">

<input type="number" value="<%=product.getProductId() %>" readonly="readonly" name="productId">
<br><br>
<input type="text" value="<%=product.getProductName() %>" name="productName">
<br><br>
<input type="number" value="<%=product.getProductPrice() %>" step="0.01" name="productPrice">
<br><br>
<input type="submit" value="UPDATE">

</form>

</body>
</html>