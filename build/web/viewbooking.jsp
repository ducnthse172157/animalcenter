<%-- 
    Document   : viewbooking
    Created on : Nov 5, 2023, 9:16:18 PM
    Author     : huudu
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="dto.Service"%>
<%@page import="dto.Pet"%>
<%@page import="dto.Customer"%>
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
    <body>
         <nav class="navbar navbar-expand-md navbar-dark bg-dark">

            <ul class="navbar-nav m-auto">
               

                <%Pet p=(Pet) request.getAttribute("THONGBAO");%>
                 <%Customer cus = (Customer) session.getAttribute("USER");
                    if (cus != null) {
                        out.print(" <li class='nav-item'><a class='nav-link'>" + cus.getCustomername() + "</a></li>");
                        out.print("<a class='nav-link' href='MainServlet?action=LOGOUT'> logout</a>");
                    } else {
                        response.sendRedirect("MainServlet?action=''");
                    }
                %>    


            </ul>
        </nav>
        <h1>Your Booking</h1>
        <%
            HashMap<Service, Integer> order = (HashMap) session.getAttribute("order");
            if (order == null) {
                out.print("you haven't order anthing");

            } else {
        %>
        
        <table>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>PRICE</th>
                <th>DURATION/QUANTITY</th>
            </tr>
            <% float sum = 0;
                for (Service s : order.keySet()) {%>
            <form action="MainServlet?action=UPDATEBOOKING" method="post">
                <input type="hidden" name="txtid" value="<%= s.getServiceId()%>">
                <tr>
                    <td><%= s.getServiceId()%></td>
                    <td><%= s.getServiceName()%></td>
                    <td><%= s.getPrice()%></td>
                    <td><input type="number" value="<%= order.get(s)%>" min="1" max="10" name="txtquantity"></td>
                    <td><input type="submit" value="update" name="btntype">
                        <input type="submit" value="remove" name="btntype"></td>
                </tr></form>
                <%
                        sum = sum + s.getPrice() * order.get(s);
                    }
                %>
        </table>
        <form action="MainServlet?action=SAVEBOOKING" method="post">
            <input type="hidden" name="txttotal" value="<%= sum%>">
            <p>---------------------------------------------</p>
            <p>Total money: <%=sum%>USD</p>
            <p>Pet ID: <input type="text" name="txtpetid" value="<%= (p != null) ? p.getPetId() : ""%>">*</p>
            <p><input type="submit" value="Payment"</p>
        </form>
        <%}%>
        <p>---------------------------------------------</p>
        <p><a href="MainServlet?action=HOME">Home</a></p>

    </body>
</html>
