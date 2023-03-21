package br.gama.itau.projetogrupo2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.gama.itau.projetogrupo2.dto.ClienteDTO;
import br.gama.itau.projetogrupo2.dto.ContaDTO;
import br.gama.itau.projetogrupo2.exception.NotFoundException;
import br.gama.itau.projetogrupo2.model.Cliente;
import br.gama.itau.projetogrupo2.model.Conta;
import br.gama.itau.projetogrupo2.repository.ClienteRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
  
    private final ClienteRepo repo;
    
    // cadastrarCliente()
    public Cliente newCliente(Cliente novoCliente) {
        if(novoCliente.getIdCliente() > 0) {
        return null;
        }
    Cliente clienteInserido = repo.save(novoCliente);
    return clienteInserido;
}

    // recuperarTodos()
    public List<ClienteDTO> getAll() {
        List<Cliente> lista = (List<Cliente>) repo.findAll();

        List<ClienteDTO> listaDTO = new ArrayList<>();

        for (Cliente cliente : lista) {
            listaDTO.add(new ClienteDTO(cliente));
        }

        return listaDTO;
    }

    // recuperarPeloID()
    public Cliente getById(long id) {
        Optional<Cliente> clienteOptional = repo.findById(id);

        if (clienteOptional.isEmpty()) {
            throw new NotFoundException("Cliente não encontrado");
        }

        Cliente clienteEncontrado = clienteOptional.get();
        return clienteEncontrado;
    }

    // ContaService > recuperarContasPeloCliente()
    public List<ContaDTO> getContasById(long id) {
        Optional<Cliente> clienteOptional = repo.findById(id);

        if (clienteOptional.isEmpty()) {
            throw new NotFoundException("Cliente não encontrado");
        }

        Cliente clienteEncontrado = clienteOptional.get();
        List<Conta> listaContas = clienteEncontrado.getContas();
        List<ContaDTO> listaContasDTO =new ArrayList<>();

        for (Conta conta : listaContas) {
            listaContasDTO.add(new ContaDTO(conta));
        }
        return listaContasDTO;
    }
}
