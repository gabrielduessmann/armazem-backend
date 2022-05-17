package com.armazem.estoques_produtos;

import com.armazem.estoques_produtos.dto.EstoqueProdutoAdicionarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class EstoqueProdutoService {

    @Autowired
    private EstoqueProdutoRepository estoqueProdutoRepository;

    public void adicionarEstoqueProduto(EstoqueProdutoAdicionarDto estoqueProduto) {
        LocalDate dataAtual = LocalDate.now();
        estoqueProdutoRepository.adicionarEstoqueProduto(estoqueProduto.estoqueId, estoqueProduto.produtoId, estoqueProduto.quantidade, dataAtual);
    }

//    public ArrayList<Estoque> listarEstoques() {
//        return estoqueProdutoRepository.();
//    }

    public void editarEstoque(EstoqueProdutoAdicionarDto estoqueProduto) {
        LocalDate dataAtual = LocalDate.now();
        estoqueProdutoRepository.editarEstoqueProduto(estoqueProduto.estoqueId, estoqueProduto.produtoId, estoqueProduto.quantidade, dataAtual);
    }

    public void deletarEstoqueProduto(UUID estoqueId, UUID produtoID) {
        estoqueProdutoRepository.deletarEstoqueProduto(estoqueId, produtoID);
    }
}
