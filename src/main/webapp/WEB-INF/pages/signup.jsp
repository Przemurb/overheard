
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Overheard - Zarejestruj się</title>
    <%@include file="../pageParts/stylesheets.jspf"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
</head>

<body>
    <div class="container">
        <%@include file="../pageParts/header.jspf"%>

        <form action="${pageContext.request.contextPath}/signup" method="post" class="user-form">
            <h2 class="title">Zarejestruj sie na Overheard</h2>
            <input name="username" placeholder="Nazwa użytkownika" required>
            <input name="email" placeholder="email" type="email" required>
            <input name="password" placeholder="Hasło" type="password" required>
            <button class="confirm-button">Zarejestruj się</button>
        </form>

        <footer>
            <%@include file="../pageParts/footer.jspf"%>
        </footer>
    </div>
</body>
