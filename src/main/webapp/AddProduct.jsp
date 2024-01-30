<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="post">
	<fieldset>
		<legend><h2>Enter Product Detail's</h2></legend>
		<input type="number" placeholder="Enter Product-Id" name="productId" required autofocus="autofocus">
		<br><br>
		<input type="text" placeholder="Enter Product-Name" name="productName">
		<br><br>
		<input type="number" placeholder="Enter Product-Price" step="0.01" name="productPrice">
		<br><br>
		<input type="submit" value="ADD">
		<input type="submit" value="BACK">
	</fieldset>	
	</form>
</body>
</html>