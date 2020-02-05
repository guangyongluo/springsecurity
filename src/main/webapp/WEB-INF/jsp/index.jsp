<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>商城首页</title>
</head>
<body>
欢迎${username}访问本站 <br/>
以下是网站功能：<br/>
<security:authorize access="hasRole('ROLE_ADD_PRODUCT')">
    <a href="${pageContext.request.contextPath}/product/add">商品添加</a><br/>
</security:authorize>
<security:authorize access="hasRole('ROLE_UPDATE_PRODUCT')">
    <a href="${pageContext.request.contextPath}/product/update">商品修改</a><br/>
</security:authorize>
<security:authorize access="hasRole('ROLE_LIST_PRODUCT')">
    <a href="${pageContext.request.contextPath}/product/list">商品查询</a><br/>
</security:authorize>
<security:authorize access="hasRole('ROLE_DELETE_PRODUCT')">
    <a href="${pageContext.request.contextPath}/product/delete">商品删除</a><br/>
</security:authorize>
</body>
