<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!-- Importar las clases -->
    <%@ page import="java.util.List, com.example.entities.Ciudadano" %>

        <!DOCTYPE html>
        <html lang="en">
        <%@ include file="partials/head.jsp" %>

            <body>

                <!-- incluyo el heder de partials -->
                <%@ include file="partials/header.jsp" %>

                    <div class="container text-center mt-5">

                        <h3>
                            <%= request.getAttribute("mensajeAgregado") %>
                        </h3>
                    </div>

                    <!-- sacado de boostrap -->
                    <div class="container my-5">
                        <div class="row justify-content-center">
                            <div class="col-md-6">
                                <div class="card">
                                    <div class="card-header">
                                        <h4 class="mb-0">Agregar nuevo ciudadano:</h4>
                                    </div>
                                    <div class="card-body">
                                        <form id="personaForm" action="/app/agregarCiudadano" method="post">
                                            <div class="mb-3">
                                                <label for="nombre" class="form-label">Nombre</label>
                                                <input type="text" class="form-control" id="nombre" name="nombre"
                                                    required>
                                            </div>

                                            <div class="mb-3">
                                                <label for="apellido" class="form-label">Apellido</label>
                                                <input type="text" class="form-control" id="apellido" name="apellido"
                                                    required>
                                            </div>

                                            <div class="mb-3">
                                                <label for="direccion" class="form-label">Dirección</label>
                                                <input type="text" class="form-control" id="direccion" name="direccion"
                                                    required>
                                            </div>

                                            <div class="d-grid gap-2">
                                                <button type="submit" class="btn btn-primary">Guardar</button>
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

                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                            crossorigin="anonymous"></script>
            </body>

        </html>