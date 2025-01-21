<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="en">
    <%@ include file="partials/head.jsp" %>

        <body>

            <!-- incluyo el heder de partials -->
            <%@ include file="partials/header.jsp" %>


                <h1> mensaje: <%= request.getAttribute("mensaje") %>
                </h1>

                <!-- incluyo el scripts de bootstrap y local de partials -->
                <%@ include file="partials/footer.jsp" %>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                        crossorigin="anonymous"></script>

        </body>

    </html>