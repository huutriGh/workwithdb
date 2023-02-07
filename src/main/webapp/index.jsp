<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Create new Employee</h2>
<form action="create" method="post">
    <p>
        <input name="empName" type="text" placeholder="Name">
    </p>
    <p>
        <input name="address" type="text" placeholder="Address">
    </p>
    <p>
        <input name="age" type="number">
    </p>
    <p>
        <input type="submit" value="Create">
    </p>
</form>

</body>
</html>