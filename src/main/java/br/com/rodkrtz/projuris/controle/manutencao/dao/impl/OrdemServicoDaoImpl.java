package br.com.rodkrtz.projuris.controle.manutencao.dao.impl;

import br.com.rodkrtz.projuris.controle.manutencao.dao.OrdemServicoDao;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServico;
import br.com.rodkrtz.projuris.controle.manutencao.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Rodrigo Kreutzfeld
 */
@Component
public class OrdemServicoDaoImpl implements OrdemServicoDao {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Override
    public OrdemServico findByChaveId(String chaveId) {
        return ordemServicoRepository.findByChaveId(chaveId);
    }

    @Override
    public List<OrdemServico> findPendentes() {
        return ordemServicoRepository.findPendentes();
    }

    @Override
    public void save(OrdemServico ordemServico) {
        ordemServicoRepository.save(ordemServico);
    }

    @Override
    public void deleteByChaveId(String chaveId) {
        ordemServicoRepository.deleteByChaveId(chaveId);
    }
}
