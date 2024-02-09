package med.voll.api2.domain.consulta.validacoes.agendamento;

import med.voll.api2.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api2.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var diferencaEmMinutos = Duration.between(LocalDateTime.now(), dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("A consulta deve ser marcada com mais de 30 minutos de antecedência");
        }
    }
}
