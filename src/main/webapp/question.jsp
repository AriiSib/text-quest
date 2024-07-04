<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Text Quest</title>
</head>
<body>
<h1>Question</h1>
<p>Question: ${question}</p>
<form action="question" method="post">
        <button type="submit" name="answer" value="${answerId_1}">
            <c:out value="${answer_1}" />
        </button>

        <button type="submit" name="answer" value="${answerId_2}">
            <c:out value="${answer_2}" />
        </button>
</form>
</body>
</html>
