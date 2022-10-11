<%@page import="com.infinite.jdbc.EmployDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="AddEmploy.jsp">
		<center>
			Employ Name : 
			<input type="text" name="name" /> <br/><br/>
			Department : 
			<select name="dept">
				<option value="Dotnet">Dotnet</option>
				<option value="Java">Java</option>
				<option value="React">React</option>
				<option value="Angular">Angular</option>
			</select> <br/><br/>
			Designation : 
			<select name="desig">
				<option value="Manager">Manager</option>
				<option value="TeamLead">TeamLead</option>
				<option value="SWE">Software Engineer</option>
			</select> <br/><br/> 
			Basic : 
			<input type="number" name="basic" /> <Br/><br/> 
			<input type="submit" value="Add Employ" />
		</center>
	</form>
	<%
		if (request.getParameter("basic")!=null) {
			EmployDAO dao = new EmployDAO();
	%>
		<jsp:useBean id="beanEmploy" class="com.infinite.jdbc.Employ" scope="page" />
		<jsp:setProperty property="*" name="beanEmploy"/>
	<%=dao.addEmploy(beanEmploy) %>
	<%
		}
	%>
	
</body>
</html>