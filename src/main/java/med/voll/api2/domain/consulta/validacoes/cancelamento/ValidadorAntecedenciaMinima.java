package med.voll.api2.domain.consulta.validacoes.cancelamento;

import med.voll.api2.domain.consulta.ConsultaRepository;
import med.voll.api2.domain.consulta.DadosCancelamentoConsulta;
import med.voll.api2.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorAntecedenciaMinima implements ValidadorCancelamentoDeConsulta {

    @Autowired
    ConsultaRepository consultaRepository;

    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());

        var DiferencaDeHoras = Duration.between(LocalDateTime.now(), consulta.getData()).toHours();

        if (DiferencaDeHoras >= 24) {
            throw new ValidacaoException("Só é possível cancelar uma consulta com antecedência de 24 horas");
        }
    }
}
