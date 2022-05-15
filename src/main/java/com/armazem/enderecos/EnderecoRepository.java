package com.armazem.enderecos;

import com.armazem.galpoes.Galpao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, UUID> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO endereco VALUES (:id, :cidade, :bairro, :rua, :numero, :complemento)", nativeQuery = true)
    public void criarEndereco(@Param("id") UUID id, @Param("cidade") String cidade, @Param("bairro") String bairro, @Param("rua") String rua, @Param("numero") Integer numero, @Param("complemento") String complemento);

    @Query(value = "SELECT * FROM endereco", nativeQuery = true)
    public ArrayList<Endereco> listarEnderecos();

    @Transactional
    @Modifying
    @Query(value = "UPDATE endereco SET cidade = :cidade, bairro = :bairro, rua = :rua, numero = :numero, complemento = :complemento WHERE id = :id", nativeQuery = true)
    public void editarEndereco(@Param("id") UUID id, @Param("cidade") String cidade, @Param("bairro") String bairro, @Param("rua") String rua, @Param("numero") Integer numero, @Param("complemento") String complemento);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM endereco WHERE id = :id", nativeQuery = true)
    public void deletarEndereco(@Param("id") UUID id);
}
