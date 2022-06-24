<%--
  Created by IntelliJ IDEA.
  User: josechristiannarvaezfigueroa
  Date: 10/05/22
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreatePerson</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="savePerson" method="post" >
    <fieldset>
        <legend>Registro de persona</legend>
        <p><label>Nombres:</label> <input type="text" name="name"/></p>
        <p><label>Apellidos:</label> <input type="text" name="lastname"/></p>
        <p><label>Altura:</label> <input type="text" name="height"/></p>
        <p><label>Fecha nacimiento:</label> <input type="date" name="age"/></p>
        <input type="submit" value="Registrar"/>
    </fieldset>
</form>
</body>
</html>
