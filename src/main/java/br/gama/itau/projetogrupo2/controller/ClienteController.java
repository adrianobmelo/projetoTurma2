package br.gama.itau.projetogrupo2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gama.itau.projetogrupo2.dto.ClienteDTO;
import br.gama.itau.projetogrupo2.model.Cliente;
import br.gama.itau.projetogrupo2.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService service;

    // /clientes (GET) - recuperarTodos()
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // /clientes/{id} (GET) - recuperarPeloId
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {

        Cliente cliente = service.getById(id);
        return ResponseEntity.ok(cliente);
    }

    // /clientes (POST) - cadastrarCliente
    @PostMapping
    public ResponseEntity<Cliente> newCliente(@RequestBody Cliente novoCliente) {
        Cliente clienteInserido = service.newCliente(novoCliente);

        if(clienteInserido == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteInserido);
    }

   // testando o merge do projeto
}
