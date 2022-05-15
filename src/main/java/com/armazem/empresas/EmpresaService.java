package com.armazem.empresas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public void criarEmpresa(Empresa empresa) {
        empresaRepository.criarEmpresa(UUID.randomUUID(), empresa.getCnpj(), empresa.getNome(), empresa.getEndereco());
    }

    public ArrayList<Empresa> listarEmpresas() {
        return empresaRepository.listarEmpresas();
    }

    public void editarEmpresa(Empresa empresa) {
        empresaRepository.editarEmpresa(UUID.randomUUID(), empresa.getCnpj(), empresa.getNome(), empresa.getEndereco());
    }


    public void deletarEmpresa(UUID id) {
        empresaRepository.deletarEmpresa(id);
    }
}
