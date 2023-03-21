package br.gama.itau.projetogrupo2.dto;

import br.gama.itau.projetogrupo2.model.Conta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContaDTO {   
    
        private long numeroConta;
        private int agencia;
        private int tipoConta;
        private double saldo;

        public ContaDTO(Conta conta) {
        this.numeroConta = conta.getNumeroConta();
        this.agencia = conta.getAgencia();
        this.tipoConta = conta.getTipoConta();
        this.saldo = conta.getSaldo();
    }
}
