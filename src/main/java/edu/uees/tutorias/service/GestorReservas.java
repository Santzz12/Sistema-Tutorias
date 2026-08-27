package edu.uees.tutorias.service;

import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.domain.Estudiante;
import edu.uees.tutorias.domain.Docente;
import edu.uees.tutorias.notification.Notificador;

public class GestorReservas {
    private Notificador notificador;

    // Aquí aplicamos la inyección de dependencias (SOLID)
    public GestorReservas(Notificador notificador) {
        this.notificador = notificador;
    }

    public Reserva crearReserva(String id, Estudiante estudiante, Docente docente) {
        Reserva nuevaReserva = new Reserva(id, estudiante, docente);
        notificador.enviarMensaje(estudiante, "Tu reserva " + id + " ha sido registrada correctamente.");
        return nuevaReserva;
    }
}