<%@ page import="com.example.esap_vm.model.*" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drives</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% List<Drive> drives = (List<Drive>) request.getAttribute("drives"); %>
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
        <caption style="caption-side: top">Drives</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>Duration(hours)</th>
            <th>Cost</th>
            <th>Bike id</th>
            <th>Bike Name</th>
            <th>User id</th>
            <th>User Name</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (Drive drive : drives) { %>
        <tr>
            <td><%= drive.getId() %></td>
            <td><%= drive.getHours() %> </td>
            <td><%= drive.getCost() %></td>
            <td><%= drive.getBike().getId() %>
            <td><%= drive.getBike().getBikeName() %>
            <td><%= drive.getUser().getId() %>
            <td><%= drive.getUser().getName() %>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/update-drive">
                    <input type="hidden" name="driveId" value="<%= drive.getId() %>">
                    <input type="submit" class="btn btn-primary" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete-drive" method="post">
                    <input type="hidden" name="driveId" value="<%= drive.getId() %>">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/create-student" method="get">
        <button class="btn btn-primary">Create student</button>
    </form>
</div>
</body>
</html>
