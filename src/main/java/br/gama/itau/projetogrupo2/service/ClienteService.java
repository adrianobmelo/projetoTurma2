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
    // mostrar todos
    private final ClienteRepo repo;

    //public List<Cliente> getAll() {
        //return (List<Cliente>) repo.findAll();
    //}

    public List<ClienteDTO> getAll() {
        // o método finAll retorna um Iterable, e nós precisamos de um List
        // por isso fazemos um Casting, transformando para o tipo que precisamos
        List<Cliente> lista = (List<Cliente>) repo.findAll();

        List<ClienteDTO> listaDTO = new ArrayList<>();

        for (Cliente cliente : lista) {
            listaDTO.add(new ClienteDTO(cliente));
        }

        return listaDTO;
    }

    // mostrar por id
    public Cliente getById(long id) {
        Optional<Cliente> clienteOptional = repo.findById(id);

        if (clienteOptional.isEmpty()) {
            throw new NotFoundException("Cliente não encontrado");
        }

        Cliente clienteEncontrado = clienteOptional.get();
        return clienteEncontrado;
    }

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

    // add cliente
    public Cliente newCliente(Cliente novoCliente) {
        if(novoCliente.getIdCliente() > 0) {
            return null;
        }
        Cliente clienteInserido = repo.save(novoCliente);
        return clienteInserido;
    }

    
}