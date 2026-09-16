package edu.uees.tutorias;

import edu.uees.tutorias.builder.ReservaBuilder;
import edu.uees.tutorias.cancelacion.PoliticaCancelacionPrioritaria;
import edu.uees.tutorias.cancelacion.PoliticaCancelacionRegular;
import edu.uees.tutorias.cancelacion.ResultadoCancelacion;
import edu.uees.tutorias.cancelacion.ServicioCancelacion;
import edu.uees.tutorias.domain.Docente;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.HorarioDisponible;
import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.notificacion.EmailFactory;
import edu.uees.tutorias.observer.CalendarioObserver;
import edu.uees.tutorias.observer.NotificacionReservaObserver;
import edu.uees.tutorias.observer.PanelTutoriasObserver;
import java.time.LocalDateTime;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante(
                "E-001", "Erick Gamarra", "erick@uees.edu.ec", "Ingeniería en Computación");
        Docente docente = new Docente(
                "D-001", "Ana Torres", "ana.torres@uees.edu.ec", "Diseño de Software");
        LocalDateTime inicioRegular = LocalDateTime.of(2026, 9, 20, 15, 0);
        HorarioDisponible horarioRegular = new HorarioDisponible(
                "H-001",
                docente,
                inicioRegular,
                inicioRegular.plusHours(1));

        Reserva reservaRegular = new ReservaBuilder()
                .id("R-001")
                .estudiante(estudiante)
                .horario(horarioRegular)
                .tema("Patrones de diseño")
                .observaciones("Revisar Strategy y Observer")
                .enviarRecordatorio(true)
                .build();

        CalendarioObserver calendario = new CalendarioObserver();
        PanelTutoriasObserver panel = new PanelTutoriasObserver();
        registrarObservadores(reservaRegular, calendario, panel);

        reservaRegular.confirmar();
        ResultadoCancelacion resultadoRegular = new ServicioCancelacion(
                new PoliticaCancelacionRegular())
                .cancelar(reservaRegular, inicioRegular.minusHours(5));

        LocalDateTime inicioPrioritario = LocalDateTime.of(2026, 9, 21, 10, 0);
        HorarioDisponible horarioPrioritario = new HorarioDisponible(
                "H-002",
                docente,
                inicioPrioritario,
                inicioPrioritario.plusHours(1));
        Reserva reservaPrioritaria = new ReservaBuilder()
                .id("R-002")
                .estudiante(estudiante)
                .horario(horarioPrioritario)
                .tema("Principios SOLID")
                .build();
        registrarObservadores(reservaPrioritaria, calendario, panel);

        reservaPrioritaria.confirmar();
        ResultadoCancelacion resultadoPrioritario = new ServicioCancelacion(
                new PoliticaCancelacionPrioritaria())
                .cancelar(reservaPrioritaria, inicioPrioritario.minusHours(1));

        System.out.println(resultadoRegular.detalle());
        System.out.println(resultadoPrioritario.detalle());
        System.out.println("Eventos de calendario: " + calendario.getEventos().size());
        System.out.println("Eventos de panel: " + panel.getEventos().size());
    }

    private static void registrarObservadores(
            Reserva reserva,
            CalendarioObserver calendario,
            PanelTutoriasObserver panel) {
        reserva.agregarObservador(calendario);
        reserva.agregarObservador(panel);
        reserva.agregarObservador(new NotificacionReservaObserver(new EmailFactory()));
    }
}
