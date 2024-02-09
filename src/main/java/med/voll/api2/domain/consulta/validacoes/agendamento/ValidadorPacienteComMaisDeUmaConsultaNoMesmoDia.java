package med.voll.api2.domain.consulta.validacoes.agendamento;

import med.voll.api2.domain.consulta.ConsultaRepository;
import med.voll.api2.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api2.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteComMaisDeUmaConsultaNoMesmoDia implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);

        var pacientePossuiOutraConsulta = consultaRepository
                .existsByPacienteIdAndDataBetweenAndMotivoCancelamentoIsNull(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if (pacientePossuiOutraConsulta) {
            throw new ValidacaoException("Paciente já possui outra consulta no mesmo dia");
        }
    }
}
