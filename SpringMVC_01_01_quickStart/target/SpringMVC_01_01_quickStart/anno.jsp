<%--
  Created by IntelliJ IDEA.
  User: 唐绍权
  Date: 2020/3/22
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/anno/ReqyestParam?name=呵呵">ResquestParam</a>
<form action="/anno/RequestBody" method="post">
    用户姓名：<input type="text" name="name">
    用户密码：<input type="text" name="passd">
    <input type="text" name="birthday">

    提交：<input type="submit" value="提交">

</form>

<a href="/anno/RequestHeader">ResquestParam</a>

<a href="/anno/CookieValue">CookieParam</a>

<br>

<form action="/anno/ModelAttribute" method="post">
    用户姓名：<input type="text" name="name">
    用户密码：<input type="text" name="passd">

    提交：<input type="submit" value="提交">

</form>
<br>
<a href="/anno/SessionAttributes">SessionAttributes</a>
<a href="/anno//getSessionAttributes">getSessionAttributes</a>
<a href="/anno//delSessionAttributes">getSessionAttributes</a>

</body>
</html>
