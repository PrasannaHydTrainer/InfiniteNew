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
	<form method="get" action="EmployInsert.jsp">
		<center>
			Employ Name : 
			<input type="text" name="name" /> <br/><br/>
			Department : 
			<input type="text" name="dept" /> <br/><br/> 
			Designation : 
			<input type="text" name="desig" /> <br/><br/> 
			Basic : 
			<input type="number" name="basic" /> <br/><br/> 
			<input type="submit" value="Insert" />
		</center>
	</form>
	<c:if test="${param.basic!=null}">
		<sql:setDataSource var="conn" 
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/infinite"
	user="root"
	password="root"
/>
<sql:update var="employInsert" dataSource="${conn}">
	Insert into Employ(Name,Dept,Desig,Basic) values(?,?,?,?)
		<sql:param value="${param.name}"/>
		<sql:param value="${param.dept}"/>
		<sql:param value="${param.desig}"/>
		<sql:param value="${param.basic}"/>
</sql:update>
	</c:if>
</body>
</html> 