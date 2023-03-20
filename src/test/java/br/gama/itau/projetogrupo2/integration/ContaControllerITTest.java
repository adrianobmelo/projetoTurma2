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
import br.gama.itau.projetogrupo2.model.Conta;
import br.gama.itau.projetogrupo2.repository.ContaRepo;
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

    @BeforeEach
    public void setup() {
        contaRepo.deleteAll();
    }

    @Test
    public void newConta_returnContaInserida_whenDadosContaValida() throws Exception {
       Conta novaConta = GenerateConta.novaContaToSave();

        ResultActions resposta = mockMvc.perform(post("/contas")
                        .content(objectMapper.writeValueAsString(novaConta))
                        .contentType(MediaType.APPLICATION_JSON));

        resposta.andExpect(status().isCreated())
                .andExpect(jsonPath("$.tipoConta", CoreMatchers.is(novaConta.getTipoConta())));
    }

    @Test
    public void getByIdConta_returnConta_whenIdExist() throws Exception {
        Conta novaConta = GenerateConta.novaContaToSave();

        Conta contaCriada = contaRepo.save(novaConta);

        // ação
        ResultActions resposta = mockMvc.perform(get("/contas/{id}", contaCriada.getNumeroConta())
                .contentType(MediaType.APPLICATION_JSON));

        // verificar os resultados
        resposta.andExpect(status().isOk())
                .andExpect(jsonPath("$.tipoConta", CoreMatchers.is(contaCriada.getTipoConta())));
    }

    // @Test
    // public void getAll_returnListContas_whenSuccess() throws Exception {
    //     // preparação
    //     List<Conta> lista = new ArrayList<>();
    //     lista.add(GenerateConta.novaContaToSave());
    

    //     contaRepo.saveAll(lista);

    //     // ação
    //     ResultActions resposta = mockMvc.perform(get("/contas").contentType(MediaType.APPLICATION_JSON));

    //     // verificações
    //     resposta.andExpect(status().isOk()) 
    //             .andExpect(jsonPath("$.size()", CoreMatchers.is(lista.size())))
    //             .andExpect(jsonPath("$[0].numeroConta", CoreMatchers.is(GenerateConta.contaValida().getNumeroConta())));
    // }
 }