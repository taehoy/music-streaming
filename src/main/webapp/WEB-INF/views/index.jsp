<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>게시판</title></head>
<body>
<h1>게시판 목록</h1>
<a href="/post/new">글쓰기</a>
<ul>
    <c:forEach var="post" items="${posts}">
        <li>
            <a href="/post/${post.id}">${post.title}</a>
            <span>작성자: ${post.author} | 날짜: ${post.createdAt}</span>
        </li>
    </c:forEach>
</ul>
</body>
</html>