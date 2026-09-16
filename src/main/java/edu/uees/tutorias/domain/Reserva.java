package edu.uees.tutorias.domain;

import java.util.Objects;

public final class Reserva {
    private final String id;
    private final Estudiante estudiante;
    private final HorarioDisponible horario;
    private EstadoReserva estado;
    private final String tema;
    private final String observaciones;
    private final boolean enviarRecordatorio;

    public Reserva(
            String id,
            Estudiante estudiante,
            HorarioDisponible horario,
            EstadoReserva estado,
            String tema,
            String observaciones,
            boolean enviarRecordatorio) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id es obligatorio");
        }
        this.id = id;
        this.estudiante = Objects.requireNonNull(estudiante, "estudiante es obligatorio");
        this.horario = Objects.requireNonNull(horario, "horario es obligatorio");
        this.estado = Objects.requireNonNull(estado, "estado es obligatorio");
        this.tema = tema;
        this.observaciones = observaciones;
        this.enviarRecordatorio = enviarRecordatorio;
    }

    public void confirmar() {
        exigirEstado(EstadoReserva.SOLICITADA, "confirmar");
        horario.reservar();
        estado = EstadoReserva.CONFIRMADA;
    }

    public void cancelar() {
        if (estado != EstadoReserva.SOLICITADA && estado != EstadoReserva.CONFIRMADA) {
            throw new IllegalStateException("no se puede cancelar una reserva " + estado);
        }
        if (estado == EstadoReserva.CONFIRMADA) {
            horario.liberar();
        }
        estado = EstadoReserva.CANCELADA;
    }

    public void finalizar() {
        exigirEstado(EstadoReserva.CONFIRMADA, "finalizar");
        estado = EstadoReserva.FINALIZADA;
    }

    private void exigirEstado(EstadoReserva esperado, String operacion) {
        if (estado != esperado) {
            throw new IllegalStateException(
                    "no se puede " + operacion + " una reserva " + estado);
        }
    }

    public String getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public HorarioDisponible getHorario() {
        return horario;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public String getTema() {
        return tema;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public boolean isEnviarRecordatorio() {
        return enviarRecordatorio;
    }
}
