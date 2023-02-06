<%@page import="com.infinite.library.Books"%>
<%@page import="java.util.List"%>
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
	<jsp:include page="Menu.jsp"/>
	<br/>
	<%
		LibraryDAO dao = new LibraryDAO();
		String searchType = request.getParameter("searchtype");
		String searchValue = request.getParameter("searchvalue");
		List<Books> booksList = dao.searchBooks(searchType, searchValue);
	%>
	<form action="Issue.jsp">
	<table border="3" align="center">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Author</th>
			<th>Edition</th>
			<th>Department</th>
			<th>Total Books</th>
			<th>Select</th>
		</tr>
	<%
		for(Books book : booksList) {
			int bid = book.getId();
			int btotal = book.getNoOfBooks();
	%>
		<tr>
			<td> <%=book.getId() %> </td>
			<td><%=book.getName() %> </td>
			<td><%=book.getAuthor() %> </td>
			<td> <%=book.getEdition() %> </td>
			<td><%=book.getDept() %> </td>
			<td><%=book.getNoOfBooks() %> </td>
			<%
				if(btotal > 0) {
			%>
			<td>
			<input type='checkbox' name='bookid' value=<%=book.getId() %> >
			
			 
			</td>
			<%
				}
			%>
		</tr>
	<%
		}
	%>
	</table>
	<input type="submit" value="Issue Book(s)" />
	</form>
</body>
</html>