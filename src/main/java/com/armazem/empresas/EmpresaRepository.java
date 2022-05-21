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
    @Query(value = "INSERT INTO empresa VALUES (:id, :cnpj, :nome, :enderecoId)", nativeQuery = true)
    public void criarEmpresa(@Param("id") UUID id, @Param("cnpj") String cnpj, @Param("nome") String nome, @Param("enderecoId") UUID enderecoId);

    @Query(value = "SELECT * FROM empresa", nativeQuery = true)
    public ArrayList<Empresa> listarEmpresas();

    @Transactional
    @Modifying
    @Query(value = "UPDATE empresa SET cnpj = :cnpj, nome = :nome, endereco_id = :enderecoId WHERE empresa_id = :id", nativeQuery = true)
    public void editarEmpresa(@Param("id") UUID id, @Param("cnpj") String cnpj, @Param("nome") String nome, @Param("enderecoId") UUID enderecoId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM empresa WHERE empresa_id = :id", nativeQuery = true)
    public void deletarEmpresa(@Param("id") UUID id);

}
