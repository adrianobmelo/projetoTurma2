package br.gama.itau.projetogrupo2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gama.itau.projetogrupo2.dto.ContaDTO;
import br.gama.itau.projetogrupo2.model.Conta;
import br.gama.itau.projetogrupo2.service.ClienteService;
import br.gama.itau.projetogrupo2.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService service;

    @Autowired
    private ClienteService clienteService;

    // /contas/{id} (GET) - recuperarPeloNumero()
    @GetMapping("/{id}")
    public ResponseEntity<Conta> getNumeroConta(@PathVariable Long id) {
 
        Conta conta =service.getNumeroConta(id);
        if(conta == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(conta);
    }

    // /contas/cliente/{id} (GET) - recuperarContasPeloCliente
    @GetMapping("/id/{id}")
    public ResponseEntity<List<ContaDTO>> getByCliente(@PathVariable Long id) {

        return ResponseEntity.ok(clienteService.getContasById(id));
    }
    
    // /contas (POST) - adicionarConta()
    @PostMapping
    public ResponseEntity<Conta> newConta(@RequestBody Conta novaConta) {
        Conta contaInserida = service.newConta(novaConta);

        if(contaInserida == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(contaInserida);
    }

    // alterarDados()
    @PutMapping
    public ResponseEntity<Conta> updateConta(@PathVariable long id, @RequestBody Conta conta) {
        Conta contaAtualizada = service.updateConta(id, conta);
        
        if(contaAtualizada == null) {
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(contaAtualizada);
    }

    

}
