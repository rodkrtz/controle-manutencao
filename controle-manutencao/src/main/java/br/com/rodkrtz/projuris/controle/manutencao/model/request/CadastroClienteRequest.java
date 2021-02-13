package br.com.rodkrtz.projuris.controle.manutencao.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Rodrigo Kreutzfeld
 */
@Data
@Accessors(chain = true)
public class CadastroClienteRequest {

    private String nome;

    private String endereco;

    private String telefone;

    private String email;
}
