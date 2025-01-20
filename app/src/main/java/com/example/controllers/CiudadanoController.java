package com.example.controllers;

import com.example.entities.Ciudadano;
import com.example.exceptions.CiudadanoInvalidException;
import com.example.exceptions.StringInvalidException;
import com.example.persistence.GenericJPA;
import com.example.validations.ValidarString;

import java.util.List;
import java.util.Optional;

public class CiudadanoController {

    private final GenericJPA<Ciudadano, Long> ciudadanoJPA;

    public CiudadanoController() {
        this.ciudadanoJPA = new GenericJPA<>(Ciudadano.class);
    }

    public void create(String nombre, String apellido, String direccion) throws StringInvalidException, CiudadanoInvalidException {

        //1ºvalido el nombre que no sea nulo ni contenga números
        ValidarString.ValidarExpresionString(nombre);

        //2º valido que el apellido no sea nulo ni contenta números
        ValidarString.ValidarExpresionString(apellido);

        //3ºvoy a ver si el usuario existe en la base de datos, para ello primero saco la lista
        List<Ciudadano> listaCiudadanos = ciudadanoJPA.findAllGenerico().orElse(null);
        //lanzo un error si es nulo
        if (listaCiudadanos == null) {
            throw new CiudadanoInvalidException("No existen usuarios en la base de datos");
        }

        //voy a ver si el usuario ya está introducido en la base de datos:
        boolean existeUsuario = listaCiudadanos.stream()
                .anyMatch(n -> n.getNombre().equalsIgnoreCase(nombre) && n.getApellido().equalsIgnoreCase(apellido));

        if(existeUsuario){
            throw new CiudadanoInvalidException("El usuario ya existe en la base de datos");
        }

        //agrego un ciudadano u hago set
        Ciudadano ciudadano = new Ciudadano(nombre, apellido, direccion);
        ciudadanoJPA.createGenerico(ciudadano);
    }

    //encontrar todos los ciudadanos
    public Optional<List<Ciudadano>> findAll() {
        return ciudadanoJPA.findAllGenerico();
    }
}
