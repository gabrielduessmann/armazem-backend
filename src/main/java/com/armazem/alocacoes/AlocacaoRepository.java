package com.armazem.alocacoes;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public interface AlocacaoRepository extends CrudRepository<Alocacao, UUID> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO alocacao (alocacao_id, estoque_id, empresa_id, datainicial, datafinal) VALUES (:id, :estoqueId, :empresaId, :dataInicial, :dataFinal)", nativeQuery = true)
    public void adicionarAlocacao(@Param("id") UUID id, @Param("estoqueId") UUID estoqueId, @Param("empresaId") UUID empresaId, @Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal);

    @Query(
            value = "SELECT CAST(a.alocacao_id AS VARCHAR) AS alocacaoid, CAST(e.empresa_id AS VARCHAR) AS empresaid, CAST(es.estoque_id AS VARCHAR) AS estoqueid, g.nome AS nomegalpao, es.setor AS setorestoque, e.nome AS nomeempresa, a.datainicial, a.datafinal " +
                    "FROM alocacao a \n" +
                    "JOIN empresa e ON a.empresa_id = e.empresa_id\n" +
                    "JOIN estoque es ON a.estoque_id = es.estoque_id \n" +
                    "JOIN galpao g ON es.galpao_id = g.galpao_id",
            nativeQuery = true)
    public ArrayList<Tuple> listarAlocacoes();

    @Query(
            value = "SELECT CAST(a.alocacao_id AS VARCHAR) AS alocacaoid, CAST(e.empresa_id AS VARCHAR) AS empresaid, CAST(es.estoque_id AS VARCHAR) AS estoqueid, g.nome AS nomegalpao, es.setor AS setorestoque, e.nome AS nomeempresa, a.datainicial, a.datafinal " +
                    "FROM alocacao a \n" +
                    "JOIN empresa e ON a.empresa_id = e.empresa_id\n" +
                    "JOIN estoque es ON a.estoque_id = es.estoque_id \n" +
                    "JOIN galpao g ON es.galpao_id = g.galpao_id \n" +
                    "WHERE a.alocacao_id = :id",
            nativeQuery = true)
    public Tuple listarAlocacoesPorId(@Param("id") UUID id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE alocacao SET estoque_id = :estoqueId, empresa_id = :empresaId, datainicial = :dataInicial, datafinal = :dataFinal WHERE alocacao_id = :id", nativeQuery = true)
    public void editarAlocacao(@Param("id") UUID id, @Param("estoqueId") UUID estoqueId, @Param("empresaId") UUID empresaId, @Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM alocacao WHERE alocacao_id = :id", nativeQuery = true)
    public void deletarAlocacao(@Param("id") UUID id);
}
