package edu.uees.tutorias.cancelacion;

import edu.uees.tutorias.domain.EstadoReserva;
import edu.uees.tutorias.domain.Reserva;
import java.time.Duration;
import java.time.LocalDateTime;

public final class PoliticaCancelacionRegular implements PoliticaCancelacion {
    static final long MINUTOS_MINIMOS = 120;

    @Override
    public boolean permiteCancelar(Reserva reserva, LocalDateTime momentoCancelacion) {
        return tieneEstadoCancelable(reserva)
                && minutosHastaTutoria(reserva, momentoCancelacion) >= MINUTOS_MINIMOS;
    }

    @Override
    public String nombre() {
        return "Regular (mínimo 2 horas)";
    }

    private boolean tieneEstadoCancelable(Reserva reserva) {
        return reserva.getEstado() == EstadoReserva.SOLICITADA
                || reserva.getEstado() == EstadoReserva.CONFIRMADA;
    }

    private long minutosHastaTutoria(Reserva reserva, LocalDateTime momentoCancelacion) {
        return Duration.between(
                        momentoCancelacion,
                        reserva.getHorario().getInicio())
                .toMinutes();
    }
}
