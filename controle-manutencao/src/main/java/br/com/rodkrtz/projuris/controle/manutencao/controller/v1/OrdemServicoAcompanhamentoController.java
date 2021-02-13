package br.com.rodkrtz.projuris.controle.manutencao.controller.v1;

import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddOrdemServicoAcompanhamentoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rodrigo Kreutzfeld
 */
@RestController
@RequestMapping("/api/v1/ordemServicos/acompanhamento")
public interface OrdemServicoAcompanhamentoController {

    @PutMapping
    ResponseEntity<?> addAcompanhamento(@RequestBody AddOrdemServicoAcompanhamentoRequest addOrdemServicoAcompanhamentoRequest);
}
