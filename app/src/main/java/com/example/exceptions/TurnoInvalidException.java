package com.example.exceptions;

public class TurnoInvalidException extends  Exception{

    //constructor
    public TurnoInvalidException(){}

    //lanzo el mensaje de error en el caso de que no entre ningún parámetro válido para trámite
    public TurnoInvalidException(String mensajeError){
    super(mensajeError);

    }
}
