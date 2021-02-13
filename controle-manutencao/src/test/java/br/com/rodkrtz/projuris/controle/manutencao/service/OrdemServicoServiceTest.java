package br.com.rodkrtz.projuris.controle.manutencao.service;

import br.com.rodkrtz.projuris.controle.manutencao.repository.OrdemServicoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrdemServicoServiceTest {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @Test
    @DisplayName("Deve deletar um registro de ordem_servico")
    void test1() {
        ordemServicoService.removeOrdemServico("12345678");
    }
}