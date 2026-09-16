package edu.uees.tutorias.notificacion;

public final class NotificadorPush implements Notificador {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.printf("[PUSH] %s: %s%n", destinatario, mensaje);
    }
}
