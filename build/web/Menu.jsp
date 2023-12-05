<%-- 
    Document   : Menu
    Created on : Oct 19, 2023, 8:09:22 PM
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
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home">Shoes</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <!--quyen adimn-->
                        
                        <li class="nav-item">
                            <a class="nav-link" href="#">Manager Account</a>
                        </li>
                        
                        
                        <!--quyen ban-->
                        
                        <li class="nav-item">
                            <a class="nav-link" href="">Manager Product</a>
                        </li>
                        
                        
                        
                            
                            <li class="nav-item">
                                <a class="nav-link" href="#">Hello ${sessionScope.acc.user}</a>
                            </li>
                            <li class="nav-item">
                            <a class="nav-link" href="logout">Logout</a>
                            </li>
                        
                        
                        
                        
                            <li class="nav-item">
                            <a class="nav-link" href="Login.jsp">Login</a>
                            </li>
                        
                    </ul>

                    
                    
<!--                    search theo tieng viet-->
                    <form action="search" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="show">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">3</span>
                        </a> 
                    </form>
                </div>
            </div>
        </nav>
        <!--        This is the end of nar-bar-->
        <!--        This is the end of nar-bar-->
        
        <!--        This is the start of introduction-->
        <!--        This is the start of introduction-->
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Siêu thị giày chất lượng cao</h1>
                <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm giày nhập từ Trung Quốc</p>
            </div>
        </section>
        
        
         <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Category</a></li>
                            <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </body>
</html>
