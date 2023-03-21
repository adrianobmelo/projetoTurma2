package br.gama.itau.projetogrupo2.repository;

import org.springframework.data.repository.CrudRepository;
import br.gama.itau.projetogrupo2.model.Conta;

public interface ContaRepo extends CrudRepository<Conta, Long>{

    Conta findByCliente(Long id);
    
}
