package br.gama.itau.projetogrupo2.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import br.gama.itau.projetogrupo2.model.Conta;
import br.gama.itau.projetogrupo2.repository.ContaRepo;
import br.gama.itau.projetogrupo2.util.GenerateConta;


@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {
    // esse obj receberá um Mock da sua dependência
    // esse é o obj da classe a ser testada
    @InjectMocks
    private ContaService service;

    // É a dependência a ser injetada
    @Mock
    private ContaRepo repo;

    @Test
    public void getAll_returnListConta_whenContaExist() {
        List<Conta> contas = new ArrayList<>();
        contas.add(GenerateConta.contaId1());

        BDDMockito.when(repo.findAll()).thenReturn(contas);

        List<Conta> listaRecuperada = service.getAll();

        assertThat(listaRecuperada).isNotNull();
        assertThat(listaRecuperada).isNotEmpty();
        assertThat(listaRecuperada.get(0).getNumeroConta()).isEqualTo(GenerateConta.contaId1().getNumeroConta());
    }

    @Test
    public void getNumeroConta_returnConta_whenIdExist() {
        BDDMockito.when(repo.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(GenerateConta.contaValida()));

        Conta contaEncontrada = service.getNumeroConta(1L);

        assertThat(contaEncontrada)
                .isNotNull();
        assertThat(contaEncontrada.getNumeroConta())
                .isGreaterThan(0);
        assertThat(contaEncontrada.getNumeroConta())
                .isEqualTo(GenerateConta.contaValida().getNumeroConta());
    }

    @Test
    public void newConta_returnNewConta_whenContaValida() {
        // preparação
        BDDMockito.when(repo.save(ArgumentMatchers.any(Conta.class)))
                .thenReturn(GenerateConta.contaValida());

        Conta novaConta = GenerateConta.novaContaToSave();

        // ação
        Conta contaCriada = service.newConta(novaConta);

        // verificação
        assertThat(contaCriada).isNotNull();
        assertThat(contaCriada.getNumeroConta()).isPositive();
        assertThat(contaCriada.getTipoConta()).isEqualTo(novaConta.getTipoConta());

        // verifica se o método save foi chamado 1 vez
        verify(repo, Mockito.times(1)).save(novaConta);
    }

    @Test
    public void updateConta_returnUpdatedConta_whenContaValida() {

        BDDMockito.when(repo.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(GenerateConta.contaValida()));

        BDDMockito.when(repo.save(ArgumentMatchers.any(Conta.class)))
                .thenReturn(GenerateConta.contaValida());

        Conta contaParaAtualizar = GenerateConta.contaValida();

        // ação
        Conta contaAtualizada = service.updateConta(1L, contaParaAtualizar);

        // verificação
        assertThat(contaAtualizada).isNotNull();
        assertThat(contaAtualizada.getNumeroConta()).isEqualTo(1L);
        assertThat(contaAtualizada.getTipoConta()).isEqualTo(contaParaAtualizar.getTipoConta());

        verify(repo, Mockito.times(1)).save(contaParaAtualizar);
    }

   
}