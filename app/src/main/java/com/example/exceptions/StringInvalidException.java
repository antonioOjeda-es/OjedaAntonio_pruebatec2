package com.example.exceptions;

public class StringInvalidException extends Exception{

    //constructor
    public StringInvalidException(){}

    //lanzo el mensaje de error en el caso de que no entre ningún parámetro válido para trámite
    public StringInvalidException(String mensajeError){
        super(mensajeError);

    }
}
