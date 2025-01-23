package com.example.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FormatearFecha {

    //para introducir la fecha en la base de datos, los segundos e inferiores se guardarán en 0 de forma predeterminada
    public static LocalDateTime pasarStringAFecha(String fecha) {

        /*paso el string a LocalDateTime utilizando el String y DateTimeFormatter
        para dar formato a la fecha a introducir */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        // creo una fecha para agregarla al objeto Turno:
        LocalDateTime turnoFechaFormateado;

        //se dará formato al String para que cree una fecha tipo LocalDateTime
        try {
            //uso el método parse para crear una fecha formateada y agregarla a la variable creada anteriormente
            turnoFechaFormateado = LocalDateTime.parse(fecha, formatter);

            // cuando no se puede pasar la fecha, el formato de fecha es incorrecto
        } catch (DateTimeParseException e) {

            throw new DateTimeParseException("Formato de fecha incorrecto", fecha, 0);

            //Si la fecha es nula
        } catch (NullPointerException e) {
            throw new NullPointerException("La fecha no puede ser nula");
        }
        return turnoFechaFormateado;
    }

    //para pasar la fecha a String para que se vean de forma legible en los jps
    public static String pasarFechaAString(String fechaAString) {

        //uso el método para dar formato a la fecha
        LocalDateTime turnoFechaFormateado = pasarStringAFecha(fechaAString);

        //hago formato al día para que tenga un 0 delante cuando el número es menor a 10
        return (turnoFechaFormateado.getDayOfMonth() <= 9 ? "0"
                + turnoFechaFormateado.getDayOfMonth() : turnoFechaFormateado.getDayOfMonth())

                //agrego un cero cuando el número es menor a 10 usando un ternario
                + "/" + (turnoFechaFormateado.getMonth().getValue() <= 9 ? "0"
                + turnoFechaFormateado.getMonth().getValue() : turnoFechaFormateado.getMonth().getValue())
                + "/" + turnoFechaFormateado.getYear()

                //para la hora igual que para el día y el mes
                + "  a las " + (turnoFechaFormateado.getHour() <= 9 ? "0"
                + turnoFechaFormateado.getHour() : turnoFechaFormateado.getHour())

                //igual para minutos
                + ":" + (turnoFechaFormateado.getMinute() <= 9 ? "0"
                + turnoFechaFormateado.getMinute() : turnoFechaFormateado.getMinute());
    }
}
