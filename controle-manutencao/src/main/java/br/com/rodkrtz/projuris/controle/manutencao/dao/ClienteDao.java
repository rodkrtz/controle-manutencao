package br.com.rodkrtz.projuris.controle.manutencao.dao;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao {

    Cliente findByEmail(String email);

    void save(Cliente cliente);
}
