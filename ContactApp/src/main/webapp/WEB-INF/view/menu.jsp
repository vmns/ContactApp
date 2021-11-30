<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<c:if test="${sessionScope.userId == null}">
<%-- User is not yet logged in: Guest menu --%>
<s:url var="url_reg_form" value="/reg_form"></s:url>
<a href="#">Home</a>
<a href="#">Login</a>
<a href="${url_reg_form}">Register</a>
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
<s:url var="url_logout" value="/logout"/>

<s:url var="url_cform" value="/user/contact_form"></s:url>
<s:url var="url_clist" value="/user/clist"/>
<a href="#">Home</a>
<a href="${url_cform}">Add Contact</a>
<a href="${url_clist}">Contact List</a>
<a href="${url_logout}">Logout</a>
<%--${sessionScope.name} --%>
${sessionScope.user.getName() }
</c:if>
</body>
</html>