package edu.uees.tutorias.notificacion;

public final class WhatsAppFactory extends NotificacionFactory {
    @Override
    public Notificador crearNotificador() {
        return new NotificadorWhatsApp();
    }
}
