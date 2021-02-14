package br.com.rodkrtz.projuris.controle.manutencao.service.impl;

import br.com.rodkrtz.projuris.controle.manutencao.dao.OrdemServicoDao;
import br.com.rodkrtz.projuris.controle.manutencao.exception.ExceptionType;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Equipamento;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServico;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddOrdemServicoRequest;
import br.com.rodkrtz.projuris.controle.manutencao.service.EquipamentoService;
import br.com.rodkrtz.projuris.controle.manutencao.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Rodrigo Kreutzfeld
 */
@Component
public class OrdemServicoServiceImpl implements OrdemServicoService {

    @Autowired
    private OrdemServicoDao ordemServicoDao;

    @Autowired
    private EquipamentoService equipamentoService;

    @Override
    public OrdemServico getByChaveId(String chaveId) {
        OrdemServico ordemServico = ordemServicoDao.findByChaveId(chaveId);

        if (ordemServico == null) {
            ExceptionType.NOT_FOUND.throwException("Não foi encontrado uma ordem de serviço com essea chave " + chaveId);
        }

        return ordemServico;
    }

    @Override
    public List<OrdemServico> listPendentes() {
        List<OrdemServico> pendentes = ordemServicoDao.findPendentes();
        if (pendentes.isEmpty()) {
            ExceptionType.NOT_FOUND.throwException("Não foram encontradas ordens de serviço pendentes");
        }

        return pendentes;
    }

    @Override
    public OrdemServico addOrdemServico(AddOrdemServicoRequest addOrdemServicoRequest) {
        Equipamento equipamento = equipamentoService.findByNumeroSerie(addOrdemServicoRequest.getNumeroSerieEquipamento());

        if (equipamento == null) {
            ExceptionType.BAD_REQUEST.throwException("Equipamento não encontrado.");
        }

        OrdemServico ordemServico = new OrdemServico()
                .setDescricaoProblema(addOrdemServicoRequest.getDescricaoProblema())
                .setEquipamento(equipamento);

        ordemServicoDao.save(ordemServico);

        return ordemServico;
    }

    @Transactional
    @Override
    public void removeOrdemServico(String chaveId) {
        ordemServicoDao.deleteByChaveId(chaveId);
    }
}
