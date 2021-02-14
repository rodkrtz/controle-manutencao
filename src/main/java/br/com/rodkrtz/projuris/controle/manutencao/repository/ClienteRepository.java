package br.com.rodkrtz.projuris.controle.manutencao.repository;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rodrigo Kreutzfeld
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByEmail(String email);

}
