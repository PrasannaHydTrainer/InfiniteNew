<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="menu.jsp"/><br/><br/>
	<form action="SearchPrint.jsp" method="post">
		Select Search Criteria:
		<br/><br/>
		
		<input type="radio" name="searchtype" value="id" > By Book Id <br/>
		<input type="radio" name="searchtype" value="dept" > By Department <br/>
		<input type="radio" name="searchtype" value="bookname" > By Book Name <br/>
		<input type="radio" name="searchtype" value="authorname" > By Author Name <br/>
		<input type="radio" name="searchtype" value="all" > All Books <br/><br/>
		
		Insert Search Value:
		<input type="text" name="searchvalue" size="10"><br/><br/>
		<input type="submit" value='Search'/>
		
	</form>
</body>
</html>