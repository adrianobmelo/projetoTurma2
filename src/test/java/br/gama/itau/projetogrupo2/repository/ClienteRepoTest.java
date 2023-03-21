package br.gama.itau.projetogrupo2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import br.gama.itau.projetogrupo2.model.Cliente;
import br.gama.itau.projetogrupo2.util.GenerateCliente;

@DataJpaTest
public class ClienteRepoTest {
    
    @Autowired
    private ClienteRepo repo;

    @Test
    public void save_returnSavedCliente_whenValidCliente() {
        Cliente novoCliente = GenerateCliente.novoClienteToSave();

        Cliente clienteCriado = repo.save(novoCliente);

        assertThat(clienteCriado).isNotNull();
        assertThat(clienteCriado.getNomeCliente()).isEqualTo(novoCliente.getNomeCliente());
    }
    
}
