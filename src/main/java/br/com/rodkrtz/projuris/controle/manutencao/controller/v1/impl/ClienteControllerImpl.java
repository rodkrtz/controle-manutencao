package br.com.rodkrtz.projuris.controle.manutencao.controller.v1.impl;

import br.com.rodkrtz.projuris.controle.manutencao.controller.v1.ClienteController;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Cliente;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddClienteRequest;
import br.com.rodkrtz.projuris.controle.manutencao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Rodrigo Kreutzfeld
 */
@Component
public class ClienteControllerImpl implements ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Override
    public ResponseEntity<?> addCliente(AddClienteRequest addClienteRequest) {
        Cliente cliente = clienteService.addCliente(addClienteRequest);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getCliente(String email) {
        Cliente cliente = clienteService.getClienteByEmail(email);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getClientes() {
        List<Cliente> clientes = clienteService.getClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
}
