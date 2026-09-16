package edu.uees.tutorias.notificacion;

public abstract class NotificacionFactory {
    public abstract Notificador crearNotificador();

    public void notificar(String destinatario, String mensaje) {
        crearNotificador().enviar(destinatario, mensaje);
    }
}
