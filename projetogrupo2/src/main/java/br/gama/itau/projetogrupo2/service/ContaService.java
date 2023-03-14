package br.gama.itau.projetogrupo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gama.itau.projetogrupo2.exception.NotFoundException;
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

     // mostrar por conta
     public Conta getNumeroConta(long conta) {
        Optional<Conta> contaOptional = repo.findById(conta);

        if (contaOptional.isEmpty()) {
            throw new NotFoundException("Conta não encontrada");
        }

        Conta contaEncontrada = contaOptional.get();
        return contaEncontrada;
    }

    // add conta
    public Conta newConta(Conta novaConta) {
        if(novaConta.getNumeroConta() > 0) {
            return null;
        }
        Conta contaInserida = repo.save(novaConta);
        return contaInserida;
    }

}

