package br.com.rodkrtz.projuris.controle.manutencao.dao.impl;

import br.com.rodkrtz.projuris.controle.manutencao.dao.EquipamentoDao;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Equipamento;
import br.com.rodkrtz.projuris.controle.manutencao.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EquipamentoDaoImpl implements EquipamentoDao {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Override

    public Equipamento findByNumeroSerie(String numeroSerie) {
        return equipamentoRepository.findByNumeroSerie(numeroSerie);
    }

    @Override
    public Equipamento save(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    @Override
    public List<Equipamento> findAll() {
        return equipamentoRepository.findAll();
    }
}
