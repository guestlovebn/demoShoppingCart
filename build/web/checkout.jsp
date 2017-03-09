<%-- 
    Document   : checkout
    Created on : Mar 8, 2017, 1:11:58 PM
    Author     : TienNN5
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.language}" />
<fmt:setBundle basename="com.shoppingCart.language.shopping" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="title" /></title>
    </head>
    <body>

        <jsp:useBean id="prod" class="com.shoppingCart.model.ProductCart" scope="session"/>
        <h1><fmt:message key="transaction" /></h1>

        <table>
            <tr>
                <td><b><fmt:message key="productId" /></b></td>
                <td><b><fmt:message key="productName" /></b></td>
                <td><b><fmt:message key="productType" /></b></td>
                <td><b><fmt:message key="price" /></b></td>
                <td><b><fmt:message key="quantity" /></b></td>
            </tr>

            <c:forEach var="item" items="${prod.cartItem}}">
                <tr>
                    <td>${item.getId()}</td>
                    <td>${item.getName()}</td>
                    <td>${item.getType()}</td>
                    <td>${item.getPrice()}</td>
                    <td>${item.getQuantity()}</td>

                </tr>
            </c:forEach>
                <tr>
                    <td></td>
                    <td></td>
                    <td>Total</td>
                    <td>${prod.getAmount()}</td>
                    <td></td>
                </tr>
        </table>
    </body>
</html>
