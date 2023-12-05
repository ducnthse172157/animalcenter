<%-- 
    Document   : viewordered
    Created on : Nov 5, 2023, 9:27:27 PM
    Author     : huudu
--%>


<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
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
    <body>


        <h1>Ordered list</h1>
        <table border="1">
            <tr>
                <th>SERVICE NAME</th>
                <th>DURATION</th>
                <th>TOTAL</th>
                <th>STATUS</th>
            </tr>
            <%
                List<HashMap<String, Object>> list = (List<HashMap<String, Object>>) request.getAttribute("INFO");
                for (HashMap<String, Object> orderData : list) {                
            %>
                <tr>
                    <td><%= orderData.get("ServiceName")%></td>
                    <td><%= orderData.get("Duration")%></td>
                    <td><%= orderData.get("Total")%></td>
                    <td><%= orderData.get("Status")%></td>
                    <td>
                        <a href="CancelOrderServlet?detailID=<%= orderData.get("DetailID")%>">Cancel</a>
                        <a href="feedback.jsp?OrderID=<%= orderData.get("OrderID")%>">feedback</a>
                    </td>
                </tr>
            <%
                }
            %>
        </table>
        <p><a href="MainServlet?action=HOME">Home</a></p>
    </body>
</html>
