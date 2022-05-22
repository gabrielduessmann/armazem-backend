package com.armazem.empresas;

import com.armazem.empresas.dto.EmpresaCriarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.UUID;

@RestController()
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    private final String EMPRESAS_URL = "empresas";

    @PostMapping(EMPRESAS_URL+"/criar")
    public ResponseEntity<Void> criarEmpresa(@RequestBody EmpresaCriarDto empresa) {
        empresaService.criarEmpresa(empresa);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(EMPRESAS_URL+"/listar")
    public ResponseEntity<ArrayList<Empresa>> listarEmpresas() {
        return ResponseEntity.ok(empresaService.listarEmpresas());
    }

    @GetMapping(EMPRESAS_URL+"/{id}/listar")
    public ResponseEntity<ArrayList<Empresa>> listarEmpresasPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(empresaService.listarEmpresasPorId(id));
    }

    @PostMapping(EMPRESAS_URL+"/{id}/editar")
    public ResponseEntity<Void> editarEmpresa(@PathVariable UUID id, @RequestBody EmpresaCriarDto empresa) {
        empresaService.editarEmpresa(id, empresa);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(EMPRESAS_URL+"{id}/remover")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable UUID id) {
        empresaService.deletarEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
