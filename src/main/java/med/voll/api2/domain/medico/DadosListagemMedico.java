package med.voll.api2.domain.medico;

import med.voll.api2.domain.medico.Especialidade;
import med.voll.api2.domain.medico.Medico;

public record DadosListagemMedico(
        Long id,

        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
