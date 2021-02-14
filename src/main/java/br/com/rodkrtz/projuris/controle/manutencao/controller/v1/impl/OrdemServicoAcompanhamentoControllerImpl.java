package br.com.rodkrtz.projuris.controle.manutencao.controller.v1.impl;

import br.com.rodkrtz.projuris.controle.manutencao.controller.v1.OrdemServicoAcompanhamentoController;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServicoAcompanhamento;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddOrdemServicoAcompanhamentoRequest;
import br.com.rodkrtz.projuris.controle.manutencao.service.OrdemServicoAcompanhamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rodrigo Kreutzfeld
 */
@Component
public class OrdemServicoAcompanhamentoControllerImpl implements OrdemServicoAcompanhamentoController {

    @Autowired
    private OrdemServicoAcompanhamentoService ordemServicoAcompanhamentoService;

    @Override
    public ResponseEntity<?> addAcompanhamento(AddOrdemServicoAcompanhamentoRequest addOrdemServicoAcompanhamentoRequest) {
        OrdemServicoAcompanhamento ordemServicoAcompanhamento = ordemServicoAcompanhamentoService.addAcompanhamento(addOrdemServicoAcompanhamentoRequest);
        return new ResponseEntity<>(ordemServicoAcompanhamento, HttpStatus.CREATED);
    }
}
