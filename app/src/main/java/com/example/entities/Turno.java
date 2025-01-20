package com.example.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Turno {

    //variables de clase y relaciones con JPA

    //para la identidad establezco que el id del turno va a ser único
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer codigoTurno;

    //sólo puede tener dos estados En espera o Ya atendido, creo una clase para enumerar
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(nullable = false)
    private LocalDateTime fecha;

    //he establecido unos trámites fijos que solo van a tener unos valores fijos
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ciudadano_id", nullable = false)
    private Ciudadano ciudadano;

    //creo la clase estado para que me cree los tipos de estados posibles
    public enum Estado{
        EN_ESPERA,
        YA_ATENDIDO,
    }

    //creo la clase trámite para que contenga sólo los tramites prefijados por la aplicación
    public enum Tramite{

        PRESENTAR_DECLARACION_RENTA,
        DUDAS,
        ENTREGA_DOCUMENTACION,
        PRESENTAR_DECLARACION,
        RECLAMACIONES,
        OTRAS_CONSULTAS
    }

    //constructores
    public Turno(){};

    //creo un constructor sin id ni código de turno, ya que el código del turno se generará automáticamente

    /* he modificado el constructor para que me cree un estado por defecto, ya que cuando se crea un turno,
    se entiendo que el estado será en espeara hasta ser atendido  */
    public Turno(LocalDateTime fecha,Integer codigoTurno, Tramite tramite, Ciudadano ciudadano) {
        this.estado = Estado.EN_ESPERA;
        this.fecha = fecha;
        this.tramite = tramite;
        this.ciudadano = ciudadano;
        this.codigoTurno = codigoTurno;
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoTurno() {
        return codigoTurno;
    }

    public void setCodigoTurno(Integer codigoTurno) {
        this.codigoTurno = codigoTurno;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    //toString

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", codigoTurno=" + codigoTurno +
                ", fecha=" + fecha +
                ", tramite=" + tramite +
                ", diudadano=" + ciudadano +
                '}';
    }
}
