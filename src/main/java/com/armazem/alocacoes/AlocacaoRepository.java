package com.armazem.alocacoes;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AlocacaoRepository extends CrudRepository<Alocacao, UUID> {
}
