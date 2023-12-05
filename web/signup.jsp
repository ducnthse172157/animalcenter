<%-- 
    Document   : signup
    Created on : Oct 1, 2023, 4:20:58 PM
    Author     : huudu
--%>

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
    <script>
        function checkPassword() {
            if (document.getElementById("txtpwd").value !== document.getElementById("txtrepwd").value) {
                alert("password is invalid");
                return false;
            }
            return true;
        }

    </script>
    <body>
        <h1>Customer Sign Up</h1>
        <form action="MainServlet?action=SIGNUP" method="post" >
            <label>Customer id *</label><br>
            <input type="text" name="txtcusid" required><br>
            <label>Full Name *</label><br>
            <input type="text" name="txtcusname" required><br>
            <label>Password *</label><br>
            <input type="password" id="txtpassword" name="txtpwd" required><br>
            <label>Confirm Password *</label><br>
            <input type="password" id="txtrepassword" name="txtrepwd" required><br>
            <label>Phone Number *</label><br>
            <input type="text" name="txtphone" required=""><br><br>
            <input type="submit" value="Register" onclick="return checkPassword()">
        </form>
        <%
            String s = (String) request.getAttribute("THONGBAO");
            if (s != null) {
                out.print("<h1>" + s + "</h1>");
            }
        %>
        <p>You already have a account ? <a href="MainServlet?action=''">Login</a></p>
    </body>
</html>
