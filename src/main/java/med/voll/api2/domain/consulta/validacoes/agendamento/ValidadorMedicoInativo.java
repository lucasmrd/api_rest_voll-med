package med.voll.api2.domain.consulta.validacoes.agendamento;

import med.voll.api2.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api2.domain.medico.MedicoRepository;
import med.voll.api2.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoInativo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {

        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());

        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Médico está inativo no sistema");
        }
    }
}
