package com.armazem.alocacoes;

import com.armazem.empresas.Empresa;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public interface AlocacaoRepository extends CrudRepository<Alocacao, UUID> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO alocacao VALUES (:id, :estoqueId, :empresaId, :dataInicial, :dataFinal)", nativeQuery = true)
    public void adicionarAlocacao(@Param("id") UUID id, @Param("estoqueId") UUID estoqueId, @Param("empresaId") UUID empresaId, @Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal);

    @Query(value = "SELECT * FROM alocacao", nativeQuery = true)
    public ArrayList<Empresa> listarAlocacoes();

    @Transactional
    @Modifying
    @Query(value = "UPDATE alocacao SET estoque_id = :estoqueId, empresa_id = :empresaId, datainicial = :dataInicial, datafinal = :dataFinal WHERE alocacao_id = :id", nativeQuery = true)
    public void editarAlocacao(@Param("id") UUID id, @Param("estoqueId") UUID estoqueId, @Param("empresaId") UUID empresaId, @Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM alocacao WHERE alocacao_id = :id", nativeQuery = true)
    public void deletarAlocacao(@Param("id") UUID id);
}
