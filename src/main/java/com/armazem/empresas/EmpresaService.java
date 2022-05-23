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

    public void criarEmpresa(Empresa empresa) {
        empresaRepository.criarEmpresa(UUID.randomUUID(), empresa.getCnpj(), empresa.getNome());
    }

    public ArrayList<Empresa> listarEmpresas() {
        return empresaRepository.listarEmpresas();
    }

    public ArrayList<Empresa> listarEmpresasPorId(UUID id) {
        return empresaRepository.listarEmpresasPorId(id);
    }

    public void editarEmpresa(UUID id, Empresa empresa) {
        empresaRepository.editarEmpresa(id, empresa.getCnpj(), empresa.getNome());
    }

    public void deletarEmpresa(UUID id) {
        empresaRepository.deletarEmpresa(id);
    }
}
