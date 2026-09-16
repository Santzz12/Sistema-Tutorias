package edu.uees.tutorias.notificacion;

public final class NotificadorSms implements Notificador {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.printf("[SMS] %s: %s%n", destinatario, mensaje);
    }
}
