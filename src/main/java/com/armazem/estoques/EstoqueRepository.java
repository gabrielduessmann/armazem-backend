package com.armazem.estoques;

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
public interface EstoqueRepository extends CrudRepository<Estoque, UUID> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO estoque (estoque_id, setor, capacidade, galpao_id) VALUES (:id, :setor, :capacidade, :galpaoId)", nativeQuery = true)
    public void criarEstoque(@Param("id") UUID id, @Param("setor") String setor, @Param("capacidade") Integer capacidade, @Param("galpaoId") UUID galpaoId);

    @Query(value = "SELECT * FROM estoque", nativeQuery = true)
    public ArrayList<Estoque> listarEstoques();

    @Query(value = "SELECT * FROM estoque WHERE estoque_id = :id", nativeQuery = true)
    public Estoque listarEstoquesPorId(@Param("id") UUID id);

    @Query(value = "SELECT DISTINCT CAST(e.estoque_id AS VARCHAR) AS estoqueid, e.setor AS setorestoque, g.nome AS nomegalpao \n" +
            "FROM estoque e\n" +
            "JOIN galpao g on g.galpao_id = e.galpao_id\n" +
            "LEFT JOIN alocacao a ON a.estoque_id = e.estoque_id AND a.datafinal > :dataFinal\n" +
            "WHERE a.empresa_id IS NULL", nativeQuery = true)
    public ArrayList<Tuple> listarEstoquesDisponiveis(@Param("dataFinal") LocalDate dataFinal);

    @Transactional
    @Modifying
    @Query(value = "UPDATE estoque SET setor = :setor, capacidade = :capacidade, galpao_id = :galpaoId WHERE estoque_id = :id", nativeQuery = true)
    public void editarEstoque(@Param("id") UUID id, @Param("setor") String setor, @Param("capacidade") Integer capacidade, @Param("galpaoId") UUID galpaoId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM estoque WHERE estoque_id = :id", nativeQuery = true)
    public void deletarEstoque(@Param("id") UUID id);
}
