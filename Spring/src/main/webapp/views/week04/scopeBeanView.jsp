<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="smsArray" items="${scopeBeanArray}" varStatus="status">
		<c:forEach var="sms" items="${smsArray}" varStatus="status">
			${status.count} : <c:out value="${sms}"/><br>
		</c:forEach>
		<c:out value="==================================="/><br>
	</c:forEach>

</body>
</html>