package med.voll.api2.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull
        @JsonAlias({"id", "id_consulta"})
        Long idConsulta,

        @NotNull
        @JsonAlias({"motivo", "motivo_cancelamento"})
        MotivoCancelamento motivo) {
}
