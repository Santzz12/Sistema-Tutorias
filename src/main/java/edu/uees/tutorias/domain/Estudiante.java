package edu.uees.tutorias.domain;

public class Estudiante {
    private String matricula;
    private String nombre;
    private String correo;

    public Estudiante(String matricula, String nombre, String correo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }
}