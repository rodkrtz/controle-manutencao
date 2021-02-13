package br.com.rodkrtz.projuris.controle.manutencao.dao.impl;

import br.com.rodkrtz.projuris.controle.manutencao.dao.OrdemServicoAcompanhamentoDao;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServicoAcompanhamento;
import br.com.rodkrtz.projuris.controle.manutencao.repository.OrdemServicoAcompanhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Rodrigo Kreutzfeld
 */
@Component
public class OrdemServicoAcompanhamentoDaoImpl implements OrdemServicoAcompanhamentoDao {

    @Autowired
    private OrdemServicoAcompanhamentoRepository ordemServicoAcompanhamentoRepository;

    @Override
    public List<OrdemServicoAcompanhamento> findByChaveIdOrdemServico(String idOrdemServico) {
        return ordemServicoAcompanhamentoRepository.findByChaveIdOrdemServico(idOrdemServico);
    }

    @Override
    public void save(OrdemServicoAcompanhamento ordemServicoAcompanhamento) {
        ordemServicoAcompanhamentoRepository.save(ordemServicoAcompanhamento);
    }
}
