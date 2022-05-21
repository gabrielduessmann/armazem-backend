package com.armazem.estoques;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, UUID> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO estoque VALUES (:id, :setor, :capacidade, :galpaoId)", nativeQuery = true)
    public void criarEstoque(@Param("id") UUID id, @Param("setor") String setor, @Param("capacidade") Integer capacidade, @Param("galpaoId") UUID galpaoId);

    @Query(value = "SELECT * FROM estoque", nativeQuery = true)
    public ArrayList<Estoque> listarEstoques();

    @Transactional
    @Modifying
    @Query(value = "UPDATE estoque SET setor = :setor, capacidade = :capacidade, galpao_id = :galpaoId WHERE estoque_id = :id", nativeQuery = true)
    public void editarEstoque(@Param("id") UUID id, @Param("setor") String setor, @Param("capacidade") Integer capacidade, @Param("galpaoId") UUID galpaoId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM estoque WHERE estoque_id = :id", nativeQuery = true)
    public void deletarEstoque(@Param("id") UUID id);
}
