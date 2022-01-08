<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create drive</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% List<Long> bikeIds = (List<Long>) request.getAttribute("bikeIds"); %>
<% List<Long> userIds = (List<Long>) request.getAttribute("userIds"); %>
<% List<String> bikeNames = (List<String>) request.getAttribute("bikeNames"); %>
<% List<String> userNames = (List<String>) request.getAttribute("userNames"); %>

<div class="container w-50">
    <form method="post" action="${pageContext.request.contextPath}/create-drive">
        <h1>Create Drive</h1>
        <div class="form-group">
            <label for="hour">Hours: </label>
            <input class="form-control" id="hour" name="hour" type="number" min="1" required/>
        </div>
        <div class="form-group">
            <label for="bikeId">Bike id: </label>
            <select class="form-control" id="bikeId" name="bikeId" required>
                <% for (int i = 0; i < bikeIds.size(); ++i)  {%>
                <option value="<%=  bikeIds.get(i) %>"><%= bikeIds.get(i) + " "  + bikeNames.get(i) %>
                </option>
                <%}%>
            </select>
        </div>
        <div class="form-group">
            <label for="userId">User id: </label>
            <select class="form-control" id="userId" name="userId" required>
                <% for (int i = 0; i < userIds.size(); ++i) {%>
                <option value="<%=  userIds.get(i) %>"><%= userIds.get(i) + " "  + userNames.get(i) %>
                </option>
                <%}%>
            </select>
        </div>
        <br>
        <input type="submit" value="Create" class="btn btn-primary"/>
    </form>
</div>
</body>
</html>
