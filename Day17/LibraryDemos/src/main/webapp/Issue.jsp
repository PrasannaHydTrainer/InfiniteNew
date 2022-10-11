<%@page import="com.infinite.library.LibraryDAO"%>
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
	LibraryDAO dao = new LibraryDAO();
	String[] id = request.getParameterValues("bookid");
	String user = (String)session.getAttribute("user");
	for(String s : id) {
		int bid = Integer.parseInt(s);
		out.println(dao.issueBook(user, bid));
		out.println("<br/>");
	}
%>
</body>
</html>