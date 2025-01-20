package com.example.exceptions;

public class CiudadanoInvalidException extends  Exception{

    //constructor
    public CiudadanoInvalidException(){}

    //lanzo el mensaje de error en el caso de que no entre ningún parámetro válido para trámite
    public CiudadanoInvalidException(String mensajeError){
    super(mensajeError);

    }
}
