package br.com.rodkrtz.projuris.controle.manutencao.controller.v1.impl;

import br.com.rodkrtz.projuris.controle.manutencao.controller.v1.EquipamentoController;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Equipamento;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddEquipamentoRequest;
import br.com.rodkrtz.projuris.controle.manutencao.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rodrigo Kreutzfeld
 */
@Component
public class EquipamentoControllerImpl implements EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @Override
    public ResponseEntity<?> getEquipamento(String numeroSerie) {
        Equipamento equipamento = equipamentoService.findByNumeroSerie(numeroSerie);
        return new ResponseEntity<>(equipamento, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addEquipamento(AddEquipamentoRequest addEquipamentoRequest) {
        Equipamento equipamento = equipamentoService.addEquipamento(addEquipamentoRequest);
        return new ResponseEntity<>(equipamento, HttpStatus.CREATED);
    }
}
