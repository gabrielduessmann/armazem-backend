package com.armazem.galpoes;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface GalpaoRepository extends CrudRepository<Galpao, UUID> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO galpao VALUES (:id, :codigo, :capacidade, :enderecoId)", nativeQuery = true)
    public void criarGalpao(@Param("id") UUID id, @Param("codigo") String codigo, @Param("capacidade") Integer capacidade, @Param("enderecoId") UUID enderecoId);

    @Query(value = "SELECT * FROM galpao", nativeQuery = true)
    public ArrayList<Galpao> listarGalpoes();

    @Transactional
    @Modifying
    @Query(value = "UPDATE galpao SET codigo = :codigo, capacidade = :capacidade, endereco_id = :enderecoId WHERE id = :id", nativeQuery = true)
    public void editarGalpao(@Param("id") UUID id, @Param("codigo") String codigo, @Param("capacidade") Integer capacidade, @Param("enderecoId") UUID enderecoId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM galpao WHERE id = :id", nativeQuery = true)
    public void deletarGalpao(@Param("id") UUID id);
}
