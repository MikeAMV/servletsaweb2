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
                <div class="card-header">REGISTRAR POKEMON</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <form class="needs-validation" novalidate action="save-pokemon" method="post">
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="pokemon">Nombre</label>
                                            <input name="name" id="pokemon" required
                                                   class="form-control" value="${pokemon.name}"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                            <input type="hidden" name="id" value="${pokemon.id}"/>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="health">Puntos de salud</label>
                                            <input name="health" id="health" required
                                                   class="form-control" type="number" value="${pokemon.health}"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="type">Tipo</label>
                                            <input name="type" id="type" required
                                                   class="form-control" value="${pokemon.pokemonType}"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="heigth">Estatura</label>
                                            <input name="estatura" id="heigth" required
                                                   class="form-control" type="number" value="${pokemon.height}"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="power">Puntos de ataque</label>
                                            <input name="damage" id="power" required
                                                   class="form-control" type="number" value="${pokemon.power}"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="weigth">Peso</label>
                                            <input name="peso" id="weigth" required
                                                   class="form-control" type="number" value="${pokemon.weight}"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <button type="button" class="btn btn-danger btn-sm">Cancelar</button>
                                            <button type="submit" class="btn btn-warning btn-sm">Actualizar</button>
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
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')
        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
<jsp:include page="../../templates/footer.jsp"/>
</body>
</html>
