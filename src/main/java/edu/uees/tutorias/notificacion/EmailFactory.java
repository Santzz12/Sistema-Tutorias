package edu.uees.tutorias.notificacion;

public final class EmailFactory extends NotificacionFactory {
    @Override
    public Notificador crearNotificador() {
        return new NotificadorEmail();
    }
}
