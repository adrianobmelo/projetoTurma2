package br.gama.itau.projetogrupo2.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Getter
@Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cliente;

    @Column(length=100, nullable = false)
    private String nome_cliente;

    @Column(length=20, nullable = false, unique=true)
    private String cpf_cliente;

    @Column(length = 20, nullable= false)
    private String telefone_cliente;

    @OneToMany(mappedBy = "conta")
    @JsonIgnoreProperties("conta") // quando buscar os dados dos veículos, ignore os dados do proprietario
    private List<Conta> contas;

}
