
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <form action="${pageContext.request.contextPath}/article/new" method="post" class="article-form">
            <h2 class="article-title">Dodaj ciekawostkę</h2>
            <input name="title" placeholder="Tytuł" required>
            <input name="url" placeholder="URL" type="url" required>
            <select name="categoryId">
                <c:forEach var="category" items="${requestScope.categories}">
                    <option value="${category.id}">${category.name} </option>
                </c:forEach>
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
