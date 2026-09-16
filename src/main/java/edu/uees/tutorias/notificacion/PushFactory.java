package edu.uees.tutorias.notificacion;

public final class PushFactory extends NotificacionFactory {
    @Override
    public Notificador crearNotificador() {
        return new NotificadorPush();
    }
}
