package br.com.rodkrtz.projuris.controle.manutencao.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Rodrigo Kreutzfeld
 */
@Data
@Accessors(chain = true)
public class CadastroEquipamentoRequest {

    private String emailCliente;

    private String nomeEquipamento;

    private String tipoEquipamento;

    private String marcaEquipamento;

    private String numeroSerieEquipamento;
}
