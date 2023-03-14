package br.gama.itau.projetogrupo2.service;

import java.util.List;
import java.util.Optional;
//import br.gama.itau.projetogrupo2.exception.NotFoundException;

import org.springframework.stereotype.Service;

import br.gama.itau.projetogrupo2.exception.NotFoundException;
import br.gama.itau.projetogrupo2.model.Cliente;
import br.gama.itau.projetogrupo2.repository.ClienteRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    // mostrar todos
    private final ClienteRepo repo;

    public List<Cliente> getAll() {
        return (List<Cliente>) repo.findAll();
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

    // add cliente
    public Cliente newCliente(Cliente novoCliente) {
        if(novoCliente.getIdCliente() > 0) {
            return null;
        }
        Cliente clienteInserido = repo.save(novoCliente);
        return clienteInserido;
    }
}
