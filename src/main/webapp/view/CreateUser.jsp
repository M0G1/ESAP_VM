<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<div class="container w-50">
    <form method="post" action="${pageContext.request.contextPath}/create-user">
        <h1>Create student</h1>
        <div class="form-group">
            <label for="userName">First name: </label>
            <input class="form-control" id="userName" name="userName" type="text" required/>
        </div>

        <div class="form-group">
            <label for="budget">Year: </label>
            <input class="form-control" id="budget" name="budget" type="number" min="0" required/>
        </div>

        <br>
        <input type="submit" value="Create" class="btn btn-primary"/>
    </form>
</div>
</body>
</html>
