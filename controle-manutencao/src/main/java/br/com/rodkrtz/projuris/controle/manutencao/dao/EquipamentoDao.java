package br.com.rodkrtz.projuris.controle.manutencao.dao;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Equipamento;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoDao {

    Equipamento findByNumeroSerie(String numeroSerie);

    Equipamento save(Equipamento equipamento);
}
