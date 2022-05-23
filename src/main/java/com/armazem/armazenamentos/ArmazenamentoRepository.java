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
    @Query(value = "INSERT INTO armazenamento VALUES (:estoqueId, :produtoId, :quantidade, :ultimaAtualizacao)", nativeQuery = true)
    public void adicionarArmazenamento(@Param("estoqueId") UUID estoqueId, @Param("produtoId") UUID produtoId, @Param("quantidade") Integer quantidade, @Param("ultimaAtualizacao") LocalDate ultimaAtualizacao);

    @Query(value = "SELECT CAST(a.estoque_id AS VARCHAR) AS estoqueid, CAST(a.produto_id AS VARCHAR) AS produtoid, g.nome AS nomegalpao, e.setor AS setorestoque, p.nome AS nomeproduto, p.descricao \n" +
            "FROM armazenamento a\n" +
            "JOIN produto p ON p.produto_id = a.produto_id \n" +
            "JOIN estoque e ON e.estoque_id = a.estoque_id \n" +
            "JOIN galpao g ON g.galpao_id = e.galpao_id", nativeQuery = true)
    public ArrayList<Tuple> listarArmazenamentos();

    @Query(value = "SELECT a.estoque_id AS estoqueid, a.produto_id AS produtoid, g.nome AS nomegalpao, e.setor AS setorestoque, p.nome AS nomeproduto, p.descricao \n" +
            "FROM armazenamento a\n" +
            "JOIN produto p ON p.produto_id = a.produto_id \n" +
            "JOIN estoque e ON e.estoque_id = a.estoque_id \n" +
            "JOIN galpao g ON g.galpao_id = e.galpao_id\n" +
            "WHERE a.estoque_id = :estoqueId AND a.produto_id = :produtoId; ", nativeQuery = true)
    public Tuple listarArmazenamentosPorId(@Param("estoqueId") UUID estoqueId, @Param("produtoId") UUID produtoId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE armazenamento SET estoque_id = :novoEstoqueId, produto_id = :novoProdutoId, quantidade = :quantidade, ultimaatualizacao = :ultimaAtualizacao WHERE estoque_id = :estoqueId AND produto_id = :produtoId", nativeQuery = true)
    public void editarArmazenamento(@Param("estoqueId") UUID estoqueId, @Param("produtoId") UUID produtoId, @Param("estoqueId") UUID novoEstoqueId, @Param("produtoId") UUID novoProdutoId, @Param("quantidade") Integer quantidade, @Param("ultimaAtualizacao") LocalDate ultimaAtualizacao);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM armazenamento WHERE estoque_id = :estoqueId AND produto_id = :produtoId", nativeQuery = true)
    public void deletarArmazenamento(@Param("estoqueId") UUID estoqueId, @Param("produtoId") UUID produtoId);
}
