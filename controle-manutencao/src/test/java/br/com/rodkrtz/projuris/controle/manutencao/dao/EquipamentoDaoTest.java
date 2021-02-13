package br.com.rodkrtz.projuris.controle.manutencao.dao;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Equipamento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EquipamentoDaoTest {

    @Autowired
    private EquipamentoDao equipamentoDao;

    @Test
    @Transactional
    void teste1() {
        Equipamento equipamento = equipamentoDao.findByNumeroSerie("xzy123");
        System.out.println(equipamento);
    }
}