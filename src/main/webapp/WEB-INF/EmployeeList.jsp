<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>Employee List</h3>
<a href="<c:url value="/index.jsp" />">Create</a>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Age</th>
        <th>update</th>
        <th>delete</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${!empty empList}">
        <c:forEach items="${empList}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.address}</td>
                <td>${emp.age}</td>
                <td><a href="<c:url value="/update?id=${emp.id}"/>">update</a></td>
                <td><a href="<c:url value="/delete?id=${emp.id}"/>">delete</a></td>
            </tr>
        </c:forEach>
    </c:if>


    </tbody>
</table>