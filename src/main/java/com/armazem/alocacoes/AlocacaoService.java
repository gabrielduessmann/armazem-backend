package com.armazem.alocacoes;

import com.armazem.alocacoes.dto.AlocacaoAdicionarDto;
import com.armazem.empresas.Empresa;
import com.armazem.empresas.dto.EmpresaCriarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class AlocacaoService {

    @Autowired
    private AlocacaoRepository alocacaoRepository;

    public void adicionarAlocacao(AlocacaoAdicionarDto alocacao) {
        alocacaoRepository.adicionarAlocacao(UUID.randomUUID(), alocacao.estoqueId, alocacao.empresaId, alocacao.dataInicial, alocacao.dataFinal);
    }

    public ArrayList<Empresa> listarAlocacoes() {
        return alocacaoRepository.listarAlocacoes();
    }

    public void editarAlocacao(UUID id, AlocacaoAdicionarDto alocacao) {
        alocacaoRepository.editarAlocacao(id, alocacao.estoqueId, alocacao.empresaId, alocacao.dataInicial, alocacao.dataFinal);
    }

    public void deletarAlocacao(UUID id) {
        alocacaoRepository.deletarAlocacao(id);
    }
}
