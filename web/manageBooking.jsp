<%-- 
    Document   : manageBooking
    Created on : Oct 26, 2023, 9:16:16 PM
    Author     : ASUS
--%>

<%@page import="dto.Customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
     <h1>PET CENTER No7</h1>
     <nav class="navbar navbar-expand-md navbar-dark bg-dark">

            <ul class="navbar-nav m-auto">
               
                <%Customer cus = (Customer) session.getAttribute("USER");
                    if (cus != null) {
                        out.print(" <li class='nav-item'><a class='nav-link'>" + cus.getCustomername() + "</a></li>");
                        out.print("<a class='nav-link' href='CusLogoutServlet'> logout</a>");
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                %>    



            </ul>
        </nav>
    <body>
         <p><a href="adminpage.jsp">Home</a></p>
        <p>---------------</p>
        <c:forEach items="${listB}" var="o">
            
            <p>Order ID: ${o.orderID}</p>
            <p>Pet ID: ${o.petID}</p>           
            <p>Create Date: ${o.createDate}</p>
            <p>Total: ${o.total}</p>
            <p>Check in Date: ${o.checkinDate}</p>
            <p>Check out Date: ${o.checkoutDate}</p>
            <p>Status: ${o.status}</p>
            ---------------------------------------------------
            <c:if test="${o.status == 'Pending' || o.status =='pending'}">
                <button>
                    <a href="UpdateServlet4?orderId=${o.orderID}&newStatus=Processing" title="Change status">Update Status</a>
                </button>
            </c:if>
            <c:if test="${o.status == 'Processing' || o.status =='processing'}">
                <button>
                    <a href="UpdateServlet4?orderId=${o.orderID}&newStatus=Done" title="Change status">Update Status</a>
                </button>
            </c:if>

            <c:if test="${o.status == 'Cancel' || o.status =='cancel'}">
                <button>
                    <a href="UpdateServlet4?orderId=${o.orderID}&newStatus=Deleted" title="Change status">Update Status</a>
                </button>
            </c:if>

            
            
            
            
            
        </c:forEach>
            <p>--------------</p>
            <p>Change booking information if customer's pet is not fit</p>
            <form action="CheckPetStatusByPetID" method="post">
                <input name="txtpetid" type="text"  id="txtpetid" />
                <input type="submit">              
            </form>
            
            ${THONGBAO}
        

            

        
            
            
    </body>
</html>
