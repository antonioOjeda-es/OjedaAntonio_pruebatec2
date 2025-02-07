<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="es">
    <%@ include file="../partials/head.jsp" %>

        <body class="d-flex flex-column min-vh-100 bg-light">

            <!-- incluyo el heder de partials -->
            <%@ include file="../partials/header.jsp" %>


                <!-- imprimo el error por pantalla -->
                <div class="container text-center mt-5">
                    <h3>Mensaje de Error: <%= request.getAttribute("mensajeError") %>
                    </h3>

                    <!-- Botón para volver atrás -->
                    <button class="btn btn-primary mt-3" onclick="history.back()">Volver atrás</button>
                </div>

                <!-- incluyo el scripts de bootstrap y local de partials -->
                <%@ include file="../partials/footer.jsp" %>

        </body>

    </html>