package br.com.rodkrtz.projuris.controle.manutencao.service.impl;

import br.com.rodkrtz.projuris.controle.manutencao.dao.OrdemServicoAcompanhamentoDao;
import br.com.rodkrtz.projuris.controle.manutencao.dao.OrdemServicoDao;
import br.com.rodkrtz.projuris.controle.manutencao.exception.ExceptionType;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServico;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServicoAcompanhamento;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddOrdemServicoAcompanhamentoRequest;
import br.com.rodkrtz.projuris.controle.manutencao.service.OrdemServicoAcompanhamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdemServiceAcompanhamentoServiceImpl implements OrdemServicoAcompanhamentoService {

    @Autowired
    private OrdemServicoAcompanhamentoDao ordemServicoAcompanhamentoDao;

    @Autowired
    private OrdemServicoDao ordemServicoDao;

    @Override
    public List<OrdemServicoAcompanhamento> listByChaveIdOrdemServico(String chaveIdOrdemServico) {
        List<OrdemServicoAcompanhamento> acompanhamentos = ordemServicoAcompanhamentoDao.findByChaveIdOrdemServico(chaveIdOrdemServico);
        if (acompanhamentos.isEmpty()) {
            ExceptionType.NOT_FOUND.throwException("Não foram encontrados acompanhamentos para essa ordem de servico ".concat(chaveIdOrdemServico));
        }
        return acompanhamentos;
    }

    @Override
    public OrdemServicoAcompanhamento addAcompanhamento(AddOrdemServicoAcompanhamentoRequest addOrdemServicoAcompanhamentoRequest) {
        OrdemServico ordemServico = ordemServicoDao.findByChaveId(addOrdemServicoAcompanhamentoRequest.getChaveIdOrdemServico());
        if (ordemServico == null) {
            ExceptionType.NOT_FOUND.throwException("Não foi encontrado uma ordem de servico para essa operacao");
        }

        List<OrdemServicoAcompanhamento> acompanhamentos =
                ordemServicoAcompanhamentoDao.findByChaveIdOrdemServico(addOrdemServicoAcompanhamentoRequest.getChaveIdOrdemServico());

        acompanhamentos.stream()
                .filter(it -> it.getStatus().equals(addOrdemServicoAcompanhamentoRequest.getStatus()))
                .filter(it -> it.getDataFim() == null)
                .findFirst()
                .ifPresent(
                        it -> ExceptionType.BAD_REQUEST.throwException("Já existe um acompanhamento para esta ordem de servico. "
                                .concat("Acomp.")
                                .concat(it.getChaveId()))
                );

        OrdemServicoAcompanhamento ordemServicoAcompanhamento = new OrdemServicoAcompanhamento()
                .setOrdemServico(ordemServico)
                .setDataInicio(addOrdemServicoAcompanhamentoRequest.getDataInicio())
                .setStatus(addOrdemServicoAcompanhamentoRequest.getStatus())
                .setDescricaoStatus(addOrdemServicoAcompanhamentoRequest.getDescricaoStatus());

        ordemServicoAcompanhamentoDao.save(ordemServicoAcompanhamento);

        return ordemServicoAcompanhamento;
    }
}
