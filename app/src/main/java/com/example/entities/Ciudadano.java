package com.example.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Ciudadano {

    //variables de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //hacer que los campos de nombre y apellido no sean nulos, ya que son importantes
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;

    private String direccion;

    //establezcer relación de ciudadano con los turnos que este puede tener
    //esta clase va a ser la entidad principal
    @OneToMany(mappedBy = "ciudadano", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Turno> turnos;

    //constructores

    public Ciudadano(){}

    public Ciudadano(Long id, String nombre, String apellido, String direccion, Set<Turno> turnos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.turnos = turnos;
    }
    //crear construtor sin id que se creará el id automáticamtne en la base de datos
    public Ciudadano(String nombre, String apellido, String direccion, Set<Turno> turnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.turnos = turnos;
    }

    //por si creo un ciudadano pero sin turnos
    public Ciudadano(String nombre, String apellido, String direccion) {
        this.direccion = direccion;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    //Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    //toString

    @Override
    public String toString() {
        return "Ciudadano{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", turnos=" + turnos +
                '}';
    }
}
