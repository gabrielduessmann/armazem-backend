package com.armazem.produtos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, UUID> {

    @Modifying
    @Query(value = "INSERT INTO produto values (:id, :nome, :descricao, :preco)", nativeQuery = true)
    public void criaProduto(@Param("id") UUID id, @Param("nome") String nome, @Param("descricao") String descricao, @Param("preco") Double preco);

    @Query(value = "SELECT * FROM produto", nativeQuery = true)
    public ArrayList<Produto> listaProdutos();
}
