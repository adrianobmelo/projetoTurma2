package br.gama.itau.projetogrupo2.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCliente;

    @Column(length=100)
    private String nomeCliente;

    @Column(length=20, nullable = false, unique=true)
    private String cpfCliente;

    @Column(length = 20, nullable= false, unique=true)
    private String telefoneCliente;

    @OneToMany(mappedBy = "conta")
    @JsonIgnoreProperties("conta")
    private List<Conta> contas;

}
