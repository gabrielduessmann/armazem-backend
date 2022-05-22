package com.armazem.estoques;

import com.armazem.estoques.dto.EstoqueCriarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public void criarEstoque(EstoqueCriarDto estoque) {
        estoqueRepository.criarEstoque(UUID.randomUUID(), estoque.setor, estoque.capacidade, estoque.galpaoId);
    }

    public ArrayList<Estoque> listarEstoques() {
        return estoqueRepository.listarEstoques();
    }

    public ArrayList<Estoque> listarEstoquesPorId(UUID id) {
        return estoqueRepository.listarEstoquesPorId(id);
    }

    public void editarEstoque(UUID id, EstoqueCriarDto estoque) {
        estoqueRepository.editarEstoque(id, estoque.setor, estoque.capacidade, estoque.galpaoId);
    }

    public void deletarEstoque(UUID id) {
        estoqueRepository.deletarEstoque(id);
    }
}
