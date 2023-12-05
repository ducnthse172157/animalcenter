<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
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
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Update <b>Booking</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">


                        <!--chuyen data sang UpdateServlet3-->


                        <form action="UpdateServlet5" method="post">



                            <c:forEach items="${listB}" var="o">

                                <div class="modal-header">						
                                    <h4 class="modal-title">Update Booking</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><a href="BookingServlet">&times;</a></button>
                                </div>




                                <div class="modal-body">	


                                    <div class="form-group">
                                        <label>ID</label>
                                        <input value="${o.orderID}" name="ord_id" type="text" class="form-control" readonly required>
                                    </div>

                                    <div class="form-group">
                                        <label>Pet ID</label>
                                        <input value="${o.petID}" name="pet_id" type="text" class="form-control" required>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Create Date</label>
                                        <input value="${o.createDate}" name="createDate" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Total</label>
                                        <input value="${o.total}" name="total" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Check in Date</label>
                                        <input value="${o.checkinDate}" name="checkin" type="text" class="form-control" >
                                    </div>
                                    <div class="form-group">
                                        <label>Check out Date</label>
                                        <input value="${o.checkoutDate}" name="checkout" type="text" class="form-control" >
                                    </div>

                                    <div class="form-group">
                                        <label>Status</label>
                                        <select name="status" class="form-select" aria-label="Default select example">
                                            <option>Cancel</option>
                                            <option>Deleted</option>
                                        </select>
                                    </div>



                                </div>



                             

                            </c:forEach>

                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Changing">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>


        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>