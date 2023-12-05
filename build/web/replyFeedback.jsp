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
                            <h2>Reply <b>FEEDBACK</b></h2>
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
                        <form action="ReplyFeedbackServlet" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Reply</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><a href="FeedbackServlet">&times;</a></button>
                            </div>
                            
    
                            
                            
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Feedback ID</label>
                                    <input value="${detail.feedbackID}" name="fe_id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Customer name</label>
                                    <input value="${detail.customerID}" name="cus_name" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Order ID</label>
                                    <input value="${detail.orderID}" name="ord_id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Content</label>
                                    <input value="${detail.content}" name="content" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Created date</label>
                                    <input value="${detail.createDate}" name="date" type="text" class="form-control" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Reply</label>
                                    <input value="${detail.reply}" name="reply" type="text" class="form-control">
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