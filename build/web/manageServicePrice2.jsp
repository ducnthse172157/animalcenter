<%-- 
    Document   : manageServicePrice
    Created on : Oct 26, 2023, 7:29:42 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ServicePrice" method="post">
            Get the price less than: <input type="text" name="price"><input type="submit"></br>
        </form>
        <a href="ServicePrice1">ASCENDING order</a><br> 
        <a href="ServicePrice2">DESCENDING order</a>
        
        <c:forEach items="${listP2}" var="o">
            <p>Id: ${o.serviceId}</p>
            <p>Name: ${o.serviceName}</p>
            <p>Price: ${o.price}</p>
            <p>Status: ${o.status}</p>
            <p>-----------------------------</p>    
        </c:forEach>
        
        </br>
        
        
        
        
        
        
    </body>
</html>
