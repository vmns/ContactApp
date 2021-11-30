<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td><jsp:include page="menu.jsp"/></td>
</tr>
<tr><td>
	<h1>contact list page</h1>
	<c:if test="${param.act eq 'del'}">
	<p class="success">contact deleted succesfully</p>
	</c:if>
	<table border="1">
		<tr>
			<th>SR</th>
			<th>CID</th>
			<th>NAME</th>
			<TH>PHONE</TH>
			<TH>EMAIL</TH>
			<TH>ADDRESS</TH>
			<th>REMARKS</th>
			<th>ACTION</th>
		</tr>
		<c:if test="${empty contactList}">
		<tr align="center">
		<td colspan="8" class="error">No records Found</td>
		</tr>
		</c:if>
		<c:forEach var="c" items="${contactList}" varStatus="st">
		<tr>
		<td>${st.count}</td>
		<td>${c.contactId}</td>
		<td>${c.name}</td>
		<td>${c.phone}</td>
		<td>${c.email}</td>
		<td>${c.address}</td>
		<td>${c.remarks}</td>
		<s:url var="url_del" value="/user/del_contact">
		<s:param name="cid" value="${c.contactId}"></s:param>
		</s:url>
		<s:url var="url_edit" value="/user/edit_contact">
		<s:param name="cid" value="${c.contactId}"></s:param>
		</s:url>
		<td><a href="${url_edit}">EDIT </a> |  <a href="${url_del}">DELETE</a></td>
		</tr>
		</c:forEach>
	</table>
	</td>
	</tr>
	<tr>
	<td>
	<jsp:include page="footer.jsp"/>
	</td>
	</tr>
	</table>
</body>
</html>