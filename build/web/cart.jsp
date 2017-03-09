<%-- 
    Document   : cart
    Created on : Mar 8, 2017, 1:11:48 PM
    Author     : TienNN5
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.language}" />
<fmt:setBundle basename="com.shoppingCart.language.shopping" />
<jsp:useBean id="prod" class="com.shoppingCart.model.ProductCart" scope="session"/>

<center>
    <table border="1" bgcolor="lightgreen" cellspacing="0"  cellpadding="0">
        <tr>
            <td><b><fmt:message key="productId" /></b></td>
            <td><b><fmt:message key="productName" /></b></td>
            <td><b><fmt:message key="productType" /></b></td>
            <td><b><fmt:message key="price" /></b></td>
            <td><b><fmt:message key="quantity" /></b></td>
        </tr>
        
        <c:forEach var="item" items="${prod.cartItem}">
            <tr>
                <td>${item.getId()}</td>
                <td>${item.getName()}</td>
                <td>${item.getType()}</td>
                <td>${item.getPrice()}</td>
                <td>${item.getQuantity()}</td>
                <td>
                    <form action="Shopping" name="deleteFrom" method="post">
                        <input type="submit" value="<fmt:message key="delete" />"/>
                        <input type="hidden" name="delItem" value="${item.getId()}"/>
                        <input type="hidden" name="action" value="Delete" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
        <form name="CheckOutForm" method="POST" action="Shopping">
            <input type="hidden" name="action" value="checkout" />
            <input type="submit" value="<fmt:message key="checkout" />" name="checkout" />
        </form>
</center>