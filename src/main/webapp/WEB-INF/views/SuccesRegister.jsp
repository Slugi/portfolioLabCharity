<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="<c:url value="/login" />">Zaloguj</a></li>
            <li class="highlighted"><a href="<c:url value="/register" />">Załóż konto</a></li>
        </ul>
        <%@include file="header.jsp"%>
        <%@include file="header-logged.jsp"%>
        <%@include file="header-not-logged.jsp"%>
    </nav>
</header>
<h1>Potwierdź rejestrację klikając w link przesłany w mailu! Pamiętaj żeby go nie zmieniać!</h1>
<a href="<c:url value="/login" />" class="btn btn--without-border active">Logowanie</a>
<%@include file="footer.jsp"%>
</body>
</html>