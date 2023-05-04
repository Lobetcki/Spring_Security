<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 27.02.2023
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Common Room</title>
</head>
<body>

    <h1>Common Room</h1>
    <br>
    <br>

    <security:authorize access="hasRole('IT')">
    <input type="button" value="For IT"
           onclick="window.location.href = 'server_Room'">
    Only for IT
    </security:authorize>

    <br>
    <br>
    <security:authorize access="hasRole('Security')">
    <input type="button" value="For security"
           onclick="window.location.href = 'security_Room'">
    Only for Security
    </security:authorize>

    <br>
    <br>
    <security:authorize access="hasRole('Director')">
    <input type="button" value="For director"
           onclick="window.location.href = 'boss_Office'">
    Only for Director
    </security:authorize>

</body>
</html>
