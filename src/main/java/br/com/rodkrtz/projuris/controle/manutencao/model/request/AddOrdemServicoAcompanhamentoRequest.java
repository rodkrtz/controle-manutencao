package br.com.rodkrtz.projuris.controle.manutencao.model.request;

import br.com.rodkrtz.projuris.controle.manutencao.model.enums.OSStatus;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Rodrigo Kreutzfeld
 */
@Data
@Accessors(chain = true)
public class AddOrdemServicoAcompanhamentoRequest {

    private String chaveIdOrdemServico;

    private OSStatus status;

    private String descricaoStatus;

    private LocalDateTime dataInicio;
}
