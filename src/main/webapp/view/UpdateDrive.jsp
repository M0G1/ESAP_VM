<%@ page import="java.util.List" %>
<%@ page import="com.example.esap_vm.model.Drive" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update drive</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<%
    Drive student = (Drive) request.getAttribute("drive");
%>
<div class="container w-50">
    <form method="post" action="${pageContext.request.contextPath}/update-drive">
        <h1>Update drive</h1>

        <br>
        <input type="submit" value="Update" class="btn btn-primary"/>
    </form>
</div>
</body>
</html>
