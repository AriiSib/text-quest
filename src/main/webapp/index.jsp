<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
    <title>Text Quest</title>
</head>
<body>

<h1>Вкатиться в IT: Путь Java-разработчика</h1>

<p>Добро пожаловать в IT, где каждый хочет быть программистом, но не каждый готов страдать. Ты решил стать
    Java-разработчиком?
    Отличный выбор, если ты любишь боль и бессонные ночи.</p>

<p>Первый шаг — выбрать способ обучения. Онлайн-курсы обещают тебе золотые горы за скромную плату, а бесплатные
    материалы?
    Ну, ты точно научишься терпению и выносливости. Ведь что может быть лучше, чем часы видеолекций и тонны
    бессмысленного кода?</p>

<p>В реальности тебя ждут не только платные курсы и бесплатные разочарования, но и попытки написать свой первый проект,
    которые могут закончиться нервным срывом. А уж собеседования! Они проверят твою уверенность в себе и в жизни
    вообще.</p>

<p>Но не волнуйся, у тебя всегда есть опция "сдаться" — одна кнопка, и ты можешь легко найти работу на заводе. Просто,
    не так ли?</p>

<p>Так что, смельчак, настрой свой IDE, запасись кофе и вперед, в этот нелёгкий, но невероятно интересный мир
    Java-разработки!
    Твое приключение начинается прямо сейчас!</p>

<c:choose>
    <c:when test="${empty sessionScope.username}">
        <form action="start" method="post">
            Имя: <input type="text" name="username"><br><br>
            <input type="hidden" name="sessionId" value="${pageContext.session.id}">
            <input type="submit" value="Начать квест">
        </form>
    </c:when>
    <c:otherwise>
        <form action="start" method="post">
            <input type="hidden" name="sessionId" value="${pageContext.session.id}">
            <input type="submit" value="Начать квест">
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
