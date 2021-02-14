package br.com.rodkrtz.projuris.controle.manutencao.controller.v1;

import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddEquipamentoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
class EquipamentoControllerTest {

    private static final String BASE_URL = "/api/v1/equipamentos";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Deve adicionar um equipamento")
    void teste1() throws Exception {

        //given
        AddEquipamentoRequest addEquipamentoRequest = new AddEquipamentoRequest()
                .setMarcaEquipamento("TRAMONTINA")
                .setNomeEquipamento("Faca de Cozinha Master")
                .setTipoEquipamento("Faca de Cozinha")
                .setNumeroSerieEquipamento("AAAX1234")
                .setEmailCliente("email1@email1.com.br");

        //when
        ResultActions putResult = mockMvc.perform(put(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addEquipamentoRequest)));

        //then
        putResult.andDo(print())
                .andExpect(
                        status().isCreated()
                );
        //then
        mockMvc.perform(get(BASE_URL.concat("/").concat(addEquipamentoRequest.getNumeroSerieEquipamento())))
                .andExpect(status().isOk());
    }
}