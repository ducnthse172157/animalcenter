<%-- 
    Document   : Show
    Created on : Oct 20, 2023, 9:11:37 PM
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
        <p><a href="MainServlet?action=ADMIN">Home</a></p>
        <p>--------------------------------------------------</p>
        <!--        listService o ServiceServlet-->
        <c:forEach items="${listS}" var="x">
            
            <p>Service id: ${x.serviceId}</p>
            <p>Service name: ${x.serviceName}</p>
            <p>Price: ${x.price}</p>
            <p>Status: ${x.status}</p>
            
            <!--loi o day can nghien cuu sau-->
            
            <c:if test="${x.status == 'Available'}">
                <button>
                    <a href="UpdateServlet2?serviceId=${x.serviceId}&newStatus=Disable" title="Change status">Disable</a>
                </button>
            </c:if>
            
            <c:if test="${x.status == 'Disable'}">
                <button>
                    <a href="UpdateServlet2?serviceId=${x.serviceId}&newStatus=Available" title="Change status">Available</a>
                </button>   
            </c:if>
                
            
            <button>
                    <a href="LoadServiceServlet?serviceId=${x.serviceId}">Update</a>
            </button>
            

            <p>---------------</p>


        </c:forEach>
            
        
        
        <a href="manageServicePrice.jsp">Manage Service's price</a>
            


        <form action="addServlet" method="post">
            <label>ID</label>
            <input name="id" type="text" required><br>
            <label>Name</label>
            <input name="name" type="text" required><br>
            <label>Price</label>
            <input name="price" type="text" required><br>
            <label>Status</label>
            <select name="status">
                <option>Available</option>
                <option>Disable</option>
            </select>
            <input type="submit" value="Add">
        </form>

    </body>
</html>
