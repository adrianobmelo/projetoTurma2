package br.gama.itau.projetogrupo2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Getter
@Setter
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta")
    private long numeroConta;
    
    
    private int agencia;

    @Column(nullable = false)
    private int tipoConta;

    private double saldo;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonIgnoreProperties("contas")
    private Conta movimentacao; // Duvidas aqui

    //Cliente Opcional
}
    