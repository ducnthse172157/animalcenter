<%-- 
    Document   : adminpage
    Created on : Oct 17, 2023, 7:40:53 PM
    Author     : ASUS
--%>
<%@page import="dto.Customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dto.Admin"%>
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


        <!--        <form action="AdminSearchServlet" method="post">                   
                    value o day de luu vao thanh tim kiem
                    <input name="txtSearch" type="text"  placeholder="Search Customer...">
                    <button type="submit"> Search </button>
        
                </form>-->



        <!--        <a href="ServiceServlet">Manage Service</a>
                <br>
        
                <a href="BookingServlet">Manage Booking</a>
                <br>
        
                <a href="FeedbackServlet">Manage feedback</a>-->



        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">s
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <!--quyen adimn-->

                        <li class="nav-item">
                            <a class="nav-link" href="MainServlet?action=MANAGESERVICE">Manage Service</a>
                        </li>

                        <!--quyen ban-->

                        <li class="nav-item">
                            <a class="nav-link" href="BookingServlet">Manage Booking</a>
                        </li>




                        <li class="nav-item">
                            <a class="nav-link" href="FeedbackServlet">Manage Feedback</a>
                        </li>


                        <%Customer cus = (Customer) session.getAttribute("USER");
                            if (cus != null) {
                                out.print(" <li class='nav-item'><a class='nav-link'>" + cus.getCustomername() + "</a></li>");
                                out.print("<a class='nav-link' href='MainServlet?action=LOGOUT'> logout</a>");
                            } else {
                                response.sendRedirect("MainServlet?action=''");
                            }
                        %>    



                    </ul>
                    <!--                    search theo tieng viet-->
                    <form action="MainServlet?action=ADMINSEARCH" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txtSearch" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search Customer...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </nav>



    </body>
</html>
