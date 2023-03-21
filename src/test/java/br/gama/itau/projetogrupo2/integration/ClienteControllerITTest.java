package br.gama.itau.projetogrupo2.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.gama.itau.projetogrupo2.model.Cliente;
import br.gama.itau.projetogrupo2.repository.ClienteRepo;
import br.gama.itau.projetogrupo2.util.GenerateCliente;

// carrega o contexto do Spring para teste usando uma porta aleatória
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClienteControllerITTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClienteRepo clienteRepo;

    @BeforeEach
    public void setup() {
        clienteRepo.deleteAll();
    }

    @Test
    public void newCliente_returnClienteInserido_whenDadosClienteValido() throws Exception {
        // preparação
        Cliente novoCliente = GenerateCliente.novoClienteToSave();

        // ação
        ResultActions resposta = mockMvc.perform(post("/clientes")
                        .content(objectMapper.writeValueAsString(novoCliente))
                        .contentType(MediaType.APPLICATION_JSON));
        // verificar
        resposta.andExpect(status().isCreated())
                .andExpect(jsonPath("$.cpfCliente", CoreMatchers.is(novoCliente.getCpfCliente())));
    }

    @Test
    public void getByIdCliente_returnCliente_whenIdExist() throws Exception {
        // preparação
        Cliente novoCliente = GenerateCliente.novoClienteToSave();
        Cliente clienteCriado = clienteRepo.save(novoCliente);

        // ação
        ResultActions resposta = mockMvc.perform(get("/clientes/{id}", clienteCriado.getIdCliente())
                .contentType(MediaType.APPLICATION_JSON));

        // verificar 
        resposta.andExpect(status().isOk())
                .andExpect(jsonPath("$.cpfCliente", CoreMatchers.is(clienteCriado.getCpfCliente())));
    }

    @Test
    public void getAll_returnListClientes_whenSuccess() throws Exception {
        // preparação
        List<Cliente> lista = new ArrayList<>();
        lista.add(GenerateCliente.novoClienteToSave());
        clienteRepo.saveAll(lista);

        // ação
        ResultActions resposta = mockMvc.perform(get("/clientes").contentType(MediaType.APPLICATION_JSON));

        // verificar
        resposta.andExpect(status().isOk()) 
                .andExpect(jsonPath("$.size()", CoreMatchers.is(lista.size())))
                .andExpect(jsonPath("$[0].cpfCliente", CoreMatchers.is(GenerateCliente.clienteValido().getCpfCliente())));
    }
}

