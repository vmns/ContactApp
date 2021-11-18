<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href='<s:url value="/resources/css/style.css"/>' rel="stylesheet" />
</head>
<body>
	<table class="tab" border="1" width="100%" align="center">
		<tr>
			<td><jsp:include page="header.jsp" /></td>
		</tr>
		<tr>
			<td><jsp:include page="menu.jsp" /></td>
		</tr>
		<tr>
			<td>
				<h1>welcome to user dashboard</h1>
				<h2>User To do's</h2>
			</td>
		</tr>
		<tr>
		<td>
		<jsp:include page="footer.jsp"></jsp:include>
		</td>
		</tr>
	</table>


</body>
</html>