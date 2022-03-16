
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Overheard - Zasłyszane</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Zasłyszane, serwis społecznościowy o różnych ciekawostkach">
    <meta name="keyword" content="zasłyszane, ciekawostki, komentarze, newsy, plotki">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">

    <link rel="stylesheet" href="./styles/main.css">
    <link rel="stylesheet" href="./styles/fontello.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,400;0,700;0,800;0,900;1,400&display=swap" rel="stylesheet">
</head>

<body>
<div class="container">
    <header>
        <nav class="topbar">
            <a href="${pageContext.request.contextPath}" class="logo">
                <i class="icon-drupal"></i>
                OverHeard - Zasłyszane
            </a>
            <a href="#" class="login">Zaloguj</a>
        </nav>
    </header>
    <aside class="categories">
        <ul>
            <c:forEach var="category" items="${requestScope.categories}">
                <li><a href="${pageContext.request.contextPath.concat('/category?id=').concat(category.id)}">${category.name}</a></li>
            </c:forEach>
        </ul>
    </aside>

    <main>
        <c:forEach var="article" items="${requestScope.articles}">
            <article class="article">
                <h2 class="art-header"><c:out value="${article.title}"/></h2>
                <p class="art-info">Dodane przez Franek, ${article.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))}</p>
                <a href="<c:out value="${article.url}"/>" target="_blank" class="art-link"><c:out value="${article.url}"/></a>
                <p class="art-content"><c:out value="${article.description}"/></p>
                <section class="vote-bar">
                    <a href="#" class="vote-up">
                        <i class="icon-thumbs-up"></i>
                    </a>
                    <p class="votes-number">32</p>
                    <a href="#" class="vote-down">
                        <i class="icon-thumbs-down"></i>
                    </a>
                </section>
            </article>
        </c:forEach>
    </main>

    <footer>OverHeard &copy; developed by Przemysław Urban with JavaStart.pl</footer>
</div>
