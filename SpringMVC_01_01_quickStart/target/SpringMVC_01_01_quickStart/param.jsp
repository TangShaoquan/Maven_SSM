<%--
  Created by IntelliJ IDEA.
  User: 唐绍权
  Date: 2020/3/21
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>请求参数绑定</h1>
<%--<a href="/param/testparam">超链接</a>--%>
<a href="/param/testparam?username=tsq">超链接</a>


<%--&lt;%&ndash;整个表单&ndash;%&gt;--%>
<%--<form action="/param/saveaccount" method="get">--%>

<%--    用户姓名：<input type="text" name="user.name">--%>
<%--    用户密码：<input type="text" name="user.passd">--%>
<%--    姓名：<input type="text" name="username">--%>
<%--    密码：<input type="text" name="password">--%>
<%--    金额：<input type="text" name="money">--%>
<%--    提交：<input type="submit" value="提交">--%>


<%--</form>--%>

<%--整个表单--%>
<%--演示一下集合，list,map的封装--%>
<%--<form action="/param/saveaccount" method="get">--%>

<%--    姓名：<input type="text" name="username">--%>
<%--    密码：<input type="text" name="password">--%>
<%--    金额：<input type="text" name="money">--%>

<%--    用户姓名：<input type="text" name="list[0].name">--%>
<%--    用户密码：<input type="text" name="list[0].passd">--%>
<%--    用户姓名：<input type="text" name="list[1].name">--%>
<%--    用户密码：<input type="text" name="list[1].passd">--%>

<%--    用户姓名：<input type="text" name="map['one'].name">--%>
<%--    用户密码：<input type="text" name="map['one'].passd">--%>

<%--    用户姓名：<input type="text" name="map['two'].name">--%>
<%--    用户密码：<input type="text" name="map['two'].passd">--%>


<%--    提交：<input type="submit" value="提交">--%>


<%--</form>--%>

<form action="/param/saveuser" method="get">
    用户姓名：<input type="text" name="name">
    用户密码：<input type="text" name="passd">
    <input type="text" name="birthday">

    提交：<input type="submit" value="提交">


</form>
</body>
</html>
