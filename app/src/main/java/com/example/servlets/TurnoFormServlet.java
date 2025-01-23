package com.example.servlets;


import com.example.controllers.CiudadanoController;
import com.example.controllers.TurnoController;
import com.example.entities.Ciudadano;
import com.example.exceptions.TurnoInvalidException;
import com.example.utilities.FormatearFecha;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.List;

@WebServlet(urlPatterns = "/crearTurnoCiudadano")
public class TurnoFormServlet extends HttpServlet {

    //instancio el controlador para que se puedan usar sus métodos e interactuar con la BD de ciudadano
    private TurnoController turnoController = new TurnoController();

    //voy a instanciar el controlador de ciudadanos para enviar la lista de ciudadano que necesito para el formulario
    private CiudadanoController ciudadanoController = new CiudadanoController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Ciudadano> listaCiudadanos = ciudadanoController.findAll().orElse(null);

        //si la lista está vacía, lanzo una excepción
        if (listaCiudadanos == null) {
            req.setAttribute("mensajeError", new TurnoInvalidException("No hay usuarios para crear turnos"));
            req.getRequestDispatcher("errors/paginaErrores.jsp");
        }


        //pongo el mensaje en vacío para que para que al cargar la página
        // tenga la variable preparada para mensaje del método post
        req.setAttribute("mensajeAgregado", "");
        //mando la lista de ciudadanos
        req.setAttribute("listaCiudadanos", listaCiudadanos);
        //envío al jsp
        req.getRequestDispatcher("turnoForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //consigo las variables:

        //1º fecha
        //consigo el parámetro de fecha en un String, lo valido en el controlador
        String fechaTurnoInsertar = req.getParameter("fechaTurnoInsertar");

        //2º idCiudadano
        //si el número no es un long, lanzo una excepción del sistema
        //esta excepción la valido directamente aquí ya que al pasar el dato a Long, me obliga a hacerlo aquí
        Long idCiudadano = 0L;
        try {
            idCiudadano = Long.parseLong(req.getParameter("idCiudadano"));
        } catch (NumberFormatException e) {
            //va a ser un mensaje proporcionado por java(no personalizado)
            //primero mando una variable de mensaje de error
            req.setAttribute("mensajeError", e.getMessage());
            req.getRequestDispatcher("errors/paginaErrores.jsp");
        }

        //3º trámite
        //lo validaré en el controlador
        String turnoTramiteCrear = req.getParameter("turnoTramiteCrear");

        //instancio un ciudadano
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setId(idCiudadano);

        //uso try/catch para validar que los datos de entrada sean correctos
        try {
            turnoController.create(fechaTurnoInsertar, turnoTramiteCrear, ciudadano);

            //voy a capturar en el servlet las excepciones:
        } catch (DateTimeParseException | TurnoInvalidException | NullPointerException e) {

            //mando un mensaje de error, podría mandar una página de error por el response
            //primero mando una variable de mensaje de error
            req.setAttribute("mensajeError", e.getMessage());
            //lo mando al jsq de errores
            req.getRequestDispatcher("errors/paginaErrores.jsp");
        }
        String mensajeAgregado = "Se ha agregado el turno con fecha " + FormatearFecha.pasarFechaAString(fechaTurnoInsertar) + " y concepto "
                //.replace para quitar los guiones bajos y .toLowerCase para minúscula
                + turnoTramiteCrear.replace("_", " ").toLowerCase();

        //creo una lista de ciudadanos (aunque podría ser de turnos también), para enviarlas al jsp
        List<Ciudadano> listaCiudadanos = ciudadanoController.findAll().orElse(null);
        if (listaCiudadanos == null) {
            throw new NullPointerException("Listado de personas vacío");
        }

        //si todo va bien, se redigirá al servlet de inicio
        req.setAttribute("listaCiudadanos", listaCiudadanos);
        req.setAttribute("mensajeAgregado", mensajeAgregado);
        req.getRequestDispatcher("turnoForm.jsp").forward(req, resp);
    }
}
