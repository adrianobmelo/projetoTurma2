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
    private long numero_conta;
    
    @Column(length = 4)
    private int agencia;

    @Column(length = 1, nullable = false)
    private int tipo_conta;

    private double saldo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties("contas")
    private Conta conta;
}
    