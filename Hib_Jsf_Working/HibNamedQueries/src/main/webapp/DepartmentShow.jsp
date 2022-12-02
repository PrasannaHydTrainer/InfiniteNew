<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="beanDao" class="com.infinite.hib.EmployDAO"/>
	<form method="get" action="DepartmentShow.jsp">
		<center>
			Department : 
			<input type="text" name="dept" /> <br/><br/> 
			Basic : 
			<input type="number" name="basic" /> <br/><br/>
			<input type="submit" value="Show" /> 
		</center>
	</form>
	<c:if test="${param.dept!=null && param.basic!=null}">
		<c:set var="dept" value="${param.dept}"/>
		<c:set var="basic" value="${param.basic}"/>
	<table border="3" align="center">
	<tr>
		<th>Employ No</th>
		<th>Employ Name</th>
		<th>Department</th>
		<th>Designation</th>
		<th>Basic</th>
	</tr>
	<c:forEach var="employ" items="${beanDao.showDepartments(dept,basic)}">
		<tr>
			<td>${employ.empno}</td>
			<td>${employ.name}</td>
			<td>${employ.dept}</td>
			<td>${employ.desig}</td>
			<td>${employ.basic}</td>
		</tr>
	</c:forEach>
	</table>
		
	</c:if>
</body>
</html>