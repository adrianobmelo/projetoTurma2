package br.gama.itau.projetogrupo2.dto;

import br.gama.itau.projetogrupo2.model.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor

public class ClienteDTO {

    private long idCliente;

    private String nomeCliente;

    private String cpfCliente;

    private String telefoneCliente;

    public ClienteDTO(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCliente = cliente.getNomeCliente();
        this.cpfCliente = cliente.getCpfCliente();
        this.telefoneCliente = cliente.getTelefoneCliente();
    }

}
