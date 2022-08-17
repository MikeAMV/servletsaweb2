<%--
  Created by IntelliJ IDEA.
  User: netmo
  Date: 29/06/2022
  Time: 02:28 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Pokémons</title>
    <jsp:include page="../../templates/head.jsp"/>
</head>
<body>
<jsp:include page="../../templates/navbar.jsp"/>
<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <c:if test="${param['result']}">
                <p><c:out value="${param['message']}"></c:out></p>
            </c:if>
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col-6">POKEMONS</div>
                        <div class="col-6 text-end">
                            <a href="create-pokemon" class="btn btn-outline-success btn-sm">
                                <i data-feather="plus"></i> Registrar pokemon
                            </a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-sm table-hover datatable">
                        <thead>
                        <th>#</th>
                        <th>Imagen</th>
                        <th>Pokemon</th>
                        <th>Puntos de vida</th>
                        <th>Acciones</th>
                        </thead>
                        <tbody>
                        <c:forEach var="pokemon" items="${pokemons}" varStatus="status">
                            <tr>
                                <td>
                                    <img src="download-file?fileName=${pokemon.fileName}"
                                         style="height: 100px;width: auto" loading="lazy"/></td>
                                <td>
                                    <c:out value="${status.count}"></c:out>
                                </td>
                                <td>
                                    <c:out value="${pokemon.name}"></c:out>
                                </td>
                                <td><c:out value="${pokemon.health}"/></td>
                                <td>
                                    <a href="get-pokemon?id=${pokemon.id}" class="btn btn-warning
                                    btn-sm"><i data-feather="edit"></i></a>
                                    <form action="delete-pokemon" method="post">
                                        <input type="hidden" value="${pokemon.id}" name="id"/>
                                        <button type="submit" class="btn btn-danger btn-sm">
                                            <i data-feather="trash-2"></i>
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../../templates/footer.jsp"/>
<script>
    $(document).ready(() => {

        document.getElementById("loaderDiv").style.display = "none";
        let $datatable = $('.datatable')
        if ($datatable.DataTable) {
            $datatable.DataTable({
                language: {
                    url: 'https://cdn.datatables.net/plug-ins/1.11.5/i18n/es-MX.json',
                },
            });
        }
    })
    feather.replace();
</script>
</body>
</html>
