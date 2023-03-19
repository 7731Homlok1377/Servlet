<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Lab3</title>

</head>
<body>
<%= new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()) %>
<h1> Directory: ${requestScope.d} </h1>
<% String str = request.getAttribute("d")%>
<%= str %>

<table>
    <tr>
        <th></th>
        <th>Файл</th>
        <th>Размер</th>
        <th>Дата</th>
    </tr>
</table>

</body>
</html>