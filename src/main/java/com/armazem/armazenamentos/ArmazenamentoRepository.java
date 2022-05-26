package com.armazem.armazenamentos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface ArmazenamentoRepository extends CrudRepository<Armazenamento, UUID> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO armazenamento (armazenamento_id, estoque_id, produto_id, quantidade, ultimaatualizacao) VALUES (:armazenamentoId, :estoqueId, :produtoId, :quantidade, :ultimaAtualizacao)", nativeQuery = true)
    public void adicionarArmazenamento(@Param("armazenamentoId") UUID armazenamentoId, @Param("estoqueId") UUID estoqueId, @Param("produtoId") UUID produtoId, @Param("quantidade") Integer quantidade, @Param("ultimaAtualizacao") LocalDate ultimaAtualizacao);

    @Query(value = "SELECT CAST(a.armazenamento_id AS VARCHAR) AS armazenamentoId, CAST(e.estoque_id AS VARCHAR) AS estoqueId, CAST(p.produto_id AS VARCHAR) AS produtoId, a.quantidade AS quantidade, g.nome AS nomegalpao, e.setor AS setorestoque, p.nome AS nomeproduto, p.descricao \n" +
            "FROM armazenamento a \n" +
            "JOIN produto p ON p.produto_id = a.produto_id \n" +
            "JOIN estoque e ON e.estoque_id = a.estoque_id \n" +
            "JOIN galpao g ON g.galpao_id = e.galpao_id", nativeQuery = true)
    public ArrayList<Tuple> listarArmazenamentos();

    @Query(value = "SELECT CAST(a.armazenamento_id AS VARCHAR) AS armazenamentoId, CAST(e.estoque_id AS VARCHAR) AS estoqueId, CAST(p.produto_id AS VARCHAR) AS produtoId, a.quantidade AS quantidade, g.nome AS nomegalpao, e.setor AS setorestoque, p.nome AS nomeproduto, p.descricao \n" +
            "FROM armazenamento a \n" +
            "JOIN produto p ON p.produto_id = a.produto_id \n" +
            "JOIN estoque e ON e.estoque_id = a.estoque_id \n" +
            "JOIN galpao g ON g.galpao_id = e.galpao_id \n" +
            "WHERE a.armazenamento_id = :armazenamentoId", nativeQuery = true)
    public Tuple listarArmazenamentosPorId(@Param("armazenamentoId") UUID armazenamentoId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE armazenamento SET estoque_id = :estoqueId, produto_id = :produtoId, quantidade = :quantidade, ultimaatualizacao = :ultimaAtualizacao WHERE armazenamento_id = :armazenamentoId", nativeQuery = true)
    public void editarArmazenamento(@Param("armazenamentoId") UUID armazenamentoId, @Param("estoqueId") UUID estoqueId, @Param("produtoId") UUID produtoId, @Param("quantidade") Integer quantidade, @Param("ultimaAtualizacao") LocalDate ultimaAtualizacao);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM armazenamento WHERE armazenamento_id = :armazenamentoId", nativeQuery = true)
    public void deletarArmazenamento(@Param("armazenamentoId") UUID armazenamentoId);
}
