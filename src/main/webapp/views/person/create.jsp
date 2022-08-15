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
  <title>Registrar persona</title>
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
              <form class="needs-validation" novalidate action="add-person" method="post"
                    enctype="multipart/form-data">
                <div class="form-group mb-3">
                  <div class="row">
                    <div class="col">
                      <label class="fw-bold" for="person">Nombre</label>
                      <input name="name" id="person" required
                             class="form-control"/>
                      <div class="invalid-feedback">
                        Campo obligatio
                      </div>
                    </div>
                    <div class="col">
                      <label class="fw-bold" for="surname">Apellido</label>
                      <input name="surname" id="surname" required
                             class="form-control"/>
                      <div class="invalid-feedback">
                        Campo obligatio
                      </div>
                    </div>
                  </div>
                </div>
                <div class="form-group mb-3">
                  <div class="row">
                    <div class="col">
                      <label class="fw-bold" for="curp">Curp</label>
                      <input name="curp" id="curp" required
                             class="form-control"/>
                      <div class="invalid-feedback">
                        Campo obligatio
                      </div>
                    </div>
                    <div class="col">
                      <label class="fw-bold" for="birthday">Birthday</label>
                      <input name="birthday" id="birthday" required
                             class="form-control"/>
                      <div class="invalid-feedback">
                        Campo obligatio
                      </div>
                    </div>
                  </div>

                      <div id="preview" class="mt-3"></div>
                    </div>


                <div class="form-group mb-3">
                  <div class="row">
                    <div class="col-12 text-end">
                      <button type="button" class="btn btn-danger btn-sm">Cancelar</button>
                      <button type="submit" class="btn btn-success btn-sm">Guardar</button>
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
  })();

  const handleFileChange = () => {
    let inputFile = document.getElementById("pokemonImg").files;1
    for (let i = 0; i < inputFile.length; i++) {
      let reader = new FileReader();
      reader.onloadend = (result) => {
        let preview = document.getElementById("preview");
        preview.innerHTML = "";
        preview.innerHTML = "<img src='" + result.target.result
                + "' style='height: 200px;width: auto;'/>";
      }
      reader.readAsDataURL(inputFile[i]);
    }
  }

  $(document).ready(() => {
    document.getElementById("loaderDiv").style.display = "none";
  });
</script>
<jsp:include page="../../templates/footer.jsp"/>
</body>
</html>
