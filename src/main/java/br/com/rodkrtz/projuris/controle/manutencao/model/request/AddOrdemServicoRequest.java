package br.com.rodkrtz.projuris.controle.manutencao.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Rodrigo Kreutzfeld
 */
@Data
@Accessors(chain = true)
public class AddOrdemServicoRequest {

    private String numeroSerieEquipamento;

    private String descricaoProblema;
}
