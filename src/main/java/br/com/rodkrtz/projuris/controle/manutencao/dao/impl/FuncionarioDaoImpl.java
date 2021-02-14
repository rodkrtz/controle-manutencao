package br.com.rodkrtz.projuris.controle.manutencao.dao.impl;

import br.com.rodkrtz.projuris.controle.manutencao.dao.FuncionarioDao;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Funcionario;
import br.com.rodkrtz.projuris.controle.manutencao.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Rodrigo Kreutzfeld
 */
@Component
public class FuncionarioDaoImpl implements FuncionarioDao {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario findByEmail(String email) {
        return funcionarioRepository.findByEmail(email);
    }

    @Override
    public void save(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }
}
