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
import br.gama.itau.projetogrupo2.dto.MovimentacaoDTO;
import br.gama.itau.projetogrupo2.model.Movimentacao;
import br.gama.itau.projetogrupo2.service.ContaService;
import br.gama.itau.projetogrupo2.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoService service;

    @Autowired
    private ContaService contaService;

    // /movimentacao (POST) - cadastrarMovimentacao()
    @PostMapping
    public ResponseEntity<Movimentacao> newMovimentacao(@RequestBody Movimentacao novaMovimentacao) {
        Movimentacao movimentacaoInserida = service.newMovimentacao(novaMovimentacao);

        if(novaMovimentacao == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoInserida);
    }

    // /movimentacoes/id/{id} (GET) - recuperarMovimentacoesPelaConta
    @GetMapping("/id/{id}")
    public ResponseEntity<List<MovimentacaoDTO>> getMovimentacoesByConta(@PathVariable Long id) {
 
        return ResponseEntity.ok(contaService.getMovimentacoesByConta(id));
     }

}
