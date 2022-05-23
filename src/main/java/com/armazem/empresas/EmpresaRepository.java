package com.armazem.empresas;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, UUID> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO empresa VALUES (:id, :cnpj, :nome)", nativeQuery = true)
    public void criarEmpresa(@Param("id") UUID id, @Param("cnpj") String cnpj, @Param("nome") String nome);

    @Query(value = "SELECT * FROM empresa", nativeQuery = true)
    public ArrayList<Empresa> listarEmpresas();

    @Query(value = "SELECT * FROM empresa WHERE empresa_id = :id", nativeQuery = true)
    public Empresa listarEmpresasPorId(@Param("id") UUID id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE empresa SET cnpj = :cnpj, nome = :nome WHERE empresa_id = :id", nativeQuery = true)
    public void editarEmpresa(@Param("id") UUID id, @Param("cnpj") String cnpj, @Param("nome") String nome);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM empresa WHERE empresa_id = :id", nativeQuery = true)
    public void deletarEmpresa(@Param("id") UUID id);

}
