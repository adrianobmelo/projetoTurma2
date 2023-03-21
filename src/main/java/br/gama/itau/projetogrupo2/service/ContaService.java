package br.gama.itau.projetogrupo2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.gama.itau.projetogrupo2.dto.MovimentacaoDTO;
import br.gama.itau.projetogrupo2.exception.NotFoundException;
import br.gama.itau.projetogrupo2.model.Conta;
import br.gama.itau.projetogrupo2.model.Movimentacao;
import br.gama.itau.projetogrupo2.repository.ContaRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContaService {
    
    private final ContaRepo repo;

    // adicionarConta()
    public Conta newConta(Conta novaConta) {
        if(novaConta.getNumeroConta() > 0) {
            return null;
        }
        Conta contaInserida = repo.save(novaConta);
        return contaInserida;
    }

    // recuperarPeloNumero()
    public Conta getNumeroConta(long conta) {
        Optional<Conta> contaOptional = repo.findById(conta);

        if (contaOptional.isEmpty()) {
            throw new NotFoundException("Conta não encontrada");
        }

        Conta contaEncontrada = contaOptional.get();
        return contaEncontrada;
    }

    // alterarDados()
    public Conta updateConta(long id, Conta conta){
        Optional<Conta>contaOptional = repo.findById(id);

        if(contaOptional.isEmpty()) {
            return null;
        }
        conta.setNumeroConta(id);
        Conta contaAtualizada = repo.save(conta);
        return contaAtualizada;
    }
    
    // recuperarContasPeloCliente()
    public Conta getByCLiente(long id) {
        return repo.findByCliente(id);
    }

    // MovimentacaoService > recuperarTodas()
    public List<Conta> getAll() {
        return (List<Conta>) repo.findAll();
    }

    // MovimentacaoService > recuperarMovimentacoesPelaConta()
    public List<MovimentacaoDTO> getMovimentacoesByConta(long id) {
        Optional<Conta> contaOptional = repo.findById(id);

        if (contaOptional.isEmpty()) {
            throw new NotFoundException("Conta não encontrada");
        }

        Conta contaEncontrada = contaOptional.get();
        List<Movimentacao> listaMovimentacoes = contaEncontrada.getMovimentacoes();
        List<MovimentacaoDTO> listaMovimentacoesDTO = new ArrayList<>();

        for (Movimentacao movimentacao : listaMovimentacoes) {
            listaMovimentacoesDTO.add(new MovimentacaoDTO(movimentacao));
        }
        return listaMovimentacoesDTO;
    }
    

    

    

    
}

