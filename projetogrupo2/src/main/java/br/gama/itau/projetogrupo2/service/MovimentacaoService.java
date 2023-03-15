package br.gama.itau.projetogrupo2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.gama.itau.projetogrupo2.model.Movimentacao;
import br.gama.itau.projetogrupo2.repository.MovimentacaoRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimentacaoService {
    private final MovimentacaoRepo repo;

    public List<Movimentacao> getAll() {
        return (List<Movimentacao>) repo.findAll();
    }
}