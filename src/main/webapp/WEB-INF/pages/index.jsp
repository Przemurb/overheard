
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Overheard - Zasłyszane</title>
    <%@include file="../pageParts/stylesheets.jspf"%>>
</head>

<body>
<div class="container">
    <header>
        <%@include file="../pageParts/header.jspf"%>
    </header>

    <aside class="categories">
        <ul>
            <c:forEach var="category" items="${requestScope.categories}">
                <li><a href="${pageContext.request.contextPath.concat('/category?id=').concat(category.id)}">${category.name}</a></li>
            </c:forEach>
        </ul>
    </aside>

    <main>
        <%@include file="../pageParts/article-list.jspf"%>
    </main>

    <footer>
        <%@include file="../pageParts/footer.jspf"%>
    </footer>
</div>
</body>
</html>