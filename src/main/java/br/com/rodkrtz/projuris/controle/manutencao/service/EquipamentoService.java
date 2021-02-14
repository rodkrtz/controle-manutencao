package br.com.rodkrtz.projuris.controle.manutencao.service;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Equipamento;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddEquipamentoRequest;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Rodrigo Kreutzfeld
 */
@Service
public interface EquipamentoService {

    Equipamento findByNumeroSerie(String numeroSerie);

    Equipamento addEquipamento(AddEquipamentoRequest addEquipamentoRequest);

    List<Equipamento> getEquipamentos();
}
