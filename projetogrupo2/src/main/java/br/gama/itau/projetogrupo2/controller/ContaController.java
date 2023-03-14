package br.gama.itau.projetogrupo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.itau.projetogrupo2.model.Conta;
import br.gama.itau.projetogrupo2.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService service;

     //pegar por numero da conta
     @GetMapping("/{id}")
     public ResponseEntity<Conta> getNumeroConta(@PathVariable Long id) {
 
        Conta conta =service.getNumeroConta(id);
         return ResponseEntity.ok(conta);
     }
 
     //criar conta nova
     @PostMapping
     public ResponseEntity<Conta> newConta(@RequestBody Conta novaConta) {
         Conta contaInserida = service.newConta(novaConta);
 
         if(contaInserida == null) {
             return ResponseEntity.badRequest().build();
         }
 
         return ResponseEntity.status(HttpStatus.CREATED).body(contaInserida);
     }

     // //alterar
    // @PutMapping
    // public ResponseEntity<Cliente> updateCliente(@PathVariable long id, @RequestBody Cliente cliente) {
    //     Cliente clienteAtualizado = service.updateCliente(id, cliente);
    //     if(clienteAtualizado == null) {
    //         return ResponseEntity.badRequest().build();
    //     }
    //     return ResponseEntity.ok(clienteAtualizado);


    // }
}
