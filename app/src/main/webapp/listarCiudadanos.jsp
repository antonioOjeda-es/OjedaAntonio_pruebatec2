<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- Importo las clases -->
    <%@ page
        import="java.util.List, com.example.entities.Turno, com.example.entities.Turno.Tramite, com.example.entities.Ciudadano"
        %>

        <!DOCTYPE html>
        <html lang="es">
        <%@ include file="partials/head.jsp" %>

            <body class="bg-light">
                <!-- incluyo el heder de partials -->
                <%@ include file="partials/header.jsp" %>

                    <div class="container mt-4">
                        <div class="row justify-content-center">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header bg-dark text-white">
                                        <h5 class="mb-0">Filtrar Turnos</h5>
                                    </div>
                                    <div class="card-body">
                                        <form action="/app/ciudadanos" method="post" class="row g-3">
                                            <input type="hidden" name="action" value="filtrar">
                                            <div class="col-md-4">
                                                <label for="fechaTurnoFiltrarInicial" class="form-label">Desde</label>
                                                <input type="datetime-local" class="form-control"
                                                    id="fechaTurnoFiltrarInicial" name="fechaTurnoFiltrarInicial"
                                                    value="<%= request.getAttribute("fechaTurnoFiltrarInicial") !=null
                                                    ? request.getAttribute("fechaTurnoFiltrarInicial") : "" %>"
                                                onchange="actualizarFechaMinima()">
                                            </div>
                                            <div class="col-md-4">
                                                <label for="fechaTurnoFiltrarFinal" class="form-label">Hasta</label>
                                                <input type="datetime-local" class="form-control"
                                                    id="fechaTurnoFiltrarFinal" name="fechaTurnoFiltrarFinal"
                                                    value="<%= request.getAttribute("fechaTurnoFiltrarFinal") !=null ?
                                                    request.getAttribute("fechaTurnoFiltrarFinal") : "" %>"
                                                data-bs-toggle="tooltip" data-bs-placement="top"
                                                title="Sin filtro de fecha">
                                                <div class="form-text text-muted">* No
                                                    seleccionar si no necesita fecha final</div>
                                                <div class="form-text text-muted">(Se mostrará hasta la fecha el turno
                                                    más reciente)</div>
                                            </div>
                                            <div class="col-md-4">
                                                <label for="estadoTurnoFiltrar" class="form-label">Estado</label>
                                                <select class="form-select" id="estadoTurnoFiltrar"
                                                    name="estadoTurnoFiltrar">
                                                    <option value="SIN_OPCION" <%="SIN_OPCION"
                                                        .equals(request.getAttribute("estadoTurnoFiltrar")) ? "selected"
                                                        : "" %>>Sin filtros</option>
                                                    <option value="EN_ESPERA" <%="EN_ESPERA"
                                                        .equals(request.getAttribute("estadoTurnoFiltrar")) ? "selected"
                                                        : "" %>>En espera</option>
                                                    <option value="YA_ATENDIDO" <%="YA_ATENDIDO"
                                                        .equals(request.getAttribute("estadoTurnoFiltrar")) ? "selected"
                                                        : "" %>>Ya atendido</option>
                                                </select>
                                            </div>
                                            <div class="col-12 text-end mt-3">
                                                <button type="submit" class="btn btn-primary">Filtrar</button>
                                                <a href="<%= request.getContextPath() %>/ciudadanos?action=listar"
                                                    class="btn btn-secondary">Limpiar filtros</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- tabla para listado de turnos-->
                    <div class="container text-center pt-3">
                        <h3>
                            <%= request.getAttribute("mensaje") %>
                        </h3>
                    </div>
                    <div class="container mt-4">
                        <div class="row justify-content-center">
                            <div class="col-md-12">
                                <table class="table table-striped table-bordered">
                                    <thead class="table-dark col-md-12">
                                        <tr class="text-center">
                                            <th colspan="4">Turno</th>
                                            <th colspan="3">Ciudadano</th>
                                        </tr>
                                        <tr class="table-light text-center">
                                            <th>Número de turno</th>
                                            <th>Fecha/Hora</th>
                                            <th>Trámite</th>
                                            <th>Estado</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Dirección</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% List<Turno> listadoTurnos = (List<Turno>)
                                                request.getAttribute("listaTurnos");
                                                for(Turno turno: listadoTurnos) { %>
                                                <tr>
                                                    <td>
                                                        <%= turno.getCodigoTurno() %>
                                                    </td>
                                                    <td>
                                                        <!--he formateado los números menores de 10, añada un 0-->
                                                        <%= turno.getFecha().getDayOfMonth() < 10 ? "0" +
                                                            turno.getFecha().getDayOfMonth() :
                                                            turno.getFecha().getDayOfMonth() %>
                                                            /<%= turno.getFecha().getMonth().getValue() < 10 ? "0" +
                                                                turno.getFecha().getMonth().getValue() :
                                                                turno.getFecha().getMonth().getValue() %>
                                                                /<%= turno.getFecha().getYear() %>. <%=
                                                                        turno.getFecha().getHour() < 10 ? "0" +
                                                                        turno.getFecha().getHour() :
                                                                        turno.getFecha().getHour() %>:<%=
                                                                            turno.getFecha().getMinute() < 10 ? "0" +
                                                                            turno.getFecha().getMinute() :
                                                                            turno.getFecha().getMinute() %>
                                                    </td>
                                                    <td>
                                                        <!--he formateado la entrada de trámite para que los que tienen guión bajo, los reemplace por el mismo pero ellos pero con espacios-->
                                                        <%= turno.getTramite().toString().replace("_", " " ) %>
                                                    </td>
                                                    <td>
                                                        <!--he formateado la entrada de estado para que los que tienen guión bajo, los reemplace por el mismo pero ellos pero con espacios-->
                                                        <%= turno.getEstado().toString().replace("_", " " ) %>
                                                    </td>
                                                    <td>
                                                        <%= turno.getCiudadano().getNombre() %>
                                                    </td>
                                                    <td>
                                                        <%= turno.getCiudadano().getApellido() %>
                                                    </td>
                                                    <td>
                                                        <%= turno.getCiudadano().getDireccion() %>
                                                    </td>
                                                </tr>
                                                <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- incluyo el scripts de bootstrap y local de partials -->
                    <%@ include file="partials/footer.jsp" %>

                        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                            crossorigin="anonymous"></script>
                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
                            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
                            crossorigin="anonymous"></script>
                        <script src="public/js/turno.js"></script>
            </body>

        </html>