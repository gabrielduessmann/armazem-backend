package com.armazem.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController()
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    final String PRODUTOS_URL = "produtos";

    @PostMapping(PRODUTOS_URL+"/criar")
    public ResponseEntity<Void> criarproduto(@RequestBody Produto produto) {
        produtoService.criarProduto(produto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(PRODUTOS_URL+"/listar")
    public ResponseEntity<ArrayList<Produto>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @PostMapping(PRODUTOS_URL+"/{id}/editar")
    public ResponseEntity<Void> editarProduto(@PathVariable UUID id, @RequestBody Produto produto) {
        produtoService.editarProduto(id, produto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(PRODUTOS_URL+"/{id}/remover")
    public ResponseEntity<Void> deletarProduto(@PathVariable UUID id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
