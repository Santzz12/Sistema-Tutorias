package edu.uees.tutorias.notificacion;

public final class NotificadorWhatsApp implements Notificador {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.printf("[WHATSAPP] %s: %s%n", destinatario, mensaje);
    }
}
