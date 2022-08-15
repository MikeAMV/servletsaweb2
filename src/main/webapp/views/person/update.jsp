<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar USUARIO</title>
    <jsp:include page="../../templates/head.jsp"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="get-persons">
            <i data-feather="home"></i> Inicio
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="get-persons">
                        <i data-feather="align-left"></i> Persons
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="get-pokemons">Pokemons</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="get-abilities">Habilidades</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="get-users"><i data-feather="users"></i>Usuarios</a>
                </li>
            </ul>
        </div>
        <form method="post" action="logout">
            <button type="submit" class="btn btn-outline-danger mt-1">
                <i data-feather="log-out"></i> Cerrar sesión
            </button>
        </form>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card mt-5">
                <div class="card-header">REGISTRAR USUARIO</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <form class="needs-validation" novalidate action="save-person" method="post">
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="name">Nombre</label>
                                            <input name="name" id="name" required
                                                   class="form-control" value="${person.name}"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                            <input type="hidden" name="id" value="${person.id}"/>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="surname">Surname</label>
                                            <input name="surname" id="surname" required
                                                   class="form-control" type="number" value="${person.surname}"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col">
                                            <label class="fw-bold" for="curp">Curp</label>
                                            <input name="curp" id="curp" required
                                                   class="form-control" value="${person.curp}"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                        <div class="col">
                                            <label class="fw-bold" for="birthday">Birthday</label>
                                            <input name="birthday" id="birthday" required
                                                   class="form-control" type="number" value="${person.birthday}"/>
                                            <div class="invalid-feedback">
                                                Campo obligatorio
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <div class="row">
                                        <div class="col-12 text-end">
                                            <a class="btn btn-danger btn-sm" href="get-persons">
                                                Cancelar
                                            </a>

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
                    let name = document.querySelector("#name").value;
                    let surname = document.querySelector("#surname").value;
                    let curp = document.querySelector("#curp").value;
                    console.log(name)
                    let birthday = document.querySelector("#birthday").value;
                    let newAction = "add-person?name="+ name + "&surname=" + surname + "&curp="+ curp +"&birthday=" + birthday;
                    console.log(newAction)
                    form.setAttribute("action", newAction);
                }, false)
            })
    })()
    document.getElementById("loaderDiv").style.display = "none";
</script>
<jsp:include page="../../templates/footer.jsp"/>
</body>
</html>
