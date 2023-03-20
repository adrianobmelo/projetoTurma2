package br.gama.itau.projetogrupo2.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import br.gama.itau.projetogrupo2.model.Conta;
import br.gama.itau.projetogrupo2.model.Movimentacao;
import br.gama.itau.projetogrupo2.repository.ContaRepo;
import br.gama.itau.projetogrupo2.repository.MovimentacaoRepo;
import br.gama.itau.projetogrupo2.util.GenerateConta;
import br.gama.itau.projetogrupo2.util.GenerateMovimentacao;

@ExtendWith(MockitoExtension.class)
public class MovimentacaoServiceTest {
    @InjectMocks
    private MovimentacaoService service;

    // É a dependência a ser injetada
    @Mock
    private MovimentacaoRepo repo;




    
    // @Test
    // public void newMovimentacao_returnNewMovimentacao_whenMovimentacaoValida() {

    //     // BDDMockito.when(repo.findById(ArgumentMatchers.any(Long.class)))
    //     //         .thenReturn(Optional.of(GenerateMovimentacao.movimentacaoValida()));

    //     BDDMockito.when(repo.save(ArgumentMatchers.any(Movimentacao.class)))
    //             .thenReturn(GenerateMovimentacao.movimentacaoValida());

    //     Movimentacao novaMovimentacao = GenerateMovimentacao.novaMovimentacaoToSave();

    //     // ação
    //     Movimentacao movimentacaoCriada = service.newMovimentacao(novaMovimentacao);

    //     // verificação
    //     assertThat(movimentacaoCriada).isNotNull();
    //     assertThat(movimentacaoCriada.getNumSeq()).isEqualTo(1L);
    //     assertThat(movimentacaoCriada.getTipoOperacao()).isEqualTo(novaMovimentacao.getTipoOperacao());

    //     verify(repo, Mockito.times(1)).save(novaMovimentacao);
    // }

}
