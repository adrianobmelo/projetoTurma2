package br.gama.itau.projetogrupo2.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import br.gama.itau.projetogrupo2.model.Cliente;
import br.gama.itau.projetogrupo2.util.GenerateCliente;

// @DataJpaTest
public class ClienteRepoTest {
    
    @Autowired
    private ClienteRepo repo;

    @BeforeEach
    public void setup() {
        repo.deleteAll();
    }


    // @Test
    public void save_returnSavedCliente_whenValidCliente() {
        Cliente novoCliente = GenerateCliente.novoClienteToSave();

        Cliente clienteCriado = repo.save(novoCliente);

        assertThat(clienteCriado).isNotNull();
        assertThat(clienteCriado.getNomeCliente()).isEqualTo(novoCliente.getNomeCliente());
    }
    
}
