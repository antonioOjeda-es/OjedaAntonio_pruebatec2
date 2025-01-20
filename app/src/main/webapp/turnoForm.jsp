<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- Importar las clases -->
    <%@ page import="java.util.List, com.example.entities.Ciudadano, com.example.entities.Turno.Tramite" %>

        <!DOCTYPE html>
        <html lang="es">
        <%@ include file="partials/head.jsp" %>

            <body>
                <!-- incluyo el header de partials -->
                <%@ include file="partials/header.jsp" %>

                    <div class="container text-center mt-5">
                        <h3>
                            <%= request.getAttribute("mensajeAgregado") %>
                        </h3>
                    </div>

                    <div class="container my-5">
                        <div class="row justify-content-center">
                            <div class="col-md-6">
                                <div class="card">
                                    <div class="card-header">
                                        <h4 class="mb-0">Agregar nuevo turno:</h4>
                                    </div>
                                    <div class="card-body">
                                        <form id="turnoForm" action="/app/crearTurnoCiudadano" method="post">
                                            <!-- Select para Ciudadano -->
                                            <div class="mb-3">
                                                <label for="idCiudadano" class="form-label">Ciudadano</label>
                                                <select class="form-select" id="idCiudadano" name="idCiudadano"
                                                    required>
                                                    <option value="">Seleccione un ciudadano...</option>
                                                    <% List<Ciudadano> listaCiudadanos = (List<Ciudadano>)
                                                            request.getAttribute("listaCiudadanos");
                                                            for(Ciudadano ciudadano : listaCiudadanos) { %>
                                                            <option value="<%= ciudadano.getId() %>">
                                                                <%= ciudadano.getNombre() %>
                                                                    <%= ciudadano.getApellido() %>
                                                            </option>
                                                            <% } %>
                                                </select>
                                            </div>

                                            <!-- Input para Fecha y Hora -->
                                            <div class="mb-3">
                                                <label for="fechaTurnoInsertar" class="form-label">Fecha y Hora</label>
                                                <input type="datetime-local" class="form-control"
                                                    id="fechaTurnoInsertar" name="fechaTurnoInsertar" required>
                                            </div>

                                            <!-- Select para Trámite -->
                                            <div class="mb-3">
                                                <label for="turnoTramiteCrear" class="form-label">Trámite</label>
                                                <select class="form-select" id="turnoTramiteCrear"
                                                    name="turnoTramiteCrear" required>
                                                    <option value="">Seleccione un trámite...</option>
                                                    <% for(Tramite tramite : Tramite.values()) { %>
                                                        <option value="<%= tramite.name() %>">
                                                            <%= tramite.name().replace("_", " " ) %>
                                                        </option>
                                                        <% } %>
                                                </select>
                                            </div>

                                            <div class="d-grid gap-2">
                                                <button type="submit" class="btn btn-primary">Guardar Turno</button>
                                                <a href="index.html" class="btn btn-secondary">Cancelar</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- incluyo el scripts de bootstrap y local de partials -->
                    <%@ include file="partials/footer.jsp" %>
            </body>

        </html>