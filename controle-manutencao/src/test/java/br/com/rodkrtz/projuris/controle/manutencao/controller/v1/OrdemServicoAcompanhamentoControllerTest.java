package br.com.rodkrtz.projuris.controle.manutencao.controller.v1;

import br.com.rodkrtz.projuris.controle.manutencao.model.enums.OSStatus;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddOrdemServicoAcompanhamentoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrdemServicoAcompanhamentoControllerTest {

    private static final String BASE_URL = "/api/v1/ordemServicos/acompanhamento";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("Put " + BASE_URL)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Put {

        @Test
        @DisplayName("Deve retornar status OK ao adicionar um acompanhamento")
        void teste1() throws Exception {
            //given
            AddOrdemServicoAcompanhamentoRequest acompanhamentoRequest = new AddOrdemServicoAcompanhamentoRequest()
                    .setChaveIdOrdemServico("12345678")
                    .setDataInicio(LocalDateTime.now())
                    .setStatus(OSStatus.INICIADO);

            //when
            ResultActions performPut = mockMvc.perform(put(BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(acompanhamentoRequest)));

            //then
            performPut
                    .andDo(print())
                    .andExpect(
                            status().isCreated()
                    );
        }
    }
}