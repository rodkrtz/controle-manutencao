package br.com.rodkrtz.projuris.controle.manutencao.service;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServicoAcompanhamento;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddOrdemServicoAcompanhamentoRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rodrigo Kreutzfeld
 */
@Service
public interface OrdemServicoAcompanhamentoService {

    List<OrdemServicoAcompanhamento> listByChaveIdOrdemServico(String chaveIdOrdemServico);

    OrdemServicoAcompanhamento addAcompanhamento(AddOrdemServicoAcompanhamentoRequest addOrdemServicoAcompanhamentoRequest);
}
