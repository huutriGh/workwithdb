<%--
  Created by IntelliJ IDEA.
  User: nguyen huu tri
  Date: 05/02/2023
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<h2>Edit Employee</h2>
<form action="update" method="post">
    <p>
        <input name="id" type="hidden" value="${emp.id}">
    </p>
    <p>
        <input name="empName" type="text" placeholder="Name" value="${emp.name}">
    </p>
    <p>
        <input name="address" type="text" placeholder="Address" value="${emp.address}">
    </p>
    <p>
        <input name="age" type="number" value="${emp.age}">
    </p>
    <p>
        <input type="submit" value="Update">
    </p>
</form>
</body>
</html>
