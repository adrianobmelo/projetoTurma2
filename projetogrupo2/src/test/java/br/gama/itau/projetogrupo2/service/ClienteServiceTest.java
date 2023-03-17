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

import br.gama.itau.projetogrupo2.dto.ClienteDTO;
import br.gama.itau.projetogrupo2.dto.ContaDTO;
import br.gama.itau.projetogrupo2.model.Cliente;
import br.gama.itau.projetogrupo2.model.Conta;
import br.gama.itau.projetogrupo2.repository.ClienteRepo;
import br.gama.itau.projetogrupo2.util.GenerateCliente;
import br.gama.itau.projetogrupo2.util.GenerateConta;


@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
        // testes
    // esse obj receberá um Mock da sua dependência
    // esse é o obj da classe a ser testada
    @InjectMocks
    private ClienteService service;

    // É a dependência a ser injetada
    @Mock
    private ClienteRepo repo;

    @Test
    public void getAll_returnListCliente_whenClienteExist() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(GenerateCliente.clienteId1());

        BDDMockito.when(repo.findAll()).thenReturn(clientes);

        List<ClienteDTO> listaRecuperada = service.getAll();

        assertThat(listaRecuperada).isNotNull();
        assertThat(listaRecuperada).isNotEmpty();
        // testa o Id do primeiro elemento (paciente) da lista
        assertThat(listaRecuperada.get(0).getIdCliente()).isEqualTo(GenerateCliente.clienteId1().getIdCliente());
    }

    @Test
    public void getById_returnCliente_whenIdExist() {
        BDDMockito.when(repo.findById(ArgumentMatchers.any(Long.class)))
                .thenReturn(Optional.of(GenerateCliente.clienteValido()));

        Cliente clienteEncontrado = service.getById(1L);

        assertThat(clienteEncontrado)
                .isNotNull();
        assertThat(clienteEncontrado.getIdCliente())
                .isGreaterThan(0);
        assertThat(clienteEncontrado.getCpfCliente())
                .isEqualTo(GenerateCliente.clienteValido().getCpfCliente())
                .isNotEmpty();
    }

//     @Test
//     public void getAll_returnListContas_whenContaExist() {
//         List<Conta> contas = new ArrayList<>();
//         contas.add(GenerateConta.contaId1());

//         BDDMockito.when(repo.findAll()).thenReturn(contas);

//         List<ContaDTO> listaRecuperada = service.getAll();

//         assertThat(listaRecuperada).isNotNull();
//         assertThat(listaRecuperada).isNotEmpty();
//         assertThat(listaRecuperada.get(0).getNumeroConta()).isEqualTo(GenerateConta.contaId1().getNumeroConta());
//     }

//     @Test
//     public void getContasById_returnContaByIdCliente_whenIdExist() {
//         BDDMockito.when(repo.findById(ArgumentMatchers.any(Long.class)))
//                 .thenReturn(Optional.of(GenerateConta.contaValida()));

//         List<ContaDTO> contaEncontrada = service.getContasById(1L);

//         assertThat(contaEncontrada)
//                 .isNotNull();
//          assertThat(contaEncontrada.getNumeroConta())
//                  .isGreaterThan(0);
//          assertThat(contaEncontrada.getTipoConta())
//                  .isEqualTo(GenerateConta.contaValida().getTipoConta())
//                  .isNotEmpty();
//     }



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
