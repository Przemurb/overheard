
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Overheard - Zarejestruj się</title>
    <%@include file="../pageParts/stylesheets.jspf"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/add-article.css">
</head>
<body>
    <div class="container">
        <%@include file="../pageParts/header.jspf"%>

        <form action="#" method="post" class="article-form">
            <h2 class="article-title">Dodaj ciekawostkę</h2>
            <input name="title" placeholder="Tytuł" required>
            <input name="url" placeholder="URL" type="url" required>
            <select>
                <option>Biznes</option>
                <option>Rozrywka</option>
                <option>Polityka</option>
            </select>
            <textarea name="content" placeholder="Opis..."></textarea>
            <button class="confirm-button">Dodaj</button>
        </form>

        <footer>
            <%@include file="../pageParts/footer.jspf"%>
        </footer>
    </div>
</body>
</html>
