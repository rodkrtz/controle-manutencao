package br.com.rodkrtz.projuris.controle.manutencao.dao;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteDao {

    Cliente findByEmail(String email);

    void save(Cliente cliente);

    List<Cliente> findAll();
}
