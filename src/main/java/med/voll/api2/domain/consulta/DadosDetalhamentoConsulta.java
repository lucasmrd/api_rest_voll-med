package med.voll.api2.domain.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import med.voll.api2.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(
        Long idConsulta,

        Long idMedico,

        Long idPaciente,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data,

        String nomeMedico,
        Especialidade especialidade) {


    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(),
                consulta.getData(), consulta.getMedico().getNome(), consulta.getMedico().getEspecialidade());
    }
}
