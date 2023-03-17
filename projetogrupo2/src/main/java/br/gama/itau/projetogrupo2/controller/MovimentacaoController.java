package br.gama.itau.projetogrupo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.itau.projetogrupo2.model.Movimentacao;
import br.gama.itau.projetogrupo2.service.MovimentacaoService;
@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoService service;

    //criar nova movimentação
    @PostMapping
    public ResponseEntity<Movimentacao> newMovimentacao(@RequestBody Movimentacao novaMovimentacao) {
       Movimentacao movimentacaoInserida = service.newMovimentacao(novaMovimentacao);

        if(novaMovimentacao == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoInserida);
    }
}
