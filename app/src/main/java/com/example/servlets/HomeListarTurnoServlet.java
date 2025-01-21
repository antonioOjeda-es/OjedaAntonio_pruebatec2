package com.example.servlets;

import com.example.controllers.TurnoController;
import com.example.entities.Turno;
import com.example.exceptions.TurnoInvalidException;
import com.example.utilities.FormatearFecha;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ciudadanos")
public class HomeListarTurnoServlet extends HttpServlet {

    //instancio el controlador para obtener sus métodos
    TurnoController turnoController = new TurnoController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fechaTurnoFiltrar = req.getParameter("fechaTurnoFiltrar");
        String estadoTurnoFiltrar = req.getParameter("estadoTurnoFiltrar");

        System.err.println("Fecha: " + fechaTurnoFiltrar + ", " + "Estado: " + estadoTurnoFiltrar);

        List<Turno> listaTurnos = turnoController.listAllTurnos().orElse(null);

        //valoro si la lista está vacía, mando un mensaje de error a página de errores
        if (listaTurnos == null || listaTurnos.isEmpty()) {

            req.setAttribute("mensajeError", new NullPointerException("Lista vacía"));
            req.getRequestDispatcher("errors/paginaErrores.jsp").forward(req, resp);
        }


        String mensaje = "Listado de turnos y ciudadanos sin filtrar:";

        req.setAttribute("listaTurnos", listaTurnos);
        req.setAttribute("mensaje", mensaje);
        req.getRequestDispatcher("listarCiudadanos.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //consigo las variables
        String fechaTurnoFiltrarInicial = req.getParameter("fechaTurnoFiltrarInicial");
        String fechaTurnoFiltrarFinal = req.getParameter("fechaTurnoFiltrarFinal");
        String estadoTurnoFiltrar = req.getParameter("estadoTurnoFiltrar");


        //creo una lista nula para introducir la lista filtrada
        List<Turno> listaTurnos = null;

        //lanzo un mensaje de error en el caso de que la lista sea vacía
        try {
            listaTurnos = turnoController.listTurnoFiltered(fechaTurnoFiltrarInicial, fechaTurnoFiltrarFinal, estadoTurnoFiltrar);

            //manejo el error para que lo muestre en una página
        } catch (TurnoInvalidException | NullPointerException e) {
            req.setAttribute("mensajeError", e.getMessage());
            req.getRequestDispatcher("errors/paginaErrores.jsp").forward(req, resp);
        }

        //valoro si la lista está vacía, mando un mensaje de error a página de errores
        if (listaTurnos == null || listaTurnos.isEmpty()) {

            req.setAttribute("mensajeError", new NullPointerException("Lista vacía"));
            req.getRequestDispatcher("errors/paginaErrores.jsp").forward(req, resp);
        }

        //defino la respuesta que va al jsp en el parámetro de estadoTurnoFiltrar y que agregaré al String mensaje
        String estadoMensaje = estadoTurnoFiltrar.equals("EN_ESPERA") ? "en espera"
                : estadoTurnoFiltrar.equals("YA_ATENDIDO") ? "ya atendido"
                : "cualquiera";

        /*para pasar la variable de fecha, primero la he pasado a formato LocalDateTime con un método de la clase y
        después lo paso a string para dar formato y convertirlo en una fecha comprensible para que lo lea el usuario
        con otro método de la Misma clase
         */
        String mensaje = "Listado con filtro con fecha desde "
                + FormatearFecha.pasarFechaAString(FormatearFecha.fechaAnioMesDia(fechaTurnoFiltrarInicial).toString())
                + " hasta "
                + FormatearFecha.pasarFechaAString(FormatearFecha.fechaAnioMesDia(fechaTurnoFiltrarFinal).toString())
                + " y estado " + estadoMensaje
                + ":";


        //mando la variable para mostrar en la página jsp
        req.setAttribute("listaTurnos", listaTurnos);
        req.setAttribute("mensaje", mensaje);
        req.getRequestDispatcher("listarCiudadanos.jsp").forward(req, resp);
    }
}
