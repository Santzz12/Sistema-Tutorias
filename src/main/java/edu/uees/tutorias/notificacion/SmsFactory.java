package edu.uees.tutorias.notificacion;

public final class SmsFactory extends NotificacionFactory {
    @Override
    public Notificador crearNotificador() {
        return new NotificadorSms();
    }
}
