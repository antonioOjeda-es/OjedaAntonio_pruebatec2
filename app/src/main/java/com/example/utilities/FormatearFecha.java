package com.example.utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FormatearFecha {

    //para introducir la fecha en la base de datos, los segundos e inferiores se guardarán en 0 de forma predeterminada
    public static LocalDateTime fechaAnioMesDiaHoraMinuto(String fecha) {

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

    /*para que ponga predefinidamente la hora, minutos y segundos a 0
     para la filtro de busqueda por fechas con atStartOfDay() */
    public static LocalDateTime fechaAnioMesDia(String fecha) {

        LocalDateTime fechaFormateada;

        //si la fecha está vacía, se creará una actual para que la fecha final sea el momento actual
        if (fecha.isEmpty()) {
            fechaFormateada = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);

        } else {
            try {
                fechaFormateada = LocalDate.parse(fecha).atStartOfDay();
            } catch (DateTimeParseException e) {

                throw new DateTimeParseException("Formato de fecha incorrecto", fecha, 0);
            }
            return fechaFormateada;
        }
        return fechaFormateada;
    }

    //para pasar la fecha a String para que se vean de forma legible en los jps
    public static String pasarFechaAString(String fechaAString) {

        //formateador para mostrar en String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        // creo una fecha para agregarla al objeto Turno:
        LocalDateTime turnoFechaFormateado;

        try {
            //uso el método parse para crear una fecha formateada y agregarla a la variable creada anteriormente
            turnoFechaFormateado = LocalDateTime.parse(fechaAString, formatter);

            // cuando no se puede pasar la fecha, el formato de fecha es incorrecto
        } catch (DateTimeParseException e) {

            throw new DateTimeParseException("Formato de fecha incorrecto", fechaAString, 0);

            //Si la fecha es nula
        } catch (NullPointerException e) {
            throw new NullPointerException("La fecha no puede ser nula");
        }

        return turnoFechaFormateado.getYear() +

                //agrego un cero cuando el número es menor a 9 usando un ternario
                "-" + (turnoFechaFormateado.getMonth().getValue() <= 9 ? "0"
                + turnoFechaFormateado.getMonth().getValue() : turnoFechaFormateado.getMonth().getValue()) +

                //igual para el mes
                "-" + (turnoFechaFormateado.getDayOfMonth() <= 9 ? "0"
                + turnoFechaFormateado.getDayOfMonth() : turnoFechaFormateado.getDayOfMonth())

                //para la hora igual
                + "  a las " + (turnoFechaFormateado.getHour() <= 9 ? "0"
                + turnoFechaFormateado.getHour() : turnoFechaFormateado.getHour())

                //igual para minutos
                + ":" + (turnoFechaFormateado.getMinute() <= 9 ? "0"
                + turnoFechaFormateado.getMinute() : turnoFechaFormateado.getMinute());
    }
}
