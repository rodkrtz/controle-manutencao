package br.com.rodkrtz.projuris.controle.manutencao.controller.v1;

import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddOrdemServicoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rodrigo Kreutzfeld
 */
@RestController
@RequestMapping("/api/v1/ordemServicos")
public interface OrdemServicoController {

    @GetMapping("{chaveId}")
    ResponseEntity<?> getOrdemServico(@PathVariable String chaveId);

    @GetMapping("/pendentes")
    ResponseEntity<?> listPendentes();

    @PutMapping
    ResponseEntity<?> addOrdemServico(AddOrdemServicoRequest addOrdemServicoRequest);

    @DeleteMapping("{chaveId}")
    ResponseEntity<?> removeOrdemServico(@PathVariable String chaveId);
}
