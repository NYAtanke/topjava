<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>

<table border="1">
    <tr>
        <td>Дата / Время</td><td>Описание</td><td>Калории</td><td>Действия</td>
    </tr>

<c:forEach var="MealWithExceed" items="${meals}">
    <tr>
        <td>${MealWithExceed.dateTime}</td>
        <td align="center">${MealWithExceed.description}</td>
        <td>${MealWithExceed.calories}</td>
        <td>
            <a href="<c:url value='/edit-${MealWithExceed.id}-meal' />">Редактировать</a>
            &nbsp
            <a href="<c:url value='/delete-${MealWithExceed.id}-meal' />">Удалить</a>
        </td>
        <%----%>
        <%----%>
        <%--<c:choose>--%>
        <%--<c:when test="${MealWithExceed.exceed}">--%>
            <%--<style>--%>
                <%--{--%>
                    <%--color: #ff0000;--%>
                <%--}--%>
            <%--</style>--%>

            <%--<td>${MealWithExceed.dateTime}</td>--%>
            <%--<td align="center">${MealWithExceed.description}</td>--%>
            <%--<td>${MealWithExceed.calories}</td>--%>
            <%--<td>--%>
                <%--<a href="<c:url value='/edit-${MealWithExceed.id}-meal' />">Редактировать</a>--%>
                <%--&nbsp--%>
                <%--<a href="<c:url value='/delete-${MealWithExceed.id}-meal' />">Удалить</a>--%>
            <%--</td>--%>
        <%--</c:when>--%>
            <%--<c:otherwise>--%>
                <%--<style>--%>
                    <%--{--%>
                        <%--color: #00ff00;--%>
                    <%--}--%>
                <%--</style>--%>

                <%--<td>${MealWithExceed.dateTime}</td>--%>
                <%--<td align="center">${MealWithExceed.description}</td>--%>
                <%--<td>${MealWithExceed.calories}</td>--%>
                <%--<td>--%>
                    <%--<a href="<c:url value='/edit-${MealWithExceed.id}-meal' />">Редактировать</a>--%>
                    <%--&nbsp--%>
                    <%--<a href="<c:url value='/delete-${MealWithExceed.id}-meal' />">Удалить</a>--%>
                <%--</td>--%>
            <%--</c:otherwise>--%>
        <%--</c:choose>--%>
    </tr>
</c:forEach>

</body>
</html>