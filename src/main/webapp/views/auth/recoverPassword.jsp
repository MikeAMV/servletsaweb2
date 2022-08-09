<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recuperar Contraseña</title>
    <jsp:include page="../../templates/head.jsp"/>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col align-middle">
            <div class="card position-absolute top-50 start-50 translate-middle" style="width: 30%">
                <div class="card-header">Recuperar contraseña</div>
                <div class="card-body">
                    <form action="send-email" method="post">
                        <div class="form-group mb-3">
                            <label for="username">Usuario</label>
                            <input name="username" placeholder="miguelmoreno@utez.edu.mx" id="username" class="form-control" type="text" required/>
                        </div>
                        <button class="btn btn-secondary btn-sm col-md-12" type="submit">
                            <i data-feather="send"></i> Enviar
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../../templates/footer.jsp"/>
<script>
    $(document).ready(() => {
        document.getElementById("loaderDiv").style.display = "none";
    });
    feather.replace();
</script>
</body>
</html>