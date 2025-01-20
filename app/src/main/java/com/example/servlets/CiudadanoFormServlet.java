package com.example.servlets;

import com.example.controllers.CiudadanoController;
import com.example.exceptions.CiudadanoInvalidException;
import com.example.exceptions.StringInvalidException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/agregarCiudadano")
public class CiudadanoFormServlet extends HttpServlet {

    //instancio el controlador para que se puedan usar sus métodos e interactuar con la BD de ciudadano
    private CiudadanoController ciudadanoController = new CiudadanoController();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //creo variables y las envío al jsp

        //envío esta variable vacía para que llegue al jsp y pueda ser gestionada mas tarde por post
        req.setAttribute("mensajeAgregado", "");
        req.getRequestDispatcher("ciudadanoForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String direccion = req.getParameter("direccion");

        String mensajeAgregado = null;


        try {
            ciudadanoController.create(nombre, apellido, direccion);
            mensajeAgregado = "El ciudadano " + nombre + " " + apellido + " ha sido agregado.";
        } catch (StringInvalidException | CiudadanoInvalidException e) {
            //mando un mensaje de error, podría mandar una página de error por el response

            //primero mando una variable de mensaje de error
            req.setAttribute("mensajeError", e.getMessage());
            req.getRequestDispatcher("errors/paginaErrores.jsp").forward(req, resp);;
        }


        //creo las variables y lo en´vio al jsp
        req.setAttribute("mensajeAgregado", mensajeAgregado);
        req.getRequestDispatcher("ciudadanoForm.jsp").forward(req, resp);;

        //resp.sendRedirect( req.getContextPath() + "/agregarCiudadano");

    }
}
