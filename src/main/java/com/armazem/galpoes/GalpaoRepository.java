package com.armazem.galpoes;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface GalpaoRepository extends CrudRepository<Galpao, UUID> {
    @Modifying
    @Query(value = "INSERT INTO galpao VALUES (:id, :codigo, :capacidade, :endereco)", nativeQuery = true)
    public void criarGalpao(@Param("id") UUID id, @Param("codigo") String codigo, @Param("capacidade") Integer capacidade, @Param("endereco") UUID endereco_id);

    @Query(value = "SELECT * FROM galpao", nativeQuery = true)
    public ArrayList<Galpao> listarGalpoes();

    @Modifying
    @Query(value = "UPDATE galpao SET codigo = :codigo, capacidade = :capacidade, endereco = :endereco WHERE id = :id", nativeQuery = true)
    public void editarGalpao(@Param("id") UUID id, @Param("codigo") String codigo, @Param("capacidade") Integer capacidade, @Param("endereco") UUID endereco_id);

    @Modifying
    @Query(value = "DELETE FROM galpao WHERE id = :id", nativeQuery = true)
    public void deletarGalpao(@Param("id") UUID id);
}
