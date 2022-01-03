<%@ page import="com.example.esap_vm.model.Bike" %>
<%@ page import="com.example.esap_vm.model.Drive" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% Bike bike = (Bike) request.getAttribute("bike"); %>
<div class="container w-50">
    <form method="post" action="${pageContext.request.contextPath}/update-bike">
        <h1>Update bike</h1>
        <input type="hidden" name="bikeId" value="<%= bike.getId() %>">
        <div class="form-group">
            <label for="bikeName">Bike name: </label>
            <input class="form-control" id="bikeName" name="bikeName" type="text" value="<%= bike.getBikeName() %>"
                   required/>
        </div>
        <div class="form-group">
            <label for="price">Price: </label>
            <input class="form-control" id="price" name="price" type="number" min="1" value="<%= bike.getPrice()%>>"
                   required/>
        </div>
        <br>
        <input type="submit" value="Update" class="btn btn-primary"/>
    </form>
    <br>
    <br>
    <table class="table table-striped table-dark table-hover">
        <caption style="caption-side: top">Drives</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>Duration(hours)</th>
            <th>Cost</th>
        </tr>
        </thead>
        <tbody>
        <% for (Drive drive : bike.getDrives()) { %>
        <tr>
            <td><%= drive.getId() %>
            </td>
            <td><%= drive.getHours() %>
            </td>
            <td><%= drive.getCost() %>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>