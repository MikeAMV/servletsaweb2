<%--
  Created by IntelliJ IDEA.
  User: josechristiannarvaezfigueroa
  Date: 07/06/22
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualizar usuario</title>
</head>
<body>
<form action="updatePerson" method="post" >
    <fieldset>
        <legend>Registro de persona</legend>
        <p><label>Nombres:</label> <input type="text" name="name" value="${person.name}"/></p>
        <p><label>Apellidos:</label> <input type="text" name="lastname" value="${person.lastname}"/></p>
        <p><label>Altura:</label> <input type="text" name="height" value="${person.height}"/></p>
        <p><label>Fecha nacimiento:</label> <input type="date" name="age" value='${person.ageFormat}' /></p>
        <input type="submit" value="Actualizar"/>
    </fieldset>
</form>
</body>
</html>
