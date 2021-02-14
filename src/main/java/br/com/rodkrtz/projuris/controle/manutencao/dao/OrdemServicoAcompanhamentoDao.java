package br.com.rodkrtz.projuris.controle.manutencao.dao;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServicoAcompanhamento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemServicoAcompanhamentoDao {

    List<OrdemServicoAcompanhamento> findByChaveIdOrdemServico(String chaveIdOrdemServico);

    void save(OrdemServicoAcompanhamento ordemServicoAcompanhamento);
}
