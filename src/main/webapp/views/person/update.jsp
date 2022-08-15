
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
        <div class="card-header">REGISTRAR PERSONA</div>
        <div class="card-body">
          <div class="row">
            <div class="col-12">
              <form class="needs-validation" novalidate action="save-person" method="post">
                <div class="form-group mb-3">
                  <div class="row">
                    <div class="col">
                      <label class="fw-bold" for="person">persona</label>
                      <input name="name" id="person" required
                             class="form-control" value="${person.name}"/>
                      <div class="invalid-feedback">
                        Campo obligatorio
                      </div>
                      <input type="hidden" name="id" value="${person.id}"/>
                    </div>
                    <div class="col">
                      <label class="fw-bold" for="surname">apellido</label>
                      <input name="surname" id="surname" required
                             class="form-control"  value="${person.surname}"/>
                      <div class="invalid-feedback">
                        Campo obligatorio
                      </div>
                    </div>
                  </div>
                </div>
                <div class="form-group mb-3">
                  <div class="row">
                    <div class="col">
                      <label class="fw-bold" for="curp">curp</label>
                      <input name="curp" id="curp" required
                             class="form-control" value="${person.curp}"/>
                      <div class="invalid-feedback">
                        Campo obligatorio
                      </div>
                    </div>
                    <div class="col">
                      <label class="fw-bold" for="birthday">Estatura</label>
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
