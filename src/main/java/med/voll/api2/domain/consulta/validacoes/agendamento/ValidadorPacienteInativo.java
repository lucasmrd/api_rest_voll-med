package med.voll.api2.domain.consulta.validacoes.agendamento;

import med.voll.api2.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api2.domain.paciente.PacienteRepository;
import med.voll.api2.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteInativo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = pacienteRepository.findAtivoById(dados.idPaciente());

        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("O paciente está inativo no sistema!");
        }
    }
}
