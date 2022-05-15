package com.armazem.empresas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.UUID;

@RestController("empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @PostMapping("criar")
    public ResponseEntity<Void> criarEmpresa(Empresa empresa) {
        empresaService.criarEmpresa(empresa);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("listar")
    public ResponseEntity<ArrayList<Empresa>> listarEmpresas() {
        return ResponseEntity.ok(empresaService.listarEmpresas());
    }

    @PostMapping("editar")
    public ResponseEntity<Void> editarEmpresa(Empresa empresa) {
        empresaService.editarEmpresa(empresa);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("remover")
    public ResponseEntity<Void> deletarEmpresa(UUID id) {
        empresaService.deletarEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
