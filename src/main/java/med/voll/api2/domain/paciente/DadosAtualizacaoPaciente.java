package med.voll.api2.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api2.domain.endereco.DadosEndereco;
import med.voll.api2.domain.endereco.Endereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,

        @Valid
        DadosEndereco endereco) {
}
