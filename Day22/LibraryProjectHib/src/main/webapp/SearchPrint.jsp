<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.infinite.hib.Books" %>
    <%@ page import="java.util.List" %>
     <%@ page import="com.infinite.hib.LibraryDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menu.jsp"/><br/>
	<c:set var="searchtype" value="${param.searchtype}"/>
	<c:set var="searchvalue" value="${param.searchvalue}"/>
	<jsp:useBean id="beanDao" class="com.infinite.hib.LibraryDAO"/>
		<br/> Select books to issue: <br/> 
	
	<form action="Issue.jsp" method="get">
	<table border='3'>
		<tr>
		 <th>Id </th>
		 <th>Name</th>
		 <th>Author</th>
		 <th>Edition</th>
		 <th>Dept</th>
		 <th>Total Books</th>
		 <th> Select </th>
	    </tr>
	  <c:forEach var="books" items="${beanDao.searchBooks(searchtype,searchvalue)}">
	  	<tr>
	  		<td><c:out value="${books.id}"/> </td>
	  		<td><c:out value="${books.name}"/> </td>
	  		<td><c:out value="${books.author}"/> </td>
	  		<td><c:out value="${books.edition}"/> </td>
	  		<td><c:out value="${books.dept}"/> </td>
	  		<td><c:out value="${books.totalBooks}"/> </td>
	  		<td>
	  			<c:if test="${books.totalBooks > 0}">
	  				<input type="checkbox" name="bookid" value="${books.id}" />
	  			</c:if>
	  		</td>
	  	</tr>
	  </c:forEach>
	 </table>
	 <br/>
	 <input type='submit' value='Issue Books' >
	</form>
</body>
</html>