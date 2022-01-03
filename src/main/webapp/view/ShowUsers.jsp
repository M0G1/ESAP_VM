<%@ page import="com.example.esap_vm.model.User" %>
<%@ page import="com.example.esap_vm.model.Drive" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% List<User> users = (List<User>) request.getAttribute("users"); %>
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
        <caption style="caption-side: top">Users</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>User name</th>
            <th>Budget</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (User user : users) { %>
        <tr>
            <td><%= user.getId() %>
            </td>
            <td><%= user.getName() %>
            </td>
            <td><%= user.getBudget() %>
            </td>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/update-user">
                    <input type="hidden" name="userId" value="<%= user.getId() %>">
                    <input type="submit" class="btn btn-primary" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete-user" method="post">
                    <input type="hidden" name="userId" value="<%= user.getId() %>">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>


    <form action="${pageContext.request.contextPath}/create-user" method="get">
        <button class="btn btn-primary">Create student</button>
    </form>
</div>
</body>
</html>
