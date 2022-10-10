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
<form method="post" action="login.jsp">
<center>
<h2>Please Login :</h2>
Username : <input type="text" name="username" size="50"> <br/><br/>
Password : <input type="password" name="pass" size="50"> <br/><br/>
<input type="submit" value="Login">
</center>
</form>
<%
	if (request.getParameter("username")!=null && 
		request.getParameter("pass")!=null) {
		String user = request.getParameter("username");
		String pwd = request.getParameter("pass");
		LibraryDAO dao = new LibraryDAO();
		int count = dao.authenticate(user, pwd);
		if (count==1) {
			session.setAttribute("user", user);
%>
	<jsp:forward page="Menu.jsp"/>
<%
		} else{
%>
	<p>Invalid Credentials</p>
<%
		}
	}
%>
</body>
</html>