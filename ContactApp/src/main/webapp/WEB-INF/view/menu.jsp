<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.userId == null}">
<%-- User is not yet logged in: Guest menu --%>
<a href="#">Home</a>
<a href="#">Login</a>
<a href="#">Register</a>
<a href="/about" target="_blank">About</a>
</c:if>
<c:if test="${sessionScope.userId != null && sessionScope.role == 1}">
<%-- Admin is logged in:admin Name --%>
<a href="#">Home</a>
<a href="#">UserList</a>
<a href="#">Logout</a>
"${sessionScope.name}"
</c:if>
<c:if test="${sessionScope.userId != null && sessionScope.role == 2}">
<%-- User logged in :username --%>
<a href="#">Home</a>
<a href="#">Add Contact</a>
<a href="#">Contact List</a>
<a href="#">Logout</a>
<%--${sessionScope.name} --%>
${sessionScope.user.getName() }
</c:if>
</body>
</html>