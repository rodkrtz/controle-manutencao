package br.com.rodkrtz.projuris.controle.manutencao.service;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Funcionario;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddFuncionarioRequest;
import org.springframework.stereotype.Service;

/**
 * @author Rodrigo Kreutzfeld
 */
@Service
public interface FuncionarioService {

    Funcionario getByEmail(String email);

    Funcionario addFuncionario(AddFuncionarioRequest addFuncionarioRequest);
}
