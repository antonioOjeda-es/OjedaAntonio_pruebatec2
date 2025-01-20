package com.example.utilities;

import com.example.entities.Ciudadano;
import com.example.entities.Turno;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class OperacionesNumericas {

    //voy a crear un código aleatorio para agregar al turno del diudadano
    public static Integer crearCodigoTurno(Long idCiudadanoTurno, List<Turno> listaTurnos) {

        // Creo una instancia de Random
        Random random = new Random();

        //creo una variable con el código creado, además paso el idCiudadano a Integer para sirva en el método
        Integer codigo = 10000 + random.nextInt(90000) + idCiudadanoTurno.intValue();

        //validar que el código del turno no esté creado ya en la base de datos, para ello:

        //itero en el caso de que la lista no esté nula, buscaré un código repetido en la listaTurnos
        if (listaTurnos != null) {
            //si lanza true vuelve a ejecutar el método para generar otro código en el caso de que exista
            boolean turnoRepetido = listaTurnos.stream()
                    .anyMatch(n -> n.getCodigoTurno().equals(codigo));

            if(turnoRepetido){
                crearCodigoTurno(idCiudadanoTurno, listaTurnos);
            }
        }

        //si no está repetido lo devuelvo al controlador
        return codigo;
    }
}
