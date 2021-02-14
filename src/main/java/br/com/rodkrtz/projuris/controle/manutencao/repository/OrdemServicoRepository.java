package br.com.rodkrtz.projuris.controle.manutencao.repository;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Rodrigo Kreutzfeld
 */
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    OrdemServico findByChaveId(String chaveId);

    @Query("select o from OrdemServico o where o.funcionario.id is null")
    List<OrdemServico> findPendentes();

    void deleteByChaveId(String chaveId);
}
