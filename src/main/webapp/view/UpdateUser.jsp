<%@ page import="com.example.esap_vm.model.User" %>
<%@ page import="com.example.esap_vm.model.Drive" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% User user = (User) request.getAttribute("user"); %>
<div class="container w-50">
    <form method="post" action="${pageContext.request.contextPath}/update-user">
        <h1>Update user</h1>
        <input type="hidden" name="userId" value="<%= user.getId() %>">
        <div class="form-group">
            <label for="userName">User name: </label>
            <input class="form-control" id="userName" name="userName" type="text" value="<%= user.getName() %>"
                   required/>
        </div>
        <div class="form-group">
            <label for="budget">Budget: </label>
            <input class="form-control" id="budget" name="budget" type="number" min="0" value="<%= user.getBudget()%>>"
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
        <% for (Drive drive : user.getDrives()) { %>
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