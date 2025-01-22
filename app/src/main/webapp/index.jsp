<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="en">
    <%@ include file="partials/head.jsp" %>

        <body class="bg-light">
            <!-- incluyo el header de partials -->
            <%@ include file="partials/header.jsp" %>

                <div class="container py-5">
                    <!-- Encabezado -->
                    <div class="row justify-content-center mb-5">
                        <div class="col-lg-10 text-center">
                            <h1 class="display-4 mb-4">Sistema de Gestión de Turnos</h1>
                            <p class="lead">Sistema desarrollado para la gestión de turnos gubernamentales</p>
                            <div class="badge bg-primary p-2 mb-3">Java + Servlets + JSP + JPA</div>
                        </div>
                    </div>

                    <!-- Descripción del Proyecto -->
                    <div class="row mb-5">
                        <div class="col-lg-10 mx-auto">
                            <div class="card bg-light">
                                <div class="card-body">
                                    <h5 class="card-title">Descripción del Proyecto</h5>
                                    <p class="card-text">
                                        Aplicación de turnos desarrollada para una entidad gubernamental que permite la
                                        gestión de turnos
                                        para diferentes trámites y ciudadanos. Los turnos son asignados numéricamente
                                        según orden de
                                        llegada.
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Funcionalidades Principales -->
                    <div class="row g-4 mb-5">
                        <!-- Gestión de Turnos -->
                        <div class="col-md-4">
                            <div class="card h-100 border-primary">
                                <div class="card-header bg-primary text-white">
                                    <h5 class="card-title mb-0">
                                        <i class="fas fa-ticket me-2"></i>
                                        Nuevo Turno
                                    </h5>
                                </div>
                                <div class="card-body">
                                    <p class="card-text">Características principales:</p>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Asignación numérica automática</li>
                                        <li class="list-group-item">Registro de fecha y trámite</li>
                                        <li class="list-group-item">Asignación exclusiva a ciudadano</li>
                                    </ul>
                                    <div class="mt-3">
                                        <a href="/app/crearTurnoCiudadano" class="btn btn-primary">Crear Turno</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Listado y Filtrado de Turnos -->
                        <div class="col-md-4">
                            <div class="card h-100 border-success">
                                <div class="card-header bg-success text-white">
                                    <h5 class="card-title mb-0">
                                        <i class="fas fa-list-check me-2"></i>
                                        Gestión de Turnos
                                    </h5>
                                </div>
                                <div class="card-body">
                                    <p class="card-text">Sistema integral de visualización:</p>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">
                                            <i class="fas fa-table me-2"></i>
                                            Lista detallada por fecha
                                        </li>
                                        <li class="list-group-item">
                                            <i class="fas fa-filter me-2"></i>
                                            Filtrado por estado:
                                            <ul class="list-unstyled ms-4 mt-1">
                                                <li><small>• En espera</small></li>
                                                <li><small>• Ya atendido</small></li>
                                            </ul>
                                        </li>
                                        <li class="list-group-item">
                                            <i class="fas fa-calendar me-2"></i>
                                            Filtrado por rango de fechas
                                        </li>
                                    </ul>
                                    <div class="mt-3">
                                        <a href="/app/ciudadanos" class="btn btn-success">Gestionar Turnos</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Gestión de Ciudadanos (Extra) -->
                        <div class="col-md-4">
                            <div class="card h-100 border-info position-relative">
                                <div class="position-absolute top-0 end-0 m-2">
                                    <span class="badge bg-warning text-dark">Funcionalidad Extra</span>
                                </div>
                                <div class="card-header bg-info text-white">
                                    <h5 class="card-title mb-0">
                                        <i class="fas fa-users me-2"></i>
                                        Gestión de Ciudadanos
                                    </h5>
                                </div>
                                <div class="card-body">
                                    <p class="card-text">Funcionalidad adicional desarrollada:</p>
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">
                                            <i class="fas fa-user-plus me-2"></i>
                                            Registro de nuevos ciudadanos
                                        </li>
                                        <li class="list-group-item">
                                            <i class="fas fa-address-card me-2"></i>
                                            Gestión de datos personales
                                        </li>
                                    </ul>
                                    <div class="mt-3">
                                        <a href="/app/agregarCiudadano" class="btn btn-info text-white">Gestionar
                                            Ciudadanos</a>
                                    </div>
                                    <div class="mt-2">
                                        <small class="text-muted">
                                            <i class="fas fa-info-circle me-1"></i>
                                            Esta funcionalidad extiende las capacidades base del sistema la introducción
                                            y filtrado de datos de nuevos ciudadanos.
                                        </small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Detalles Técnicos -->
                    <div class="row justify-content-center">
                        <div class="col-lg-10">
                            <div class="card">
                                <div class="card-header bg-dark text-white">
                                    <h5 class="mb-0">Características Técnicas</h5>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <h6 class="fw-bold">Backend</h6>
                                            <ul class="list-unstyled">
                                                <li><i class="fas fa-check-circle text-success me-2"></i>Java + Servlets
                                                </li>
                                                <li><i class="fas fa-check-circle text-success me-2"></i>JPA para
                                                    persistencia</li>
                                                <li><i class="fas fa-check-circle text-success me-2"></i>Programación
                                                    funcional</li>
                                            </ul>
                                        </div>
                                        <div class="col-md-6">
                                            <h6 class="fw-bold">Frontend</h6>
                                            <ul class="list-unstyled">
                                                <li><i class="fas fa-check-circle text-success me-2"></i>JSP</li>
                                                <li><i class="fas fa-check-circle text-success me-2"></i>Bootstrap</li>
                                                <li><i class="fas fa-check-circle text-success me-2"></i>Diseño
                                                    responsive</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Mensaje del sistema -->
                    <div class="alert alert-info mt-4 text-center" role="alert">
                        <%= request.getAttribute("mensaje") !=null ? request.getAttribute("mensaje")
                            : "Bienvenido al sistema" %>
                    </div>
                </div>

                <!-- incluyo el footer de partials -->
                <%@ include file="partials/footer.jsp" %>

                    <!-- Scripts -->
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                        crossorigin="anonymous"></script>
                    <!-- Font Awesome -->
                    <script src="https://kit.fontawesome.com/your-code.js" crossorigin="anonymous"></script>
        </body>

    </html>