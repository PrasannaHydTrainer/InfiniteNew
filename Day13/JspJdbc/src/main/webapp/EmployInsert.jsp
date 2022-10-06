<%@page import="com.infinite.jdbc.Employ"%>
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
	<form method="get" action="EmployInsert.jsp">
		<center>
			Employ Name : 
			<input type='text' name='name' /> <br/><br/> 
			Department : 
			<input type="text" name="dept" /> <br/><Br/> 
			Designation : 
			<input type="text" name='desig' /> <br/><br/>
			Basic : 
			<input type="number" name="basic" /> <br/><br/>
			<input type="submit" value="Insert" /> 
		</center>
	</form>
	<%
	if (request.getParameter("basic")!=null) {
		EmployDAO dao = new EmployDAO();
		Employ employ = new Employ();
		employ.setName(request.getParameter("name"));
		employ.setDept(request.getParameter("dept"));
		employ.setDesig(request.getParameter("desig"));
		employ.setBasic(Integer.parseInt(request.getParameter("basic")));
		dao.addEmploy(employ);
	%>
		<jsp:forward page="EmployTable.jsp" />
	<%
		}	
	%>
</body>
</html>