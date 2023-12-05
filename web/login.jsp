<%-- 
    Document   : login
    Created on : Oct 1, 2023, 4:20:25 PM
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
    <body>  
        
        <h1>Login</h1>
        <form action="MainServlet?action=LOGIN" method="post" >
            <label>User ID</label>
            <p><input type="text" name="txtcusname"/></p>
             <label>Password</label>
            <p><input type="password" name="txtpwd"/></p>
            <p><input type="submit" value="login"/></p>
        </form>
        <%
            String msg =(String) request.getAttribute("THONGBAO");
            if(msg!=null){
                out.print(msg);
            }
        %>
        <p>You don't have a account ? <a href="MainServlet?action=SIGNUPFORM">Sign up</a></p>
        
        
        
        
    </body>
</html>
