package br.gama.itau.projetogrupo2.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.gama.itau.projetogrupo2.model.Conta;
import br.gama.itau.projetogrupo2.repository.ContaRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContaService {
    private final ContaRepo repo;

    public List<Conta> getAll() {
        return (List<Conta>) repo.findAll();
    }
}

