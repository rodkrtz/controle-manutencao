package br.com.rodkrtz.projuris.controle.manutencao.dao;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteDaoTest {

    @Autowired
    private ClienteDao clienteDao;

    @Test
    void teste1() {
        Cliente cliente = clienteDao.findByEmail("email1@email1.com.br");
        System.out.println(cliente);
    }
}