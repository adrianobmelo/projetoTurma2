package br.gama.itau.projetogrupo2.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gama.itau.projetogrupo2.model.Cliente;
import br.gama.itau.projetogrupo2.repository.ClienteRepo;
import br.gama.itau.projetogrupo2.util.GenerateCliente;


@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    // esse obj receberá um Mock da sua dependência
    // esse é o obj da classe a ser testada
    @InjectMocks
    private ClienteService service;

    // É a dependência a ser injetada
    @Mock
    private ClienteRepo repo;

    @Test
    public void newCliente_returnNewCliente_whenClienteValido() {
        // preparação
        BDDMockito.when(repo.save(ArgumentMatchers.any(Cliente.class)))
                .thenReturn(GenerateCliente.clienteValido());

        Cliente novoCliente = GenerateCliente.novoClienteToSave();

        // ação
        Cliente clienteCriado = service.newCliente(novoCliente);

        // verificação
        assertThat(clienteCriado).isNotNull();
        assertThat(clienteCriado.getIdCliente()).isPositive();
        assertThat(clienteCriado.getNomeCliente()).isEqualTo(novoCliente.getNomeCliente());

        // verifica se o método save foi chamado 1 vez
        verify(repo, Mockito.times(1)).save(novoCliente);
    }

}
