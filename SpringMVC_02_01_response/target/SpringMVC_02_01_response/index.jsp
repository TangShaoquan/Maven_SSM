<%--
  Created by IntelliJ IDEA.
  User: 唐绍权
  Date: 2020/3/23
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.js"></script>
<%--    <script type="text/javascript" src="js/jquery.min.js"></script>--%>

    <script>
       $(function () {
           $("#btn").click(function () {
               alert("呵呵");
               $.ajax({
                   // 编写json格式，设置属性和值
                   url:"user/testAjax",
                   contentType:"application/json;charset=UTF-8",
                   data:'{"username":"hehe","password":"123","age":30}',
                   dataType:"json",
                   type:"post",
                   success:function(data){
                       // data服务器端响应的json的数据，进行解析
                       alert(data);
                       alert(data.username);
                   }
               });
           })
       });
    </script>
</head>
<body>
    <a href="user/testString">测试返回的是字符串</a>
    <br>
    <a href="user/testVoid">测试返回的空</a>
    <br>
    <a href="user/testModelAndView">测试testModelAndView</a>
    <br>
    <a href="user/testForwardOrRedirect">测试转发或重定向</a>
    <br>
    <button id="btn">发送ajax的请求</button>
</body>
</html>
