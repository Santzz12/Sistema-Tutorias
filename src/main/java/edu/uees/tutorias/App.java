package edu.uees.tutorias;

import edu.uees.tutorias.builder.ReservaBuilder;
import edu.uees.tutorias.domain.Docente;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioDisponible;
import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.notificacion.EmailFactory;
import java.time.LocalDateTime;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante(
                "E-001", "Erick Gamarra", "erick@uees.edu.ec", "Ingeniería en Computación");
        Docente docente = new Docente(
                "D-001", "Ana Torres", "ana.torres@uees.edu.ec", "Diseño de Software");
        HorarioDisponible horario = new HorarioDisponible(
                "H-001",
                docente,
                LocalDateTime.of(2026, 9, 20, 15, 0),
                LocalDateTime.of(2026, 9, 20, 16, 0));

        Reserva reserva = new ReservaBuilder()
                .id("R-001")
                .estudiante(estudiante)
                .horario(horario)
                .tema("Patrones de diseño")
                .observaciones("Revisar Factory Method y Builder")
                .enviarRecordatorio(true)
                .build();

        reserva.confirmar();
        new EmailFactory().notificar(
                estudiante.getEmail(),
                "Reserva " + reserva.getId() + " confirmada");
        System.out.println("Estado final: " + reserva.getEstado());
    }
}
