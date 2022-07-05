<%--
  Created by IntelliJ IDEA.
  User: netmo
  Date: 05/07/2022
  Time: 10:12 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar pokemon</title>
    <jsp:include page="../../templates/head.jsp"/>
</head>
<body>
<jsp:include page="../../templates/navbar.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card mt-5">
                <div class="card-header">REGISTRO DE POKEMON</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <form class="needs-validation" action="add-pokemon" method="POST">
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="pokemon">Nombre</label>
                                            <input name="name" id="pokemon"
                                                   class="form-control"/>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="health">Puntos de salud</label>
                                            <input name="health" id="health"
                                                   class="form-control" type="number"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="type">Tipo</label>
                                            <input name="name" id="type"
                                                   class="form-control"/>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="heigth">Estatura</label>
                                            <input name="health" id="heigth"
                                                   class="form-control" type="number"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="power">Puntos de ataque</label>
                                            <input name="name" id="power"
                                                   class="form-control" type="number"/>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="weigth">Peso</label>
                                            <input name="health" id="weigth"
                                                   class="form-control" type="number"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <button class="btn btn-danger btn-sm">Cancelar</button>
                                            <button class="btn btn-success btn-sm">Guardar</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../../templates/footer.jsp"/>
</body>
</html>
