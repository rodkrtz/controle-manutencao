package br.com.rodkrtz.projuris.controle.manutencao.service;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Cliente;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddClienteRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rodrigo Kreutzfeld
 */
@Service
public interface ClienteService {

    Cliente getClienteByEmail(String email);

    Cliente addCliente(AddClienteRequest addClienteRequest);

    List<Cliente> getClientes();
}
