<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href='<s:url value="/resources/css/style.css"/>' rel="stylesheet" />
<title>Insert title here</title>
</head>

<body>

	<table class="tab" border="1" width="80%" align="center">
		<tr>
			<td height="80px">
				<!-- Header part --> <jsp:include page="header.jsp" />
			</td>
		</tr>
		<tr>
			<td height="25px">
				<!-- Menu part --> <jsp:include page="menu.jsp" />
			</td>
		</tr>
		<tr>
			<td height="350px">
				<!-- content here --> <c:if test="${err!=null}">
					<p>${err}</p>
				</c:if>
				<h3>Save contact</h3> <s:url var="url_save"
					value="/user/save_contact" /> 
					<f:form action="${url_save}" modelAttribute="command">
					<table border="1">
						<tr>
							<td>NAME</td>
							<td><f:input path="name" />
						</tr>
						<tr>
							<td>PHONE</td>
							<td><f:input path="phone" /></td>
						</tr>
						<tr>
							<td>EMAIL</td>
							<td><f:input path="email" /></td>
						</tr>
						<tr>
							<td>ADDRESS</td>
							<td><f:input path="address" /></td>
						</tr>
						<tr>
							<td>REMARKS</td>
							<td><f:input path="remarks" /></td>
						</tr>
						<tr colspan="2" align="right">
							<button>save contact</button>
							<br>
							<a href="#">###</a>
						</tr>
					</table>
				</f:form>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<!-- footer part --> <jsp:include page="footer.jsp" />
			</td>
		</tr>
	</table>
</body>
</html>