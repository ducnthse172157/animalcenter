<%-- 
    Document   : managepet
    Created on : Oct 24, 2023, 7:32:51 PM
    Author     : huudu
--%>

<%@page import="java.util.List"%>
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
        </nav>
    <h4><a href="MainServlet?action=ADDPETPAGE">Add Pet</a></h4>
    <body>       
        
         <h1>All your pet</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>TYPE</th>
                <th>STATUS</th>
            </tr>
            <% 
                List<Pet> list=(List<Pet>) request.getAttribute("INFO");
                for (Pet p : list) {
                    if(p.getStatus().equals("Fit")){
             %>
                <tr>
                    <td><%= p.getPetId()%></td>
                    <td><%= p.getPetName()%></td>
                    <td><%= p.getPetType()%></td>
                    <td><%= p.getStatus()%></td>
                    <td><a href="GetPetServlet?pid=<%= p.getPetId()%>">Update</a>
                        <a href="DeletePetServlet?pid=<%= p.getPetId()%>">Remove</a></td>
                </tr>
              <%
            }
         }
        %>
        </table>
        <p><a href="MainServlet?action=HOME">Home</a></p>
    </body>
</html>
