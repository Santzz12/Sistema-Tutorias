package edu.uees.tutorias.domain;

import java.time.LocalDateTime;

public class HorarioDisponible {
    private LocalDateTime fechaHora;
    private boolean isOcupado;

    public HorarioDisponible(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
        this.isOcupado = false; // Por defecto nace libre
    }

    public void bloquear() {
        this.isOcupado = true;
    }

    public void liberar() {
        this.isOcupado = false;
    }

    public boolean isOcupado() {
        return isOcupado;
    }
}