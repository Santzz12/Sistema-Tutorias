package edu.uees.tutorias.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public final class HorarioDisponible {
    private final String id;
    private final Docente docente;
    private final LocalDateTime inicio;
    private final LocalDateTime fin;
    private boolean reservado;

    public HorarioDisponible(
            String id,
            Docente docente,
            LocalDateTime inicio,
            LocalDateTime fin) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id es obligatorio");
        }
        this.docente = Objects.requireNonNull(docente, "docente es obligatorio");
        this.inicio = Objects.requireNonNull(inicio, "inicio es obligatorio");
        this.fin = Objects.requireNonNull(fin, "fin es obligatorio");
        if (!fin.isAfter(inicio)) {
            throw new IllegalArgumentException("fin debe ser posterior a inicio");
        }
        this.id = id;
    }

    public void reservar() {
        if (reservado) {
            throw new IllegalStateException("el horario ya está reservado");
        }
        reservado = true;
    }

    public void liberar() {
        reservado = false;
    }

    public String getId() {
        return id;
    }

    public Docente getDocente() {
        return docente;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public boolean isReservado() {
        return reservado;
    }
}
