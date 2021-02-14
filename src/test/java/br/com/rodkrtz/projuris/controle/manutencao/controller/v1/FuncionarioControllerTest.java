package br.com.rodkrtz.projuris.controle.manutencao.controller.v1;

import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddFuncionarioRequest;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FuncionarioControllerTest {

    private static final String BASE_URL = "/api/v1/funcionarios";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("GET " + BASE_URL)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Get {

        @Test
        @DisplayName("Deve retornar status OK ao encontrar o funcionario")
        void teste1() throws Exception {
            //given
            String email = "func1@email.com.br";

            //when
            ResultActions performGet = mockMvc.perform(get(BASE_URL.concat("/").concat(email)));

            //then
            performGet
                    .andDo(print())
                    .andExpect(status().isOk());
        }

        @Test
        @DisplayName("Deve retornar status NOT FOUND ao nao encontrar o funcionario")
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
    }

    @Nested
    @DisplayName("PUT " + BASE_URL)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Put {

        @Test
        @DisplayName("Deve retornar status CREATED ao conseguir registrar um funcionario")
        void teste1() throws Exception {
            //given
            AddFuncionarioRequest addFuncionarioRequest = new AddFuncionarioRequest()
                    .setEmail("novoFuncionario@email.com.br")
                    .setNome("Novo Funcionário")
                    .setFuncao("TECNICO");

            //when
            ResultActions performPut = mockMvc.perform(put(BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(addFuncionarioRequest)));

            //then
            performPut.andDo(print())
                    .andExpect(
                            status().isCreated()
                    );

            //then
            mockMvc.perform(get(BASE_URL.concat("/").concat(addFuncionarioRequest.getEmail())))
                    .andExpect(
                            status().isOk()
                    );
        }

        @Test
        @DisplayName("Deve retornar status BAD REQUEST ao tentar registrar um funcionario com um email já registrado")
        void teste2() throws Exception {
            //given
            AddFuncionarioRequest addFuncionarioRequest = new AddFuncionarioRequest()
                    .setEmail("func1@email.com.br")
                    .setNome("Funcionario 3")
                    .setFuncao("TECNICO");

            //when
            ResultActions performPut = mockMvc.perform(put(BASE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(addFuncionarioRequest)));

            //then
            performPut.andDo(print())
                    .andExpect(
                            status().isBadRequest()
                    );

            //then
            mockMvc.perform(get(BASE_URL.concat("/").concat(addFuncionarioRequest.getEmail())))
                    .andExpect(
                            status().isOk()
                    );
        }
    }


}