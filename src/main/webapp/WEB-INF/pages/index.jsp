<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<html>
<head>
    <title>JSP</title>
</head>
<body>
<div>
    <table border=1>
        <tr>
            <th>No</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th colspan=2>Action</th>
        </tr>
        <c:forEach items="${users}" var="user">
        <tr>
            <td> ${user.id}</td>
            <td> ${user.firstName}</td>
            <td> ${user.lastName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/update?id=${user.id}">Edit</a>

                <a href="${pageContext.request.contextPath}/delete?id=${user.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <p><a href="user">Add new user</a>  </p>
</div>
<br/>
</body>
</html>