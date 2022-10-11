<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="beanName" class="com.infinite.beans.NameBean" scope="page" />
	<jsp:setProperty property="firstName" name="beanName"/>
	<jsp:setProperty property="lastName" name="beanName"/>
	First Name : 
	<b>
	<jsp:getProperty property="firstName" name="beanName"/> </b> <br/>
	Last Name : 
	<b>
		<jsp:getProperty property="lastName" name="beanName"/>
	</b>
</body>
</html>