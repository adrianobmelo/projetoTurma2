package br.gama.itau.projetogrupo2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

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

    @OneToMany (mappedBy = "conta")
    @JsonIgnoreProperties("conta")
    private List <Movimentacao> movimentacoes; 

    //Cliente Opcional
}
    