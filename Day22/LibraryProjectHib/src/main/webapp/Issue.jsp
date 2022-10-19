<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<c:forEach var="b" items="${paramValues.bookid}">
		<jsp:useBean id="beanTran" class="com.infinite.hib.TranBook"/>
		<jsp:setProperty property="bookId" name="beanTran" value="${b}"/>
		<jsp:setProperty property="userName" name="beanTran" value="${sessionScope.user}"/>
		<jsp:useBean id="beanDao" class="com.infinite.hib.LibraryDAO"/>
		<c:out value="${beanDao.isseuBook(beanTran)}"/>
	</c:forEach>
</body>
</html>