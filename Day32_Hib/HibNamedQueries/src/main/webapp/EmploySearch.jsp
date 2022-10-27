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
	<form method="get" action="EmploySearch.jsp">
		<center>
			Employ No : 
			<input type="number" name="empno" /> <br/><br/> 
			<input type="submit" value="Search" />
		</center>
	</form>
	<c:if test="${param.empno!=null}">
	<c:set var="empno" value="${param.empno}"/>
		<c:set var="employ" value="${beanDao.searchEmploy(empno)}"/>
		<c:if test="${employ!=null}">
		Employ No : <b>
			<c:out value="${employ.empno}"/></b> <br/>
		Employ Name : <b>
			<c:out value="${employ.name}"/></b> <br/>
		Department : <b>
			<c:out value="${employ.dept}"/></b> <br/>
		Designation : <b>
			<c:out value="${employ.desig}"/></b> <br/>
		Basic : <b>
			<c:out value="${employ.basic}"/></b> <br/>
		
		</c:if>
	</c:if>
</body>
</html>