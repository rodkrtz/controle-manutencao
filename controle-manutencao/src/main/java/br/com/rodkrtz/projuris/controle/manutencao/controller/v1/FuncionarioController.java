package br.com.rodkrtz.projuris.controle.manutencao.controller.v1;

import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddFuncionarioRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rodrigo Kreutzfeld
 */
@RestController
@RequestMapping("/api/v1/funcionarios")
public interface FuncionarioController {

    @GetMapping("{email}")
    ResponseEntity<?> getFuncionario(@PathVariable String email);

    @PutMapping
    ResponseEntity<?> addFuncionario(@RequestBody AddFuncionarioRequest addFuncionarioRequest);
}
