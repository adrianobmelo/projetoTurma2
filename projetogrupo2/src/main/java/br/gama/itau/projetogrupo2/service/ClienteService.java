package br.gama.itau.projetogrupo2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.gama.itau.projetogrupo2.model.Cliente;
import br.gama.itau.projetogrupo2.repository.ClienteRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepo repo;

    public List<Cliente> getAll() {
        return (List<Cliente>) repo.findAll();
    }
}
