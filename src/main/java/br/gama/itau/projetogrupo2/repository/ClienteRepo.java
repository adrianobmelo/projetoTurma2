package br.gama.itau.projetogrupo2.repository;

import org.springframework.data.repository.CrudRepository;
import br.gama.itau.projetogrupo2.model.Cliente;

public interface ClienteRepo extends CrudRepository<Cliente, Long> {
    
}
    

