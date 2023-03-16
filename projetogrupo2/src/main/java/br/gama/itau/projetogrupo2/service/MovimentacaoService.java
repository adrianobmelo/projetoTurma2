package br.gama.itau.projetogrupo2.service;

import org.springframework.stereotype.Service;

import br.gama.itau.projetogrupo2.model.Movimentacao;
import br.gama.itau.projetogrupo2.repository.MovimentacaoRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimentacaoService {
    private final MovimentacaoRepo repo;

    public Movimentacao newMovimentacao(Movimentacao novaMovimentacao) {
        if(novaMovimentacao.getNumSeq() > 0) {
            return null;
        }
        Movimentacao movimentacaoInserida = repo.save(novaMovimentacao);
        return movimentacaoInserida;
    }

   
}
