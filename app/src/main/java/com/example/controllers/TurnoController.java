package com.example.controllers;

import com.example.entities.Ciudadano;
import com.example.entities.Turno;
import com.example.exceptions.TurnoInvalidException;
import com.example.persistence.GenericJPA;
import com.example.utilities.FormatearFecha;
import com.example.utilities.OperacionesNumericas;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TurnoController {

    //instancio la clase del crud de JPA
    private final GenericJPA<Turno, Long> turnoJPA;

    //constructor
    public TurnoController() {
        this.turnoJPA = new GenericJPA<>(Turno.class);
    }

    //métodos:
    public void create(String fechaTurnoInsertar, String turnoTramiteCrear, Ciudadano ciudadano) throws TurnoInvalidException {

        //1º voy a validar la fecha antes de introducirla en la base de datos:
        //He creado un método para dar formato a la fecha y arrojar error en caso de fallo
        LocalDateTime turnoFechaFormateado = FormatearFecha.fechaAnioMesDiaHoraMinuto(fechaTurnoInsertar);

        //2º hago una validación del tramite
        //hago switch para valorar que los trámites sean fijos, sinó, lanza la excepción
        Turno.Tramite tipoTurnoTramite;

        switch (turnoTramiteCrear) {
            case "PRESENTAR_DECLARACION_RENTA":
                tipoTurnoTramite = Turno.Tramite.PRESENTAR_DECLARACION_RENTA;
                break;
            case "DUDAS":
                tipoTurnoTramite = Turno.Tramite.DUDAS;
                break;
            case "ENTREGA_DOCUMENTACION":
                tipoTurnoTramite = Turno.Tramite.ENTREGA_DOCUMENTACION;
            case "PRESENTAR_DECLARACION":
                tipoTurnoTramite = Turno.Tramite.PRESENTAR_DECLARACION;
                break;
            case "RECLAMACIONES":
                tipoTurnoTramite = Turno.Tramite.RECLAMACIONES;
                break;
            case "OTRAS_CONSULTAS":
                tipoTurnoTramite = Turno.Tramite.OTRAS_CONSULTAS;
                break;
            case "SIN_OPCION":
                tipoTurnoTramite = Turno.Tramite.OTRAS_CONSULTAS;
                break;
            default:
                //Si no es ninguno de los casos, lanza una excepción personalizada
                throw new TurnoInvalidException("trámite inválido");

        }

        //voy a traer la lista de ciudadanos y el código del turno usando el método de la clase OperacionesNumericas
        List<Turno> listaTurno = turnoJPA.findAllGenerico().orElse(null);
        //uso la lista de ciudadanos para verificar que no se repite el mismo número de turno
        Integer codigoTurno = OperacionesNumericas.crearCodigoTurno(ciudadano.getId(), listaTurno);


        // si todo va bien, creo un turno, creo un objeto con los valores recopilados
        Turno turno = new Turno(turnoFechaFormateado, codigoTurno, tipoTurnoTramite, ciudadano);

        //finalmente lo introduciré en la base de datos
        turnoJPA.createGenerico(turno);
    }


    //para listar turnos
    public Optional<List<Turno>> listAllTurnos() {

        return turnoJPA.findAllGenerico();
    }


    //para filtrar los turnos con parámetros de fecha y estado
    public List<Turno> listTurnoFiltered(String fechaFiltroInicial, String fechaFiltroFinal, String estadoFiltro) throws TurnoInvalidException {

        //1º, paso la fecha a LodalDateTime
        LocalDateTime fechaFiltrarInicial = FormatearFecha.fechaAnioMesDia(fechaFiltroInicial);
        LocalDateTime fechaFiltrarFinal = FormatearFecha.fechaAnioMesDia(fechaFiltroFinal);


        //instancio un estado para conseguir una variable de estado fijo de tipo estado
        Turno.Estado estado = null;

        //2º, valido que el trámite que llega, sea correcto

        //voy a validar el string de entrada para que se asigne una variable de tipo Estado
        switch (estadoFiltro) {
            case "EN_ESPERA":
                estado = Turno.Estado.EN_ESPERA;
                break;
            case "YA_ATENDIDO":
                estado = Turno.Estado.YA_ATENDIDO;
                break;
            case "SIN_OPCION":
                /*HAGO ESTO PARA QUE PASE Y NO EJEUTE EL DEFAULT Y PUEDA SEGIR SIN USAR LA VARIABLE ESTADO
                 YA QUE NO ME VA A SERVIR PARA SILTRAR SIN ESTADO */
                break;
            default:
                //Si no es ninguno de los casos, lanza una excepción personalizada
                throw new TurnoInvalidException("Estado inválido");
        }

        //vamos a filtrar los turnos a partir de la fecha indicada y el estado que se ha seleccionado
        List<Turno> listaFiltrar = null;

        listaFiltrar = turnoJPA.findAllGenerico().orElse(null);


        //3º filtro la lista con los parámetros introducidos

        //creo un turno para mandar al servlet
        List<Turno> turnosFiltrados;
        //creo una lista para enviar al servlet en caso de que solo se filtre por fecha
        List<Turno> turnosFiltradosFecha;

        //1º convierto la lista en un flujo con estream, si la lista no es nula
        if (listaFiltrar != null) {
            turnosFiltradosFecha = listaFiltrar.stream()

                    //2º hago el filtrado de la fecha inicial y final
                    .filter(n -> n.getFecha().isAfter(fechaFiltrarInicial) && n.getFecha().isBefore(fechaFiltrarFinal))
                    //3º uso sorted que sirve para ordenar una lista en base a un criterio en este caso es la fecha
                    //uso .reverse para que lo ponga en orden de actual a mas antigua
                    .sorted(Comparator.comparing(Turno::getFecha).reversed())
                    //convierto el flujo en una lista
                    .collect(Collectors.toList());
            turnosFiltrados = turnosFiltradosFecha;

        } else {
            //me aseguro que la lista no está vacía, si lo está, mando excepción
            throw new NullPointerException("Lista de turnos filtrados por fechavacía");
        }

        /*si la variable de estado no es null porque se le ha asignado un valor,
         entonces vuelvo a filtrar los resultados ya filtrados por fechaconseguir los
         resultados estado que llega desde el jsp */
        if (estado != null) {
            //creo una variable para usarla en el if
            Turno.Estado finalEstado = estado;

            //uso .reverse para que lo ponga en orden de actual a mas antigua
            //convierto el flujo en una lista
            //se va a filtrar el estado pero con la fecha ya filtrada anteriormente
            turnosFiltrados = turnosFiltradosFecha.stream()
                    .filter(j -> j.getEstado().equals(finalEstado))
                    //uso .reverse para que lo ponga en orden de actual a mas antigua
                    .sorted(Comparator.comparing(Turno::getFecha).reversed())
                    //convierto el flujo en una lista
                    .collect(Collectors.toList());
        }

        if (turnosFiltrados.isEmpty()) {
            //me aseguro que la lista no está vacía, si lo está, mando excepción
            throw new NullPointerException("Lista de turnos filtrados por fecha y estado vacía");
        }

        //lo mando nulo por si hay algún fallo, lo envío al servlet para que saque el error en un página
        return turnosFiltrados;
    }
}
