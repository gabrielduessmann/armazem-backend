package com.armazem.estoques;

import com.armazem.estoques.dto.EstoqueCriarDto;
import com.armazem.estoques.dto.EstoqueListarDto;
import com.armazem.estoques.dto.EstoquesDisponiveisListarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.Tuple;;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public void criarEstoque(EstoqueCriarDto estoque) {
        estoqueRepository.criarEstoque(UUID.randomUUID(), estoque.setor, estoque.capacidade, estoque.galpaoId);
    }

    public ArrayList<EstoqueListarDto> listarEstoques() {
        ArrayList<Estoque> estoqueListar = estoqueRepository.listarEstoques();
        ArrayList<EstoqueListarDto> estoqueListarDto = new ArrayList<>();
        estoqueListar.forEach(e -> {
            estoqueListarDto.add(
            EstoqueListarDto
                    .builder()
                    .estoqueId(e.getEstoqueId().toString())
                    .nomegalpao(e.getGalpao().getNome())
                    .setorestoque(e.getSetor())
                    .capacidade(e.getCapacidade().toString())
                    .build()
            );
        });
        return estoqueListarDto;
    }

    public Estoque listarEstoquesPorId(UUID id) {
        return estoqueRepository.listarEstoquesPorId(id);
    }

    public ArrayList<EstoquesDisponiveisListarDto> listarEstoquesDisponiveis() {
        LocalDate dataAtual = LocalDate.now();
        ArrayList<Tuple> tuplas = estoqueRepository.listarEstoquesDisponiveis(dataAtual);
        return convertToEstoquesDisponiveisListarDto(tuplas);
    }

    public void editarEstoque(UUID id, EstoqueCriarDto estoque) {
        estoqueRepository.editarEstoque(id, estoque.setor, estoque.capacidade, estoque.galpaoId);
    }

    public void deletarEstoque(UUID id) {
        estoqueRepository.deletarEstoque(id);
    }

    private ArrayList<EstoquesDisponiveisListarDto> convertToEstoquesDisponiveisListarDto(ArrayList<Tuple> tuplas) {
        ArrayList<EstoquesDisponiveisListarDto> estoquesDisponiveisDto = new ArrayList<>();
        tuplas.forEach(tupla -> {
            estoquesDisponiveisDto.add(
                    EstoquesDisponiveisListarDto.builder()
                            .estoqueId(obterValorTupla(tupla.get("estoqueid")))
                            .nomegalpao(obterValorTupla(tupla.get("nomegalpao")))
                            .setorestoque(obterValorTupla(tupla.get("setorestoque")))
                            .build()
            );
        });
        return estoquesDisponiveisDto;
    }

    private String obterValorTupla(Object valor) {
        return valor != null ? valor.toString() : null;
    }
}
