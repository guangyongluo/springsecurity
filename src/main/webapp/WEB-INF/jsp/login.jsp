<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XPRO
  Date: 2020/2/1
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>登入页面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
<h3>登入页面</h3>

<%--<c:if test="${not empty param.error}">--%>
<%--    <font color="red">用户名或密码错误</font>--%>
<%--</c:if>--%>

<form id="loginForm" action="${pageContext.request.contextPath}/securityLogin" method="post">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    验证码:<input type="text" name="imageCode"/><img src="${pageContext.request.contextPath}/imageCode"/><br/>
    记住我:<input type="checkbox" name="remember-me" value="true"><br/>
    <input id="loginBtn" type="button" value="登入"/>
</form>

<script type="text/javascript">
    $(function () {
        $("#loginBtn").click(function () {
            $.post("${pageContext.request.contextPath}/securityLogin", $("#loginForm").serialize(), function (data){
                if(data.userLogin){
                    window.location.href="${pageContext.request.contextPath}/product/index";
                }else{
                    alert("登入失败：" + data.errorMsg);
                    window.location.href="${pageContext.request.contextPath}/userLogin";
                }
                // alert(data);
            }, "json");
        });
    });
</script>
</body>
</html>
