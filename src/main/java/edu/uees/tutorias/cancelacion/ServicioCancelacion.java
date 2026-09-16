package edu.uees.tutorias.cancelacion;

import edu.uees.tutorias.domain.Reserva;
import java.time.LocalDateTime;
import java.util.Objects;

public final class ServicioCancelacion {
    private final PoliticaCancelacion politica;

    public ServicioCancelacion(PoliticaCancelacion politica) {
        this.politica = Objects.requireNonNull(politica, "politica es obligatoria");
    }

    public ResultadoCancelacion cancelar(
            Reserva reserva,
            LocalDateTime momentoCancelacion) {
        Objects.requireNonNull(reserva, "reserva es obligatoria");
        Objects.requireNonNull(momentoCancelacion, "momentoCancelacion es obligatorio");

        if (!politica.permiteCancelar(reserva, momentoCancelacion)) {
            return new ResultadoCancelacion(
                    false,
                    "Cancelación rechazada por política " + politica.nombre());
        }

        reserva.cancelar();
        return new ResultadoCancelacion(
                true,
                "Reserva cancelada mediante política " + politica.nombre());
    }
}
