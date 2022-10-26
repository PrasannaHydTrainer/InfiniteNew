<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="PostQuestion.jsp">
		<center>
			Question : 
			<input type="text" name="qname" /> <br/><br/> 
			<input type="submit" value="Post Question" />
		</center>
	</form>
	<c:if test="${param.qname!=null}">
		<jsp:useBean id="beanDao" class="com.infinite.hib.QuestionDAO"/>
		<jsp:useBean id="beanQuestion" class="com.infinite.hib.Question"/>
		<jsp:setProperty property="*" name="beanQuestion"/>
		<c:out value="${beanDao.addQuestion(beanQuestion)}"/>
	</c:if>
</body>
</html>