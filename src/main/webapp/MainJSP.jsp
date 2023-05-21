<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<html>
<head>
<link rel="icon" type="image/png" href="https://img.icons8.com/color/256/pixel-cat.png"/>
<style>

 body{

    background: #000 url(https://klike.net/uploads/posts/2022-11/1669180062_3-32.jpg);
 }
 p.italic {
    font-style: italic;
    color: blue;
    font-size: 150%;
 }
 .pathText {
    color: blue;
 }

 table {
 border:3px #AA98A8  solid;
 }

 .logout-form {
         position: fixed;
         right: 8px;
         top: 8px;
       }

</style >
<title>Кошки правят миром</title>

<p class="italic" style= "background: #FFFFFF; border:3px #AA98A8  solid" face="Arial">Котодень: <%=(new java.util.Date()).toLocaleString()%></p>
</head>
<body>

<br>
    <form action="./files" method="get" >
    <button type="submit" name="path" value=${parents} >
    <span class="Text" style= "font-size: 140%"><img src="https://img.icons8.com/ios-glyphs/256/circled-chevron-up.png" width="40" height="40">Вверх</span>

    </button>

    </form>
    <h1>
    <span class="pathText" style= "background: #FFFFFF; border:3px #AA98A8  solid">${path}</span>
    <hr>
    <table>

        <thead>
        <tr>
            <th style= "background: #FFFFFF; border:3px #AA98A8  solid; font-size: 130%">Файл</th>
            <th style= "background: #FFFFFF; border:3px #AA98A8  solid; font-size: 130%">Размер</th>
            <th style= "background: #FFFFFF; border:3px #AA98A8  solid; font-size: 130%">Дата</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach var="item" items="${files}">
            <tr>
                <td>
                    <c:if test="${item.isFile()}">
                        <form action="./files/download" method="post">
                        <button
                           type="submit"
                           name="path"
                           value="${item.getAbsolutePath()}"
                           >
                            <span class="Text" style= "font-size: 120%"><img src="https://img.icons8.com/color/256/cat-butt.png" width="40" height="30"> ${item.getName()}</span>
                            </button>
                            </form>
                    </c:if>
                    <c:if test="${item.isDirectory()}">
                        <form action="./files" method="get">
                        <button

                            type="submit"
                            name="path"
                            value="${item.getAbsolutePath()}"
                            >
                            <span class="Text" style= "font-size: 120%"><img src="https://img.icons8.com/color/256/cat_in_a_box.png" width="40" height="30"> ${item.getName()}</span>
                            </button>
                            </form>
                    </c:if>
                </td>
                <td style= "background: #FFFFFF; border:3px #AA98A8  solid; font-size: 120%"><c:out value="${item.length()}" /> B</td>
                <td style= "background: #FFFFFF; border:3px #AA98A8  solid; font-size: 120%"><c:out value="${date.format(item.lastModified())}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </button>
        <div class="logout-form">
            <form action="./files/exit"  method="post" accept-charset="UTF-8">
                <button type="submit" class="btn btn-primary btn-block">
                    Выход
                </button>
</body>
</html>