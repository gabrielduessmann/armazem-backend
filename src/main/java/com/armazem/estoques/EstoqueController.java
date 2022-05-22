package com.armazem.estoques;

import com.armazem.estoques.dto.EstoqueCriarDto;
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

@RestController
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    private final String ESTOQUES_URL = "estoques";

    @PostMapping(ESTOQUES_URL+"/criar")
    public ResponseEntity<Void> criarEmpresa(@RequestBody EstoqueCriarDto estoque) {
        estoqueService.criarEstoque(estoque);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(ESTOQUES_URL+"/listar")
    public ResponseEntity<ArrayList<Estoque>> listarEmpresas() {
        return ResponseEntity.ok(estoqueService.listarEstoques());
    }

    @GetMapping(ESTOQUES_URL+"/{id}/listar")
    public ResponseEntity<ArrayList<Estoque>> listarEmpresasPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(estoqueService.listarEstoquesPorId(id));
    }

    @PostMapping(ESTOQUES_URL+"/{id}/editar")
    public ResponseEntity<Void> editarEmpresa(@PathVariable UUID id, @RequestBody EstoqueCriarDto estoque) {
        estoqueService.editarEstoque(id, estoque);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(ESTOQUES_URL+"{id}/remover")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable UUID id) {
        estoqueService.deletarEstoque(id);
        return ResponseEntity.noContent().build();
    }
}
