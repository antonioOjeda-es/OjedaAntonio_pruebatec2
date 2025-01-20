package com.example.validations;

import com.example.exceptions.StringInvalidException;
import com.example.exceptions.TurnoInvalidException;

import java.util.regex.Pattern;

public class ValidarString {

    public static void  ValidarExpresionString(String validarString) throws StringInvalidException {

        //voy a valorar que el String no sea nulo ni vacío y que no contenga números
        if(validarString == null || validarString.isEmpty() || Pattern.matches(".*\\d+.*", validarString)){
            throw new StringInvalidException("Los campos de nombre y apellido no pueden contener números");
        }

    }
}
