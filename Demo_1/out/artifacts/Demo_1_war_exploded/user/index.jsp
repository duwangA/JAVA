<%--
  Created by IntelliJ IDEA.
  User: Thor
  Date: 2020/8/17
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎登录本系统</h1>
<c:choose>
    <c:if test="${empty sessionScope.sessionUser }">
        滚！
    </c:if>
    <c:if test="${not empty sessionScope.sessionUser}">
        ${sessionScope.sessionUser }
    </c:if>
</c:choose>
</body>
</html>
