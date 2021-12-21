<%@ page import="java.util.List" %>
<%@ page import="com.example.esap_vm.model.Bike" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bikes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% List<Bike> bikes = (List<Bike>) request.getAttribute("bikes"); %>
<div class="container">
    <ul class="nav justify-content-center">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/bikes">Show bikes</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/drives">Show drives</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/users">Show users</a>
        </li>
    </ul>
    <table class="table table-striped table-dark table-hover">
        <caption style="caption-side: top">Bikes</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>bike name</th>
            <th>cost per hour</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (Bike bike : bikes) { %>
        <tr>
            <td><%= bike.getId() %>
            </td>
            <td><%= bike.getBikeName() %>
            </td>
            <td><%= bike.getPrice()%>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/update-bike">
                    <input type="hidden" name="bikeId" value="<%= bike.getId() %>">
                    <input type="submit" class="btn btn-primary" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete-bike" method="post">
                    <input type="hidden" name="bikeId" value="<%= bike.getId() %>">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/create-bike" method="get">
        <button class="btn btn-primary">Create bike</button>
    </form>
</div>
</body>
</html>
