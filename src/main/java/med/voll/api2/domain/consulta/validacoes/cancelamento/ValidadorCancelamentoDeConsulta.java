package med.voll.api2.domain.consulta.validacoes.cancelamento;

import med.voll.api2.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api2.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
    void validar(DadosCancelamentoConsulta dados);
}
