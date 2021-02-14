package br.com.rodkrtz.projuris.controle.manutencao.service.impl;

import br.com.rodkrtz.projuris.controle.manutencao.dao.FuncionarioDao;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Funcionario;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddFuncionarioRequest;
import br.com.rodkrtz.projuris.controle.manutencao.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.com.rodkrtz.projuris.controle.manutencao.exception.ExceptionType.BAD_REQUEST;
import static br.com.rodkrtz.projuris.controle.manutencao.exception.ExceptionType.NOT_FOUND;

/**
 * @author Rodrigo Kreutzfeld
 */
@Component
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioDao funcionarioDao;

    @Override
    public Funcionario getByEmail(String email) {
        Funcionario funcionario = funcionarioDao.findByEmail(email);

        if (funcionario == null) {
            NOT_FOUND.throwException("Não foi encontrado um funcionário com esse código ".concat(email));
        }

        return funcionario;
    }

    @Override
    public Funcionario addFuncionario(AddFuncionarioRequest addFuncionarioRequest) {

        Funcionario funcionario = funcionarioDao.findByEmail(addFuncionarioRequest.getEmail());

        if (funcionario != null) {
            BAD_REQUEST.throwException("Já existe um funcionário registrado com esse email ".concat(addFuncionarioRequest.getEmail()));
        }

        funcionario = new Funcionario()
                .setEmail(addFuncionarioRequest.getEmail())
                .setFuncao(addFuncionarioRequest.getFuncao())
                .setNome(addFuncionarioRequest.getNome());

        funcionarioDao.save(funcionario);

        return funcionario;

    }


}
