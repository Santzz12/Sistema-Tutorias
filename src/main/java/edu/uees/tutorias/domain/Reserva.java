package edu.uees.tutorias.domain;

public class Reserva {
    private String id;
    private Estudiante estudiante;
    private Docente docente;
    private EstadoReserva estado;

    public Reserva(String id, Estudiante estudiante, Docente docente) {
        this.id = id;
        this.estudiante = estudiante;
        this.docente = docente;
        this.estado = EstadoReserva.PENDIENTE; // Regla de negocio: nace pendiente
    }

    public void confirmar() {
        this.estado = EstadoReserva.CONFIRMADA;
    }

    public void cancelar() {
        this.estado = EstadoReserva.CANCELADA;
    }

    public EstadoReserva getEstado() {
        return estado;
    }
}