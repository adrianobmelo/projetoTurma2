package br.gama.itau.projetogrupo2.controller;
//import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;


import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

//import com.fasterxml.jackson.databind.ObjectMapper;

import br.gama.itau.projetogrupo2.dto.ClienteDTO;
import br.gama.itau.projetogrupo2.service.ClienteService;
import br.gama.itau.projetogrupo2.util.GenerateCliente;

@WebMvcTest(ClienteController.class)

public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;
    //@Autowired
    //private ObjectMapper objectMapper;
  
    

    @MockBean
    private ClienteService service;

    @Test
    public void getAll_returnListClientes_whenSuccess() throws Exception {
        // preparação
        List<ClienteDTO> lista = new ArrayList<>();        
        lista.add(new ClienteDTO(GenerateCliente.clienteValido()));

        BDDMockito.when(service.getAll()).thenReturn(lista);

        // ação
        ResultActions resposta = mockMvc.perform(get("/clientes").contentType(MediaType.APPLICATION_JSON));

        // verificações
        resposta.andExpect(status().isOk()) // verifica se o status é OK (200)
                // verifica se o tamanho da lista na resposta é 2 (lista.size)
                .andExpect(jsonPath("$.size()", CoreMatchers.is(lista.size())))
                // verifique se a placa do primeiro veículo é a placa esperada
                .andExpect(jsonPath("$[0].cpfCliente", CoreMatchers.is(GenerateCliente.clienteValido().getCpfCliente())));
    }

    
}
