package br.com.rodkrtz.projuris.controle.manutencao.controller.v1;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.OrdemServico;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddOrdemServicoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        @DirtiesContext
        @DisplayName("Deve retornar status NOT FOUND ao nao encontrar ordens de servicos pendentes")
        void teste3() throws Exception {
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

    @Nested
    @DisplayName("PUT " + BASE_URL)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Put {

        @Test
        @DirtiesContext
        @DisplayName("Deve registrar uma nova ordem de servico")
        void teste1() throws Exception {
            //given
            AddOrdemServicoRequest addOrdemServicoRequest = new AddOrdemServicoRequest()
                    .setDescricaoProblema("Teclado nao funciona")
                    .setNumeroSerieEquipamento("abc321");

            //when
            ResultActions putResult = mockMvc.perform(put(BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(addOrdemServicoRequest)));

            //then
            String content = putResult
                    .andDo(print())
                    .andExpect(
                            status().isCreated()
                    )
                    .andReturn()
                    .getResponse()
                    .getContentAsString();

            System.out.println(content);

            OrdemServico ordemServicoCriada = objectMapper.readValue(content, OrdemServico.class);

            mockMvc.perform(get(BASE_URL.concat("/").concat(ordemServicoCriada.getChaveId())))
                    .andExpect(status().isOk());
        }
    }
}