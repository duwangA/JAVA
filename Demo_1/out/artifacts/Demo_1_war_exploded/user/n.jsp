<%--
  Created by IntelliJ IDEA.
  User: Thor
  Date: 2020/8/17
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function _change() {
            var ele = document.getElementById("verifyCode");
            ele.src="${pageContext.request.contextPath }/VerifyCodeServlet?xxx="+new Date().getTime();
        }
    </script>
</head>
<body>
<h1>注册</h1>
<p style="color: crimson; font-weight: 900">${msg }</p>
<form action="${pageContext.request.contextPath }/nServlet" method="post">
    用户名 : <input type="text" name="username" value="${user.username}"/>${errors.username}<br/>
    密 码 :  <input type="password" name="password" value="${user.password}"/>${errors.password}<br/>
    验证码 : <input type="text" name="verifyCode" value="${user.verifyCode}" size="3"/>
            <img id="verifyCode" src="${pageContext.request.contextPath }/VerifyCodeServlet" border="2"/>
            <a href="javascript:_change()">看不清，换一张</a>${errors.verifyCode}<br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
