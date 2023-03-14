package br.gama.itau.projetogrupo2.model;

import java.util.List;

<<<<<<< HEAD
=======
import jakarta.persistence.Column;
>>>>>>> 0e43ac052a748a61512c75fca0e1722302ad8910
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
=======
import jakarta.persistence.OneToMany;
>>>>>>> 0e43ac052a748a61512c75fca0e1722302ad8910
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


<<<<<<< HEAD
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
=======
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
>>>>>>> 0e43ac052a748a61512c75fca0e1722302ad8910
    private List<Conta> contas;

}
