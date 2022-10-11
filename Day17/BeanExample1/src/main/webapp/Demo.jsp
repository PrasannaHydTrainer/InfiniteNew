<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="beanDemo" class="com.infinite.beans.DemoBean" scope="page"/>
Default Message : 
<jsp:getProperty property="greeting" name="beanDemo"/> <br/><br/>
<jsp:setProperty property="greeting" name="beanDemo" value="Good Afternoon..."/>
<br/><hr/>
Updated Message : 
<jsp:getProperty property="greeting" name="beanDemo"/> <br/><br/>

</body>
</html>