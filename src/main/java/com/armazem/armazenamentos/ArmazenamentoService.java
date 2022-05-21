package com.armazem.armazenamentos;

import com.armazem.armazenamentos.dto.ArmazenamentoAdicionarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class ArmazenamentoService {

    @Autowired
    private ArmazenamentoRepository armazenamentoRepository;

    public void adicionarArmazenamento(ArmazenamentoAdicionarDto armazenamento) {
        LocalDate dataAtual = LocalDate.now();
        armazenamentoRepository.adicionarArmazenamento(armazenamento.estoqueId, armazenamento.produtoId, armazenamento.quantidade, dataAtual);
    }

//    public ArrayList<Estoque> listarEstoques() {
//        return estoqueProdutoRepository.();
//    }

    public void editarArmazenamento(ArmazenamentoAdicionarDto armazenamento) {
        LocalDate dataAtual = LocalDate.now();
        armazenamentoRepository.editarArmazenamento(armazenamento.estoqueId, armazenamento.produtoId, armazenamento.quantidade, dataAtual);
    }

    public void deletarArmazenamento(UUID estoqueId, UUID produtoID) {
        armazenamentoRepository.deletarArmazenamento(estoqueId, produtoID);
    }
}
