
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Overheard - Zasłyszane</title>
    <%@include file="../pageParts/stylesheets.jspf"%>
</head>

<body>
<div class="container">
    <header>
        <%@include file="../pageParts/header.jspf"%>
    </header>

    <main>
        <h1 class="category_name">${requestScope.category.name}</h1>
        <p class="category_description">${requestScope.category.description}</p>
        <%@include file="../pageParts/article-list.jspf"%>
    </main>

    <footer>
        <%@include file="../pageParts/footer.jspf"%>
    </footer>
</div>
</body>
</html>