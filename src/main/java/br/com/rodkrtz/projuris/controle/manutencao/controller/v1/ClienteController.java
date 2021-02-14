package br.com.rodkrtz.projuris.controle.manutencao.controller.v1;

import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddClienteRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
public interface ClienteController {

    @PutMapping
    ResponseEntity<?> addCliente(@RequestBody AddClienteRequest addClienteRequest);

    @GetMapping("{email}")
    ResponseEntity<?> getCliente(@PathVariable String email);

    @GetMapping
    ResponseEntity<?> getClientes();
}
