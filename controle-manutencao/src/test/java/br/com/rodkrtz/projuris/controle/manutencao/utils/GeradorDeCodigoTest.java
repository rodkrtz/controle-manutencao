package br.com.rodkrtz.projuris.controle.manutencao.utils;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GeradorDeCodigoTest {

//    public static String gerar() {
//
//    }

    @Test
    void teste() {
        RandomString randomString = new RandomString(5);
        System.out.println(randomString.nextString());
        System.out.println(randomString.nextString());
    }

}