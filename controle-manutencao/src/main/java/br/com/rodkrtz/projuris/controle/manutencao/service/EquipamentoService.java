package br.com.rodkrtz.projuris.controle.manutencao.service;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Equipamento;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.CadastroEquipamentoRequest;
import org.springframework.stereotype.Service;


/**
 * @author Rodrigo Kreutzfeld
 */
@Service
public interface EquipamentoService {

    Equipamento findByNumeroSerie(String numeroSerie);

    Equipamento cadastrarEquipamento(CadastroEquipamentoRequest cadastroEquipamentoRequest);

}
