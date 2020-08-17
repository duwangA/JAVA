<%--
  Created by IntelliJ IDEA.
  User: Thor
  Date: 2020/8/17
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录</h1>
<p style="color: crimson; font-weight: 900">${msg }</p>
<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
    用户名 : <input type="text" name="username" value="${user.username}"/><br/>
    密 码 :  <input type="password" name="password" value="${user.password}"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
