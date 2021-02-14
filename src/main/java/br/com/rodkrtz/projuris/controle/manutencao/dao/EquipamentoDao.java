package br.com.rodkrtz.projuris.controle.manutencao.dao;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Equipamento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipamentoDao {

    Equipamento findByNumeroSerie(String numeroSerie);

    Equipamento save(Equipamento equipamento);

    List<Equipamento> findAll();
}
