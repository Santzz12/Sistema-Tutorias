package edu.uees.tutorias.domain;

public final class Estudiante extends Usuario {
    private final String carrera;

    public Estudiante(String id, String nombre, String email, String carrera) {
        super(id, nombre, email);
        if (carrera == null || carrera.isBlank()) {
            throw new IllegalArgumentException("carrera es obligatoria");
        }
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }
}
