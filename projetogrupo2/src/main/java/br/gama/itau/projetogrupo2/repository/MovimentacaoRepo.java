package br.gama.itau.projetogrupo2.repository;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.projetogrupo2.model.Movimentacao;

public interface MovimentacaoRepo extends CrudRepository<Movimentacao ,Long> {
    
}
