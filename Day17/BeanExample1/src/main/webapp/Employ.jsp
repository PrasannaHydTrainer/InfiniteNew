<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="beanEmploy" class="com.infinite.beans.Employ" scope="page" />
	<jsp:setProperty property="*" name="beanEmploy"/>
	Employ No : <jsp:getProperty property="empno" name="beanEmploy"/> <br/>
	Employ Name : <jsp:getProperty property="name" name="beanEmploy"/> <br/>
	Department : <jsp:getProperty property="dept" name="beanEmploy"/> <br/>
	Designation : <jsp:getProperty property="desig" name="beanEmploy"/> <br/>
	Basic : <jsp:getProperty property="basic" name="beanEmploy"/> <br/>
</body>
</html>