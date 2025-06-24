<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>글쓰기</title></head>
<body>
<h1>글쓰기</h1>
<form action="/post" method="post">
    제목: <input type="text" name="title"/><br/>
    내용: <textarea name="content"></textarea><br/>
    작성자: <input type="text" name="author"/><br/>
    <button type="submit">등록</button>
</form>
</body>
</html>