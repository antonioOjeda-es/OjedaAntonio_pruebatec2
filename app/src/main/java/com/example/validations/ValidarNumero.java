package com.example.validations;

public class ValidarNumero extends Exception{

    //constructor
    public ValidarNumero(){}

    //lanzo el mensaje de error en el caso de que no entre ningún parámetro válido para trámite
    public ValidarNumero(String mensajeError){
        super(mensajeError);

    }
}
