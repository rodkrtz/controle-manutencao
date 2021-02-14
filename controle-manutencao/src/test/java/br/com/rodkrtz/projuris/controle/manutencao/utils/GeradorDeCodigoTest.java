package br.com.rodkrtz.projuris.controle.manutencao.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GeradorDeCodigoTest {

    @Test
    @DisplayName("Deve gerar uma String aleatoria de 8 caracteres")
    void teste1() {
        String chaveId = GeradorDeChave.gerar();
        Assertions.assertThat(chaveId.length()).isEqualTo(8);
    }

}