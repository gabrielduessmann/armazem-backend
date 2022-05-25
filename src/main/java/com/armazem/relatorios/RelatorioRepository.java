package com.armazem.relatorios;

import com.armazem.produtos.Produto;
import com.armazem.relatorios.dto.RelatorioProdutosArmazenadosListagemDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface RelatorioRepository extends CrudRepository<Produto, UUID> {
    @Query(
            value = "SELECT g.nome AS nomegalpao, es.setor AS setorestoque, p.nome AS nomeproduto, ar.quantidade, ar.ultimaatualizacao \n" +
                    "FROM alocacao a \n" +
                    "JOIN empresa e ON a.empresa_id = e.empresa_id\n" +
                    "JOIN estoque es ON a.estoque_id = es.estoque_id \n" +
                    "JOIN galpao g ON es.galpao_id = g.galpao_id\n" +
                    "JOIN armazenamento ar ON es.estoque_id = ar.estoque_id\n" +
                    "JOIN produto p ON ar.produto_id = p.produto_id\n" +
                    "WHERE e.empresa_id = :empresaId AND a.datafinal >= :dataAtual",
            nativeQuery = true)
    public ArrayList<Tuple> listarProdutosArmazenados(@Param("empresaId") UUID empresaId, @Param("dataAtual") LocalDate dataAtual);

    @Query(
            value = "SELECT g.nome AS nomegalpao, es.setor AS setorestoque, a.datafinal AS datafinalalocacao\n" +
                    "FROM alocacao a\n" +
                    "JOIN estoque es ON a.estoque_id = es.estoque_id\n" +
                    "JOIN galpao g ON es.galpao_id = g.galpao_id\n" +
                    "WHERE a.datafinal >= :dataAtual",
            nativeQuery = true
    )
    public ArrayList<Tuple> listarEstoquesAtivos(@Param("dataAtual") LocalDate dataAtual);

    @Query(
            value = "SELECT g.nome AS nomegalpao, es.setor AS setorestoque\n" +
                    "FROM alocacao a\n" +
                    "JOIN estoque es ON a.estoque_id = es.estoque_id\n" +
                    "JOIN galpao g ON es.galpao_id = g.galpao_id\n" +
                    "WHERE e.empresa_id = :empresaId AND a.datafinal BETWEEN :dataInicial AND :dataFinal",
            nativeQuery = true
    )
    public ArrayList<Tuple> listarHistoricoEstoques(@Param("empresaId") UUID empresaId, @Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal);
}
