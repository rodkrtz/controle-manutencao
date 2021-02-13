package br.com.rodkrtz.projuris.controle.manutencao.controller.v1;

import br.com.rodkrtz.projuris.controle.manutencao.model.request.CadastroClienteRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
public interface ClienteController {

    @PutMapping
    ResponseEntity<?> cadastrarCliente(@RequestBody CadastroClienteRequest cadastroClienteRequest);

    @GetMapping("{email}")
    ResponseEntity<?> getCliente(@PathVariable String email);
}
