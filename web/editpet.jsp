<%-- 
    Document   : editpet
    Created on : Oct 27, 2023, 8:04:54 PM
    Author     : huudu
--%>

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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    </head>

         
    <body>   
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Pet <b>EDIT</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        
                         <%Pet p=(Pet) request.getAttribute("DETAIL");%>
                        <!--chuyen data sang UpdatePetServlet-->
                        <form action="MainServlet?action=UPDATEPET" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Reply</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><a href="MainServlet?action=MANAGEPET">&times;</a></button>
                            </div>
   
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Pet ID</label>
                                    <input type="text" name="id" value="<%= p.getPetId()%>" class="form-control" readonly required/><br>
                                </div>
                                <div class="form-group">
                                    <label>Name</label>
                                    <input type="text" name="txtpetname" value="<%= p.getPetName()%>" class="form-control"/><br>
                                </div>
                                <div class="form-group">
                                    <label>Type</label>
                                    <input type="text" name="txtpettype" value="<%= p.getPetType()%>" class="form-control"/><br>
                                </div>                         

                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Update">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>


        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>
