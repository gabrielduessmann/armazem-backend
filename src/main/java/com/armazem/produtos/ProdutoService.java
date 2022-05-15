package com.armazem.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class ProdutoService {
    @Autowired(required = false)
    private ProdutoRepository produtoRepository;

    @Transactional
    public void criaProduto(Produto produto) {
       produtoRepository.criaProduto(UUID.randomUUID(), produto.getNome(), produto.getDescricao(), produto.getPrecocompra());
    }

    public ArrayList<Produto> listaProdutos() {
        return produtoRepository.listaProdutos();
    }

}
