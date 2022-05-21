package com.armazem.armazenamentos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface ArmazenamentoRepository extends CrudRepository<Armazenamento, UUID> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO estoque_produto VALUES (:estoqueId, :produtoId, :quantidade, :ultimaAtualizacao)", nativeQuery = true)
    public void adicionarEstoqueProduto(@Param("estoqueId") UUID estoqueId, @Param("produtoId") UUID produtoId, @Param("quantidade") Integer quantidade, @Param("ultimaAtualizacao") LocalDate ultimaAtualizacao);

//    @Query(value = "SELECT * FROM empresa", nativeQuery = true)
//    public ArrayList<Empresa> listarEmpresas();

    @Transactional
    @Modifying
    @Query(value = "UPDATE empresa SET quantidade = :quantidade, ultimaatualizacao = :ultimaAtualizacao WHERE estoque_id = :estoqueId AND produto_id = :produtoId", nativeQuery = true)
    public void editarEstoqueProduto(@Param("estoqueId") UUID estoqueId, @Param("produtoId") UUID produtoId, @Param("quantidade") Integer quantidade, @Param("ultimaAtualizacao") LocalDate ultimaAtualizacao);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM estoque_produto WHERE estoque_id = :estoqueId AND produto_id = :produtoId", nativeQuery = true)
    public void deletarEstoqueProduto(@Param("estoqueId") UUID estoqueId, @Param("produtoId") UUID produtoId);
}
