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
    @Query(value = "INSERT INTO estoque VALUES (:id, :setor, :galpaoId, :empresaId)", nativeQuery = true)
    public void criarEstoque(@Param("id") UUID id, @Param("setor") String setor, @Param("galpaoId") UUID galpaoId, @Param("empresaId") UUID empresaId);

    @Query(value = "SELECT * FROM estoque", nativeQuery = true)
    public ArrayList<Estoque> listarEstoques();

    @Transactional
    @Modifying
    @Query(value = "UPDATE estoque SET setor = :setor, galpao_id = :galpaoId, empresa_id = :empresaID WHERE id = :id", nativeQuery = true)
    public void editarEstoque(@Param("id") UUID id, @Param("setor") String setor, @Param("galpaoId") UUID galpaoId, @Param("empresaId") UUID empresaId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM estoque WHERE id = :id", nativeQuery = true)
    public void deletarEstoque(@Param("id") UUID id);
}
