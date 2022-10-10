<%@page import="com.infinite.library.LibraryDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.infinite.library.TranBook"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Menu.jsp"/> <br/>
<%
	int bookId;
	String user = (String)session.getAttribute("user");
	List<TranBook> booksList = new LibraryDAO().issueBooks(user);
%>
<form method="get" action="Return.jsp">
<table border="3">
	<tr>
		<th>Book Id</th>
		<th>User Name</th>
		<th>Issued On</th>
		<th>Return</th>
	</tr>
<%
	for(TranBook tbook : booksList) {
		bookId = tbook.getBookId();
%>
	<tr>
		<td><%=tbook.getBookId() %> </td>
		<td><%=tbook.getUserName() %> </td>
		<td><%=tbook.getFromDate() %> </td>
		<td><input type='checkbox' name='bookid' value=<%=bookId %> ></td>
	</tr>
<%
	}
%>
</table>
<input type="submit" value="Return" />
</form>
<%
	if (request.getParameter("bookid")!=null) {
		String[] bid = request.getParameterValues("bookid");
		for(String s : bid) {
			int id = Integer.parseInt(s);
			out.println(new LibraryDAO().returnBooks(user, id));			
		}
	}
%>
</body>
</html>