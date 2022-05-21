package com.armazem.produtos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, UUID> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO produto values (:id, :nome, :descricao)", nativeQuery = true)
    public void criaProduto(@Param("id") UUID id, @Param("nome") String nome, @Param("descricao") String descricao);

    @Query(value = "SELECT * FROM produto", nativeQuery = true)
    public ArrayList<Produto> listarProdutos();

    @Transactional
    @Modifying
    @Query(value = "UPDATE produto SET nome = :nome, descricao = :descricao WHERE produto_id = :id", nativeQuery = true)
    public void editarProduto(@Param("id") UUID id, @Param("nome") String nome, @Param("descricao") String descricao);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM produto WHERE produto_id = :id", nativeQuery = true)
    public void deletarProduto(@Param("id") UUID id);
}
