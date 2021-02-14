package br.com.rodkrtz.projuris.controle.manutencao.utils;

import net.bytebuddy.utility.RandomString;

/**
 * @author Rodrigo Kreutzfeld
 */
public class GeradorDeChave {

    public static String gerar() {
        return new RandomString(8)
                .nextString()
                .toUpperCase();
    }

}
