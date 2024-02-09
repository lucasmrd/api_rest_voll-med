package med.voll.api2.domain.consulta.validacoes.agendamento;

import med.voll.api2.domain.consulta.ConsultaRepository;
import med.voll.api2.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api2.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {

        var medicoPossuiOutraConsultaNoMesmoHorario = consultaRepository
                .existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());

        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possúi uma consulta neste horário");
        }
    }
}
