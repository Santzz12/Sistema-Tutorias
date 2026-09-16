package edu.uees.tutorias.cancelacion;

import edu.uees.tutorias.domain.Reserva;
import java.time.LocalDateTime;

public interface PoliticaCancelacion {
    boolean permiteCancelar(Reserva reserva, LocalDateTime momentoCancelacion);

    String nombre();
}
