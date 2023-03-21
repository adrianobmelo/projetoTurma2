package br.gama.itau.projetogrupo2.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movimentacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conta", nullable = false)
    private int numSeq;
    
    private LocalDate dataOperacao;

    @Column(nullable = false)
    private double valor;

    private int tipoOperacao;
        // 1 - crédito
        // 2 - débito
    
    @Column(length = 255)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "numero_conta")
    @JsonIgnoreProperties("movimentacoes")
    private Conta conta;
}

