package br.gama.itau.projetogrupo2.util;

import java.util.ArrayList;
import java.util.List;

import br.gama.itau.projetogrupo2.model.Cliente;
import br.gama.itau.projetogrupo2.model.Conta;

public class GenerateCliente {
    public static Cliente clienteId1() {
        List<Conta> contas = new ArrayList<>();
        contas.add(GenerateConta.contaId1());

        return Cliente.builder()
                .idCliente(1)
                .nomeCliente("Fulano x")
                .cpfCliente("1236547893")
                .telefoneCliente("75985632145")
                .contas(contas)
                .build();
    }

    
    public static Cliente novoClienteToSave() {
        return Cliente.builder()            
                .nomeCliente("Afranio")
                .cpfCliente("00569874521")
                .telefoneCliente("8436521478")
                .build();
    }
   

    public static Cliente clienteValido() {
        return Cliente.builder()
                .idCliente(1)
                .nomeCliente("Afranio")
                .cpfCliente("00569874521")
                .telefoneCliente("8436521478")
                .build();
    }

   
}

