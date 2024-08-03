<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Final</title>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>

<c:choose>
    <c:when test="${requestScope.success == true}">
        <h1>Победа!</h1>
        <h3>${question}</h3>
    </c:when>
    <c:otherwise>
        <h1>Поражение...</h1>
        <h3>${question}</h3>
    </c:otherwise>
</c:choose>

<button onclick="restart()">Начать игру заново</button>

<script>
    function restart() {
        $.ajax({
            url: 'restart',
            type: 'POST',
            async: false,
            success: function () {
                window.location.href = 'start';
            }
        });
    }
</script>
</body>
</html>
