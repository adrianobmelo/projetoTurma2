package br.gama.itau.projetogrupo2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties("contas")
    private Cliente cliente;
}
    