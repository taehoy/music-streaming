<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>게시글</title></head>
<body>
<h1>${post.title}</h1>
<p>${post.content}</p>
<p>작성자: ${post.author}</p>
<p>작성일: ${post.createdAt}</p>
<a href="/">목록으로</a>
</body>
</html>
