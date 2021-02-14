package br.com.rodkrtz.projuris.controle.manutencao.repository;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServicoAcompanhamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Rodrigo Kreutzfeld
 */
public interface OrdemServicoAcompanhamentoRepository extends JpaRepository<OrdemServicoAcompanhamento, Long> {

    @Query("select osa from OrdemServicoAcompanhamento osa where osa.ordemServico.chaveId = :chaveIdOrdemServico")
    List<OrdemServicoAcompanhamento> findByChaveIdOrdemServico(String chaveIdOrdemServico);
}
