package br.com.rodkrtz.projuris.controle.manutencao.controller.v1.impl;

import br.com.rodkrtz.projuris.controle.manutencao.controller.v1.OrdemServicoController;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServico;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddOrdemServicoRequest;
import br.com.rodkrtz.projuris.controle.manutencao.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Rodrigo Kreutzfeld
 */
@Controller
public class OrdemServicoControllerImpl implements OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @Override
    public ResponseEntity<?> getOrdemServico(String chaveId) {
        OrdemServico ordemServico = ordemServicoService.getByChaveId(chaveId);
        return new ResponseEntity<>(ordemServico, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> listPendentes() {
        List<OrdemServico> ordemServicoList = ordemServicoService.listPendentes();
        return new ResponseEntity<>(ordemServicoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addOrdemServico(AddOrdemServicoRequest addOrdemServicoRequest) {
        OrdemServico ordemServico = ordemServicoService.addOrdemServico(addOrdemServicoRequest);
        return new ResponseEntity<>(ordemServico, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> removeOrdemServico(String chaveId) {
        ordemServicoService.removeOrdemServico(chaveId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
