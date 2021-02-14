package br.com.rodkrtz.projuris.controle.manutencao.dao;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServico;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rodrigo Kreutzfeld
 */
@Repository
public interface OrdemServicoDao {

    OrdemServico findByChaveId(String chaveId);

    List<OrdemServico> findPendentes();

    void save(OrdemServico ordemServico);

    void deleteByChaveId(String chaveId);
}
