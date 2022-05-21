package com.armazem.armazenamentos;

import com.armazem.armazenamentos.dto.EstoqueProdutoAdicionarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class ArmazenamentoService {

    @Autowired
    private ArmazenamentoRepository armazenamentoRepository;

    public void adicionarEstoqueProduto(EstoqueProdutoAdicionarDto estoqueProduto) {
        LocalDate dataAtual = LocalDate.now();
        armazenamentoRepository.adicionarEstoqueProduto(estoqueProduto.estoqueId, estoqueProduto.produtoId, estoqueProduto.quantidade, dataAtual);
    }

//    public ArrayList<Estoque> listarEstoques() {
//        return estoqueProdutoRepository.();
//    }

    public void editarEstoque(EstoqueProdutoAdicionarDto estoqueProduto) {
        LocalDate dataAtual = LocalDate.now();
        armazenamentoRepository.editarEstoqueProduto(estoqueProduto.estoqueId, estoqueProduto.produtoId, estoqueProduto.quantidade, dataAtual);
    }

    public void deletarEstoqueProduto(UUID estoqueId, UUID produtoID) {
        armazenamentoRepository.deletarEstoqueProduto(estoqueId, produtoID);
    }
}
