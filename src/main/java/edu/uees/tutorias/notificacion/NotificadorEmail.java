package edu.uees.tutorias.notificacion;

public final class NotificadorEmail implements Notificador {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.printf("[EMAIL] %s: %s%n", destinatario, mensaje);
    }
}
