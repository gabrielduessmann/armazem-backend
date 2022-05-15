package com.armazem.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController()
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("produtos")
    public ResponseEntity<ArrayList<Produto>> obtemProdutos() {
        return ResponseEntity.ok(produtoService.listaProdutos());
    }

    @PostMapping("produto")
    public ResponseEntity<Void> criaProduto(@RequestBody Produto produto) {
        if (verificaNulo(produto)) ResponseEntity.internalServerError();
        produtoService.criaProduto(produto);
        return ResponseEntity.noContent().build();
    }

    public boolean verificaNulo(Produto produto) {
        return produto.getNome() != null && produto.getDescricao() != null && produto.getPrecocompra() != null;
    }

}
