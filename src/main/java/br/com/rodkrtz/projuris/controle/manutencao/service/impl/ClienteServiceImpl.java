package br.com.rodkrtz.projuris.controle.manutencao.service.impl;

import br.com.rodkrtz.projuris.controle.manutencao.dao.ClienteDao;
import br.com.rodkrtz.projuris.controle.manutencao.exception.ExceptionType;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Cliente;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddClienteRequest;
import br.com.rodkrtz.projuris.controle.manutencao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Rodrigo Kreutzfeld
 */
@Component
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public Cliente getClienteByEmail(String email) {
        Cliente cliente = clienteDao.findByEmail(email);
        if (cliente == null) {
            ExceptionType.NOT_FOUND.throwException("Não foi encontrado um cliente com esse email ".concat(email));
        }
        return cliente;
    }

    @Override
    public Cliente addCliente(AddClienteRequest addClienteRequest) {
        Cliente cliente = clienteDao.findByEmail(addClienteRequest.getEmail());

        if (cliente != null) {
            ExceptionType.BAD_REQUEST.throwException("Já existe um cliente registrado com esse email ".concat(addClienteRequest.getEmail()));
        }

        cliente = new Cliente()
                .setEmail(addClienteRequest.getEmail())
                .setEndereco(addClienteRequest.getEndereco())
                .setNome(addClienteRequest.getNome())
                .setTelefone(addClienteRequest.getTelefone());

        clienteDao.save(cliente);

        return cliente;
    }
}
