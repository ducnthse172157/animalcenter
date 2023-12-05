<%-- 
    Document   : homepage
    Created on : Oct 1, 2023, 3:00:50 PM
    Author     : huudu
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dto.Service"%>
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

                <%Customer cus = (Customer) session.getAttribute("USER");
                    if (cus != null) {
                        out.print(" <li class='nav-item'><a class='nav-link'>" + cus.getCustomername() + "</a></li>");
                        out.print("<a class='nav-link' href='MainServlet?action=LOGOUT'> logout</a>");
                    } else {
                        response.sendRedirect("MainServlet?action=''");
                    }
                %>    



            </ul>
            <form action="MainServlet?action=SEARCH" method="post" value="<%= (request.getParameter("keyword") != null ? request.getParameter("keyword") : "")%>">
                <div class="input-group input-group-sm">
                    <input name="txtsearch" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search Service...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>
        </nav> 
            <div class="container mt-4">
                <div class="row">
                    <div class="col-sm-4 bg-dark">
                        <h4><a href="MainServlet?action=MANAGEPET">Manage Pet</a></h4>
                        <h4><a href="MainServlet?action=VIEWBOOKING">View Booking Order</a></h4>
                        <h4><a href="MainServlet?action=ORDERHISTORY">View All Orders</a></h4>
                    </div>
                    <div class="col-sm-8">
                        <% String error = (String) request.getAttribute("ERROR");
                            if (error != null) {
                                out.print(error);
                            }
                        %>

                        <div class="row">
                            <% ArrayList<Service> list = (ArrayList) request.getAttribute("result");
                                if (list != null) {
                                    for (Service s : list) {
                            %>
                            <div class="col-sm-4">
                                <form action="AddServiceServlet" method="post">
                                    <input type="hidden" value="<%= s.getServiceId()%>" name="txtserid">
                                    <input type="hidden" value="<%= s.getServiceName()%>" name="txtsername">
                                    <input type="hidden" value="<%= s.getPrice()%>" name="txtprice">
                                    <input type="hidden" value="<%= s.getStatus()%>" name="txtstatus">

                                    <p>
                                        ID: <%= s.getServiceId()%>
                                        <br>NAME: <%= s.getServiceName()%>
                                        <br>PRICE: <%= s.getPrice()%>
                                        <br>STATUS: <%= s.getStatus()%>
                                        <br><input type="submit" value="Booking">
                                    </p>
                                </form>
                            </div>
                                <%
                                        }
                                    }
                                %>
                            </div> 
                        </div>
                    </div> 
                </div>
            </div>
    </body>
</html>
