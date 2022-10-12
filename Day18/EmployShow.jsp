<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="conn" 
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/infinite"
	user="root"
	password="root"
/>
<sql:query var="employQuery" dataSource="${conn}">
	select * from Employ
</sql:query>

<c:forEach var="employ" items="${employQuery.rows}">
	Employ No : 
	<c:out value="${employ.empno}"/> <br/>
	Employ Name : 
	<c:out value="${employ.name}"/> <br/>
	Department : 
	<c:out value="${employ.dept}"/> <br/>
	Designation : 
	<c:out value="${employ.desig}"/> <br/>
	Basic : 
	<c:out value="${employ.basic}"/> <hr/>
	
</c:forEach>
</body>
</html>