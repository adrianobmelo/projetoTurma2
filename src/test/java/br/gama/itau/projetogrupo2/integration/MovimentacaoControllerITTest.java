package br.gama.itau.projetogrupo2.integration;

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
import br.gama.itau.projetogrupo2.model.Movimentacao;
import br.gama.itau.projetogrupo2.repository.ClienteRepo;
import br.gama.itau.projetogrupo2.repository.MovimentacaoRepo;
import br.gama.itau.projetogrupo2.util.GenerateCliente;
import br.gama.itau.projetogrupo2.util.GenerateConta;
import br.gama.itau.projetogrupo2.util.GenerateMovimentacao;

// carrega o contexto do Spring para teste usando uma porta aleatória
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MovimentacaoControllerITTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MovimentacaoRepo movimentacaoRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @BeforeEach
    public void setup() {
        movimentacaoRepo.deleteAll();
    }


    // @Test
    // public void newMovimentacao_returnMovimentacaoeInserida_whenDadosMovimentacaoValida() throws Exception {
    //     //Cliente novoCliente = GenerateCliente.novoClienteToSave();

    //     //Cliente clienteCriado = clienteRepo.save(novoCliente);
    //     Conta novaConta = GenerateConta.novaContaToSave();
    //     Movimentacao novaMovimentacao = GenerateMovimentacao.novaMovimentacaoToSave();
    //     //Movimentacao movimentacaoCriada = movimentacaoRepo.save(novaMovimentacao);

    //     ResultActions resposta = mockMvc.perform(post("/movimentacoes")
    //                     .content(objectMapper.writeValueAsString(novaConta))
    //                     .contentType(MediaType.APPLICATION_JSON));

    //     resposta.andExpect(status().isCreated())
    //             .andExpect(jsonPath("$.numSeq", CoreMatchers.is(novaMovimentacao.getNumSeq())));
    // }
}
