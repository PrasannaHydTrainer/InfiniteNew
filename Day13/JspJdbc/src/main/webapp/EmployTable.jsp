<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.infinite.jdbc.Employ"%>
<%@page import="java.util.List"%>
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
	<%
		EmployDAO dao= new EmployDAO();
		List<Employ> employList = dao.showEmploy();
	%>
	<table border="3">
		<tr>
			<th>Employ No</th>
			<th>Employ Name</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Basic</th>
		</tr>
	<%
		for(Employ employ : employList) {
	%>
		<tr>
			<td><%=employ.getEmpno() %></td>
			<td><%=employ.getName() %></td>
			<td><%=employ.getDept() %></td>
			<td><%=employ.getDesig() %></td>
			<td><%=employ.getBasic() %></td>
			
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>