package br.gama.itau.projetogrupo2.util;


import br.gama.itau.projetogrupo2.model.Conta;

public class GenerateConta {
    public static Conta contaId1() {
        return Conta.builder()
                .numeroConta(1)
                .agencia(3151)
                .tipoConta( 2)
                .saldo(500)
                .build();
    }

    public static Conta novaContaToSave() {
        return Conta.builder()            
                // .numeroConta(1)
                .agencia(4585)
                .tipoConta(1)
                .saldo(200)
                .build();
    }

    public static Conta contaValida() {
        return Conta.builder()
                .numeroConta(1)
                .agencia(4585)
                .tipoConta(1)
                .saldo(200)
                .build();
    }

  
   

  

   
}

