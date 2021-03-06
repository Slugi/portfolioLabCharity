<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
          <li><a href="#">Zaloguj</a></li>
          <li class="highlighted"><a href="#">Załóż konto</a></li>
        </ul>
        <%@include file="header.jsp"%>
        <%@include file="header-not-logged.jsp"%>
      </nav>
    </header>

    <section class="login-page">
      <h2>Załóż konto</h2>
      <form:form method="post" modelAttribute="user">
        <div class="form-group">
          <form:input type="text" name="username" placeholder="Login"  path="username"/>
        </div>
        <div class="form-group">
          <form:input type="email" name="email" placeholder="Email"  path="email"/>
        </div>
        <div class="form-group">
          <form:input type="password" name="password" placeholder="Hasło"  path="password"/>
        </div>
        <div class="form-group">
          <input type="password" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
        <a href="<c:url value="/login" />" class="btn btn--without-border active">Logowanie</a>
          <button class="btn" type="submit">Załóż konto</button>
        </div>
      </form:form>
    </section>

    <%@include file="footer.jsp"%>
  </body>
</html>
