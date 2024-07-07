<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <title>Text Quest</title>
</head>

<body>
<h1>${question}</h1>
<br>
<form action="question" method="post">
    <button type="submit" name="answer" value="${answerId_1}">
        <c:out value="${answer_1}"/>
    </button>

    <button type="submit" name="answer" value="${answerId_2}">
        <c:out value="${answer_2}"/>
    </button>
</form>

<table border="1">
    <caption><h2>Статистика</h2></caption>
    <tr>
        <th>Имя в игре</th>
        <th>Попытка №</th>
    </tr>
    <tr>
        <td>${sessionScope.username}</td>
        <td>${sessionScope.attemptsCount}</td>
    </tr>
</table>

</body>
</html>
