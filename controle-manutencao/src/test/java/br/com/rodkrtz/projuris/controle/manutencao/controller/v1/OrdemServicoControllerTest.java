package br.com.rodkrtz.projuris.controle.manutencao.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrdemServicoControllerTest {

    private static final String BASE_URL = "/api/v1/ordemServicos";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("GET " + BASE_URL)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Get {

        @Test
        @DisplayName("Deve retornar status OK ao encontrar a ordem de servico")
        void teste1() throws Exception {
            //given
            String chaveId = "12345678";

            //when
            ResultActions performGet = mockMvc.perform(get(BASE_URL.concat("/").concat(chaveId)));

            //then
            performGet
                    .andDo(print())
                    .andExpect(status().isOk());

        }

        @Test
        @DisplayName("Deve retornar status OK ao encontrar ordens de servicos pendentes")
        void teste2() throws Exception {
            //when
            ResultActions performGet = mockMvc.perform(get(BASE_URL.concat("/pendentes")));

            //then
            performGet
                    .andDo(print())
                    .andExpect(status().isOk());
        }

        @Test
        @DisplayName("Deve retornar status NOT FOUND ao nao encontrar ordens de servicos pendentes")
        void teste4() throws Exception {
            //given
            String chaveIdDeletar = "12345678";

            //when/then
            mockMvc.perform(delete(BASE_URL.concat("/").concat(chaveIdDeletar)))
                    .andDo(print())
                    .andExpect(status().isNoContent());

            //when/then
            mockMvc.perform(get(BASE_URL.concat("/pendentes")))
                    .andDo(print())
                    .andExpect(status().isNotFound());

        }
    }
}