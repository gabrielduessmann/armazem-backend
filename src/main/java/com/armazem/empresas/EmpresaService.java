package com.armazem.empresas;

import com.armazem.empresas.dto.EmpresaCriarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public void criarEmpresa(EmpresaCriarDto empresa) {
        empresaRepository.criarEmpresa(UUID.randomUUID(), empresa.cnpj, empresa.nome, empresa.enderecoId);
    }

    public ArrayList<Empresa> listarEmpresas() {
        return empresaRepository.listarEmpresas();
    }

    public void editarEmpresa(UUID id, EmpresaCriarDto empresa) {
        empresaRepository.editarEmpresa(id, empresa.cnpj, empresa.nome, empresa.enderecoId);
    }

    public void deletarEmpresa(UUID id) {
        empresaRepository.deletarEmpresa(id);
    }
}
