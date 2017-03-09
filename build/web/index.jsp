<%-- 
    Document   : index
    Created on : Mar 8, 2017, 1:12:07 PM
    Author     : TienNN5
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.language}" />
<fmt:setBundle basename="com.shoppingCart.language.shopping" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="title" /> </title>
    </head>
    <body style="background-color: #FFFFCC">
        <h1><fmt:message key="welcome" /></h1>
        
        <hr>
        <jsp:useBean id="prod" class="com.shoppingCart.model.ProductCart" />
        <form  action="Shopping"  name="shoppingForm" method="POST">
            <b><fmt:message key="product" /> </b>
            <select name="products">
                <c:forEach var="p" items="${prod.product}">
                    <option>
                        ${p.getId()}|${p.getName()}|${p.getType()}|${p.getPrice()}
                    </option>
                    
                </c:forEach>
                    
                    <br/> 
                    <br/>
                    <b>Quantity</b>
                    <input type="text" value="1" name="quantity" />
                    <input type="hidden" name="action" value="ADD" />
                    <input type="submit" name="Submit" value="<fmt:message key="btnAdd" />"
            </select>
        </form>
        <p>${msg}</p>
        <jsp:include page="cart.jsp"  flush="true"/>
        
        
    </body>
</html>
