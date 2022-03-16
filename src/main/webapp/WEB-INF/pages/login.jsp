
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Overheard - Logowanie</title>
    <%@include file="../pageParts/stylesheets.jspf"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
</head>

<body>
<div class="container">
    <%@include file="../pageParts/header.jspf"%>}

    <form action="j_security_check" method="post" class="user-form">
        <h2 class="title">Zaloguj sie na Overheard</h2>
        <input name="j_username" placeholder="Nazwa użytkownika" required>
        <input name="j_password" placeholder="Hasło" type="password" required>
        <button class="confirm-button">Zaloguj</button>
        <p>Nie masz konta? <a href="${pageContext.request.contextPath}/signup">Zarejestruj się</a> </p>
    </form>

    <footer>
        <%@include file="../pageParts/footer.jspf"%>
    </footer>
</div>
</body>
