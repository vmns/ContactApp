<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<s:url value="resources/static/js/jquery-3.6.0.min.js" var="url_jqlib"/>
<script src="${url_jqlib}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#id_get_time").click(function(){
		  $.ajax({
			  url:'get_time',
			  success:function(data){
				  $("#id_time").html(data);
			  }
		  });
	  });
});
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajax test page</h1>
	<button id="id_get_time">Get server time</button></br>
	<p id="id_time"></p>
	
</body>
</html>