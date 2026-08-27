package edu.uees.tutorias.notification;

import edu.uees.tutorias.domain.Estudiante;

public interface Notificador {
    void enviarMensaje(Estudiante estudiante, String mensaje);
}