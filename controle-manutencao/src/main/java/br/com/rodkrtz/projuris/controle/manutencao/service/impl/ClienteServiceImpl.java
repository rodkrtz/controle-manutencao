package br.com.rodkrtz.projuris.controle.manutencao.service.impl;

import br.com.rodkrtz.projuris.controle.manutencao.dao.ClienteDao;
import br.com.rodkrtz.projuris.controle.manutencao.exception.ExceptionType;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Cliente;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.CadastroClienteRequest;
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
    public Cliente cadastrarCliente(CadastroClienteRequest cadastroClienteRequest) {
        Cliente cliente = clienteDao.findByEmail(cadastroClienteRequest.getEmail());

        if (cliente != null) {
            ExceptionType.BAD_REQUEST.throwException("Já existe um cliente cadastrado com esse email ".concat(cadastroClienteRequest.getEmail()));
        }

        cliente = new Cliente()
                .setEmail(cadastroClienteRequest.getEmail())
                .setEndereco(cadastroClienteRequest.getEndereco())
                .setNome(cadastroClienteRequest.getNome())
                .setTelefone(cadastroClienteRequest.getTelefone());

        clienteDao.save(cliente);

        return cliente;
    }
}
