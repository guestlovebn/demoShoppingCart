<%-- 
    Document   : bill
    Created on : Mar 12, 2017, 11:51:37 AM
    Author     : FIA
--%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="now" class="java.util.Date"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div style="width: 800px;min-height: 600px;border: 1px solid black">
            <table style="width: inherit">
                <thead style="vertical-align: central">
                <h2 style="vertical-align: central">Transaction details</h2>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <p>Customer</p>
                        </td>
                        <td>
                            <p>Email</p>
                        </td>
                        <td>
                            <p>Date</p>
                        </td>
                    </tr>
                    <tr>
                        <c:if test="${requestScope.customer.getEmail!=null}">
                            <td>
                                <p><c:out value="${requestScope.customerName}"/></p>
                            </td>
                            <td>
                                <p><c:out value="${requestScope.customerEmail}"/></p>
                            </td>
                            <td>
                                <p><c:out value="${requestScope.date}"/></p>
                            </td>
                        </c:if> 
                    </tr>
                    <tr>
                        <td><b>Name</b></td>
                        <td><b>Type</b></td>
                        <td><b>Price</b></td>
                        <td><b>Quantity</b></td>
                    </tr>
                    <c:forEach var="item" items="${sessionScope.prod.cartItems}">
                        <tr>
                            <td>${item.getName()}</td>
                            <td>${item.getType()}</td>
                            <td>${item.getPrice()}</td>
                            <td>${item.getQuantity()}</td>                            
                        </tr>
                    </c:forEach>
                    <tr>
                        <td><p>Total cost</p></td>
                        <td><p>Total cost</p></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
