package br.com.rodkrtz.projuris.controle.manutencao.repository;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rodrigo Kreutzfeld
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findByEmail(String email);

}
