package br.com.rodkrtz.projuris.controle.manutencao.repository;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Equipamento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EquipamentoRepositoryTest {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

//    @Test
//    void teste1() {
//        Equipamento equipamento = equipamentoRepository.findByNumeroSerie("xzy123");
//        System.out.println(equipamento.getCliente());
//    }

}