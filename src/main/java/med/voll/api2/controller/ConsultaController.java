package med.voll.api2.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api2.domain.consulta.ConsultaService;
import med.voll.api2.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api2.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta(@RequestBody @Valid DadosAgendamentoConsulta dadosAgendamento) {
        var dtoAgendamento = consultaService.agendar(dadosAgendamento);

        return ResponseEntity.ok().body(dtoAgendamento);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelarConsulta(@RequestBody @Valid DadosCancelamentoConsulta dadosCancelamento) {
        consultaService.cancelar(dadosCancelamento);

        return ResponseEntity.noContent().build();
    }
}
