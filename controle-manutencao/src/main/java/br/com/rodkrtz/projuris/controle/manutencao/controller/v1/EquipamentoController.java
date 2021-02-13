package br.com.rodkrtz.projuris.controle.manutencao.controller.v1;

import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddEquipamentoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rodrigo Kreutzfeld
 */
@RestController
@RequestMapping("/api/v1/equipamentos")
public interface EquipamentoController {

    @GetMapping("{numeroSerie}")
    ResponseEntity<?> getEquipamento(@PathVariable String numeroSerie);

    @PutMapping
    ResponseEntity<?> addEquipamento(@RequestBody AddEquipamentoRequest addEquipamentoRequest);
}
