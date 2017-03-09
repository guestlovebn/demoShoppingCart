<%-- 
    Document   : shoppingError.jsp
    Created on : Mar 8, 2017, 1:12:28 PM
    Author     : TienNN5
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.language}" />
<fmt:setBundle basename="com.shoppingCart.language.shopping" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="title" /></title>
    </head>
    <body>
        <h1><fmt:message key="error" /></h1>
        ${msg}
        <a href="index.jsp" >Home</a>
    </body>
</html>
