package br.gama.itau.projetogrupo2.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
import br.gama.itau.projetogrupo2.model.Conta;
import br.gama.itau.projetogrupo2.repository.ClienteRepo;
import br.gama.itau.projetogrupo2.repository.ContaRepo;
import br.gama.itau.projetogrupo2.util.GenerateCliente;
import br.gama.itau.projetogrupo2.util.GenerateConta;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ContaControllerITTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ContaRepo contaRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @BeforeEach
    public void setup() {
        contaRepo.deleteAll();
    }

    @Test
    public void newConta_returnContaInserida_whenDadosContaValida() throws Exception {
        // preparação
        Conta novaConta = GenerateConta.novaContaToSave();

        // ação
        ResultActions resposta = mockMvc.perform(post("/contas")
                        .content(objectMapper.writeValueAsString(novaConta))
                        .contentType(MediaType.APPLICATION_JSON));

        // verificar
        resposta.andExpect(status().isCreated())
                .andExpect(jsonPath("$.tipoConta", CoreMatchers.is(novaConta.getTipoConta())));
    }

    @Test
    public void getByNumeroConta_returnConta_whenIdExist() throws Exception {
        // preparação
        Conta novaConta = GenerateConta.novaContaToSave();
        Conta contaCriada = contaRepo.save(novaConta);

        // ação
        ResultActions resposta = mockMvc.perform(get("/contas/{id}", contaCriada.getNumeroConta())
                .contentType(MediaType.APPLICATION_JSON));

        // verificar
        resposta.andExpect(status().isOk())
                .andExpect(jsonPath("$.tipoConta", CoreMatchers.is(contaCriada.getTipoConta())));
    }

    @Test
    public void updateConta_returnUpdatedConta_whenNumeroContaExist() throws Exception {
        // preparação
        Cliente novoCliente = GenerateCliente.novoClienteToSave();
        Cliente clienteCriado = clienteRepo.save(novoCliente);

        Conta novaConta = GenerateConta.novaContaToSave(clienteCriado.getIdCliente());
        Conta contaCriada = contaRepo.save(novaConta);

        // ação
        ResultActions resposta = mockMvc.perform(get("/contas/{id}", contaCriada.getNumeroConta())
                .contentType(MediaType.APPLICATION_JSON));

        // verificar
        resposta.andExpect(status().isOk())
                .andExpect(jsonPath("$.tipoConta", CoreMatchers.is(contaCriada.getTipoConta())));
    }

        //inserir cliente, inserir conta novacontatosave com (idcliente)

 }