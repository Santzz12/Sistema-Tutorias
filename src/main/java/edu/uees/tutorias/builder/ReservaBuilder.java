package edu.uees.tutorias.builder;

import edu.uees.tutorias.domain.EstadoReserva;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioDisponible;
import edu.uees.tutorias.domain.Reserva;

public final class ReservaBuilder {
    private String id;
    private Estudiante estudiante;
    private HorarioDisponible horario;
    private String tema = "Sin especificar";
    private String observaciones = "Sin observaciones";
    private boolean enviarRecordatorio;

    public ReservaBuilder id(String id) {
        this.id = id;
        return this;
    }

    public ReservaBuilder estudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        return this;
    }

    public ReservaBuilder horario(HorarioDisponible horario) {
        this.horario = horario;
        return this;
    }

    public ReservaBuilder tema(String tema) {
        this.tema = tema;
        return this;
    }

    public ReservaBuilder observaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public ReservaBuilder enviarRecordatorio(boolean enviarRecordatorio) {
        this.enviarRecordatorio = enviarRecordatorio;
        return this;
    }

    public Reserva build() {
        validarObligatorios();
        return new Reserva(
                id,
                estudiante,
                horario,
                EstadoReserva.SOLICITADA,
                tema,
                observaciones,
                enviarRecordatorio);
    }

    private void validarObligatorios() {
        if (id == null || id.isBlank()) {
            throw new IllegalStateException("id es obligatorio");
        }
        if (estudiante == null) {
            throw new IllegalStateException("estudiante es obligatorio");
        }
        if (horario == null) {
            throw new IllegalStateException("horario es obligatorio");
        }
    }
}
