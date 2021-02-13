package br.com.rodkrtz.projuris.controle.manutencao.service;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServico;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddOrdemServicoRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rodrigo Kreutzfeld
 */
@Service
public interface OrdemServicoService {

    OrdemServico getByChaveId(String chaveId);

    List<OrdemServico> listPendentes();

    OrdemServico addOrdemServico(AddOrdemServicoRequest addOrdemServicoRequest);

    void removeOrdemServico(String chaveId);
}
