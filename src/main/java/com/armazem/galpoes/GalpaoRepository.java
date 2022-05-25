package com.armazem.galpoes;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface GalpaoRepository extends CrudRepository<Galpao, UUID> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO galpao (galpao_id, nome, descricao, cidade, bairro, rua, numero, complemento) VALUES (:id, :nome, :descricao, :cidade, :bairro, :rua, :numero, :complemento)", nativeQuery = true)
    public void criarGalpao(@Param("id") UUID id, @Param("nome") String nome, @Param("descricao") String descricao, @Param("cidade") String cidade, @Param("bairro") String bairro, @Param("rua") String rua, @Param("numero") Integer numero, @Param("complemento") String complemento);

    @Query(value = "SELECT * FROM galpao", nativeQuery = true)
    public ArrayList<Galpao> listarGalpoes();

    @Query(value = "SELECT * FROM galpao WHERE galpao_id = :id", nativeQuery = true)
    public Galpao listarGalpoesPorId(@Param("id") UUID id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE galpao SET nome = :nome, descricao = :descricao, cidade = :cidade, bairro = :bairro, rua = :rua, numero = :numero, complemento = :complemento WHERE galpao_id = :id", nativeQuery = true)
    public void editarGalpao(@Param("id") UUID id, @Param("nome") String nome, @Param("descricao") String descricao, @Param("cidade") String cidade, @Param("bairro") String bairro, @Param("rua") String rua, @Param("numero") Integer numero, @Param("complemento") String complemento);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM galpao WHERE galpao_id = :id", nativeQuery = true)
    public void deletarGalpao(@Param("id") UUID id);
}
