package br.com.rodkrtz.projuris.controle.manutencao.service;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Cliente;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.CadastroClienteRequest;
import org.springframework.stereotype.Service;

/**
 * @author Rodrigo Kreutzfeld
 */
@Service
public interface ClienteService {

    Cliente getClienteByEmail(String email);

    Cliente cadastrarCliente(CadastroClienteRequest cadastroClienteRequest);
}
