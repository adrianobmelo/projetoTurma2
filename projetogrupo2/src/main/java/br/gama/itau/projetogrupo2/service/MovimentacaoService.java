package br.gama.itau.projetogrupo2.service;

//import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gama.itau.projetogrupo2.model.Conta;
import br.gama.itau.projetogrupo2.model.Movimentacao;
import br.gama.itau.projetogrupo2.repository.MovimentacaoRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimentacaoService {
    private final MovimentacaoRepo repo;
    private final ContaService contaService;

    public Movimentacao newMovimentacao(Movimentacao novaMovimentacao) {
        if(novaMovimentacao.getNumSeq() > 0) {
            return null;
        }

        // buscar a conta da operação
        Conta conta = contaService.getNumeroConta(novaMovimentacao.getConta().getNumeroConta());
        double saldo = conta.getSaldo();

        // ajustar o saldo da conta (gravando o novo valor)
        if(novaMovimentacao.getTipoOperacao() == 1) {
            saldo = saldo + novaMovimentacao.getValor();
        } else {
            saldo = saldo - novaMovimentacao.getValor();
        }
        conta.setSaldo(saldo);
        contaService.updateConta(conta.getNumeroConta(), conta);

        Movimentacao movimentacaoInserida = repo.save(novaMovimentacao);

        return movimentacaoInserida;
    }
}
