package com.armazem.produtos;

import com.armazem.empresas.Empresa;
import com.armazem.empresas.dto.EmpresaCriarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void criarProduto(Produto produto) {
        produtoRepository.criaProduto(UUID.randomUUID(), produto.getNome(), produto.getDescricao());
    }

    public ArrayList<Produto> listarProdutos() {
        return produtoRepository.listarProdutos();
    }

    public void editarProduto(UUID id, Produto produto) {
        produtoRepository.editarProduto(id, produto.getNome(), produto.getDescricao());
    }

    public void deletarProduto(UUID id) {
        produtoRepository.deletarProduto(id);
    }

}
