package br.gama.itau.projetogrupo2.util;

//import java.time.LocalDate;
import java.util.List;
import br.gama.itau.projetogrupo2.model.Conta;
import br.gama.itau.projetogrupo2.model.Movimentacao;
import java.util.ArrayList;

public class GenerateMovimentacao {

    public static Movimentacao movimentacaoId1() {
        
        List<Conta> contas = new ArrayList<>();
        contas.add(GenerateConta.contaId1());

        return Movimentacao.builder()
                .numSeq(1)
                //.dataOperacao(LocalDate.now())
                .descricao("Saque")
                .valor(200)
                .tipoOperacao(1)
                //.contas(contas)
                .build();
    }

    public static Movimentacao movimentacaoValida() {
        return Movimentacao.builder()
            .numSeq(1)
            //.dataOperacao(LocalDate.now())
            .descricao("Saque")
            .valor(200)
            .tipoOperacao(1)
            .build();
    }

    public static Movimentacao novaMovimentacaoToSave() {
        return Movimentacao.builder()
            // .numSeq(1)
            //.dataOperacao(LocalDate.now())
            .descricao("Saque")
            .valor(200)
            .tipoOperacao(1)
            .conta(Conta.builder().numeroConta(1).build())
            .build();
    }  
}
