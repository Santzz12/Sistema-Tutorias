package edu.uees.tutorias.domain;

public class Docente {
    private String id;
    private String nombre;
    private String especialidad;

    public Docente(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }
}