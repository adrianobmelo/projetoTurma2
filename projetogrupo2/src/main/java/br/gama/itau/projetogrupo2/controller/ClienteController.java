package br.gama.itau.projetogrupo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.itau.projetogrupo2.model.Cliente;
import br.gama.itau.projetogrupo2.service.ClienteService;

@RestController
@RequestMapping("/contas")
public class ClienteController {
    
    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
