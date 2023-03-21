package br.gama.itau.projetogrupo2.dto;

import br.gama.itau.projetogrupo2.model.Movimentacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovimentacaoDTO {
    private int numSeq;
    private double valor;
    private String descrição;
    private int tipoOperacao;
    
    public MovimentacaoDTO(Movimentacao movimentacao) {
        this.numSeq = movimentacao.getNumSeq();
        this.valor = movimentacao.getValor();
        this.descrição = movimentacao.getDescricao();
        this.tipoOperacao = movimentacao.getTipoOperacao();
    }
}
