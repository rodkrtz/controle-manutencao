package br.com.rodkrtz.projuris.controle.manutencao.controller.v1;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Cliente;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddClienteRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerTest {

    private static final String BASE_URL = "/api/v1/clientes";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("GET " + BASE_URL)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Get {

        @Test
        @DisplayName("Deve retornar um cliente")
        void teste1() throws Exception {
            //given
            String email = "email1@email1.com.br";

            //when
            ResultActions performGet = mockMvc.perform(get(BASE_URL.concat("/").concat(email)));

            //then
            performGet
                    .andDo(print())
                    .andExpect(status().isOk());
        }

        @Test
        @DisplayName("Deve retornar NOT FOUND")
        void teste2() throws Exception {
            //given
            String emailQueNaoExiste = "email_que_nao_existe";

            //when
            ResultActions performGet = mockMvc.perform(get(BASE_URL.concat("/").concat(emailQueNaoExiste)));

            //then
            performGet
                    .andDo(print())
                    .andExpect(status().isNotFound());
        }

        @Test
        @DisplayName("Deve retornar uma lista de clientes")
        void teste3() throws Exception {

            //when
            ResultActions performGet = mockMvc.perform(get(BASE_URL));

            //then
            String respContent = performGet
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();

            Cliente[] clientes = objectMapper.readValue(respContent, Cliente[].class);
            Assertions.assertThat(clientes.length).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("PUT " + BASE_URL)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Put {

        @Test
        @DisplayName("Deve adicionar um cliente")
        void teste1() throws Exception {
            //given
            AddClienteRequest addClienteRequest = new AddClienteRequest()
                    .setEmail("email4@email.com.br")
                    .setEndereco("Rua Quatro, 4")
                    .setNome("Fulano da Silva")
                    .setTelefone("4799999999");

            //when
            ResultActions performPut = mockMvc.perform(put(BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(addClienteRequest)));

            //then
            performPut
                    .andDo(print())
                    .andExpect(
                            status().isCreated()
                    );
        }
    }


}