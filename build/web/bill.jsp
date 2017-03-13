<%-- 
    Document   : bill
    Created on : Mar 13, 2017, 1:44:31 PM
    Author     : FIA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaction Details Page</title>
    </head>
    <body>
        <jsp:useBean id="prod" class="com.shoppingCart.model.ProductCart" scope="session"/>
        <h1>Payment Details</h1>
        <h3>To ${sessionScope.customerName}</h3>
        <br>
        <table>
            <tr>
                <td><b><fmt:message key="productId" /></b></td>
                <td><b><fmt:message key="productName" /></b></td>
                <td><b><fmt:message key="productType" /></b></td>
                <td><b><fmt:message key="price" /></b></td>
                <td><b><fmt:message key="quantity" /></b></td>
            </tr>

            <c:forEach var="item" items="${sessionScope.prod.getCartItem()}">
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

        <form action="sendEmail" method="POST">
            <input type="button" onclick="window.print()" value="Print">
            <input type="submit" value="Send an email">
            <input type="button" value="Done" onclick="window.location.replace('index.jsp')">
        </form>
    </body>
</html>
