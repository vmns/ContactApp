<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        
        <title>User List - Contact Application </title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            function changeStatus(uid, lstatus){
                //alert(userId+", "+loginStatus);
                $.ajax({
                    url:'change_status',
                    data:{userId:uid, loginStatus:lstatus} ,
                    success: function (data) {  
                        alert(data);
                    }
                });
            }
        </script>
        

    </head>
    
    <body >
        <table border="1" width="80%" align="center">
            <tr>
                <td height="80px">
                    <%-- Header --%>
                    <jsp:include page="header.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="25px">
                    <%-- Menu --%>
                    <jsp:include page="menu.jsp"/>
                </td>
            </tr>
            <tr>
                <td height="350px" valign="top">
                    <%-- Page Content Area--%>
                    <h3>User List</h3>
                    <table border="1">
                        <tr>
                            <th>SR</th>
                            <th>USER ID</th>
                            <th>NAME</th>
                            <th>PHONE</th>
                            <th>EMAIL</th>
                            <th>ADDRESS</th>
                            <th>USERNAME</th>
                            <th>STATUS</th>
                        </tr>
                        <c:forEach var="u" items="${usersList}" varStatus="st">
                            <tr>
                                <td>${st.count}</td>
                                <td>${u.userId}</td>
                                <td>${u.name}</td>
                                <td>${u.phone}</td>
                                <td>${u.email}</td>
                                <td>${u.address}</td>
                                <td>${u.loginName}</td>
                                <td>
                                <select id = "id_${u.userId}" onchange="changeStatus(${u.userId},$(this).val())">
                                <option value="1">Active</option>
                                <option value="2">Block</option>
                                </select>
                                <script>$('#id_${u.userId}').val(${u.loginStatus});</script>
                                
								</td>
                                    
                            </tr>
                        </c:forEach>
                    </table>

                </td>
            </tr>
            <tr>
                <td height="25px">
                    <%-- Footer --%>
                    <jsp:include page="footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</html>
