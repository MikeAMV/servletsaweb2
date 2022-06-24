<%--
  Created by IntelliJ IDEA.
  User: josechristiannarvaezfigueroa
  Date: 10/05/22
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Home Person</h1>
<a href = "<c:url value = "/createPerson"/>">Registrar</a>

<c:if test = "${param['result']}">
<p><c:out value = "${param['message']}"/><p>

    </c:if>
<table  border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>Nombre</th>
        <th>Altura</th>
        <th>Edad</th>
        <th>Modificar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="person" items="${listPersons}" varStatus="status">
        <tr>
            <td><c:out value="${status.count}"></c:out></td>
            <td><c:out value="${person.name} ${person.lastname}"></c:out></td>
            <td><c:out value="${person.height}"></c:out></td>
            <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${person.age}" /></td>
            <td>
                <a href = "<c:url value = "/getPerson?id=${person.id}"/>">Modificar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
