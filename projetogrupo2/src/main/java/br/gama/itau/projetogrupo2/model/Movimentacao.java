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

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Getter
@Setter

public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta", nullable = false)
    private int num_seq;
    
    @Column()
    private Date data_operacao;

    @Column(length = 1, nullable = false)
    private double valor;

    @Column(length = 255)
    private String descricao;

    private int tipo_operacao;

    
    @ManyToOne
    @JoinColumn(name = "numero_conta")
    @JsonIgnoreProperties("contas")
    private Movimentacao movimentacao;
}

