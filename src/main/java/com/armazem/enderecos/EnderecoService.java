package com.armazem.enderecos;

import com.armazem.galpoes.Galpao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public void criarEndereco(Endereco endereco) {
        enderecoRepository.criarEndereco(UUID.randomUUID(), endereco.getCidade(), endereco.getBairro(), endereco.getRua(), endereco.getNumero(), endereco.getComplemento());
    }

    public ArrayList<Endereco> listarEnderecos() {
        return enderecoRepository.listarEnderecos();
    }

    public void editarEndereco(UUID id, Endereco endereco) {
        enderecoRepository.editarEndereco(id, endereco.getCidade(), endereco.getBairro(), endereco.getRua(), endereco.getNumero(), endereco.getComplemento());
    }


    public void deletarEndereco(UUID id) {
        enderecoRepository.deletarEndereco(id);
    }
}
