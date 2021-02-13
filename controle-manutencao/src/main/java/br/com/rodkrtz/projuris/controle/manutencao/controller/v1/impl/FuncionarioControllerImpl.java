package br.com.rodkrtz.projuris.controle.manutencao.controller.v1.impl;

import br.com.rodkrtz.projuris.controle.manutencao.controller.v1.FuncionarioController;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Funcionario;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddFuncionarioRequest;
import br.com.rodkrtz.projuris.controle.manutencao.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rodrigo Kreutzfeld
 */
@Component
public class FuncionarioControllerImpl implements FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Override
    public ResponseEntity<?> getFuncionario(String email) {
        Funcionario funcionario = funcionarioService.getByEmail(email);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addFuncionario(AddFuncionarioRequest addFuncionarioRequest) {
        Funcionario funcionario = funcionarioService.addFuncionario(addFuncionarioRequest);
        return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
    }
}
