package com.armazem.estoques;

import com.armazem.estoques.dto.EstoqueCriarDto;
import com.armazem.estoques.dto.EstoqueListarDto;
import com.armazem.estoques.dto.EstoquesDisponiveisListarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    private final String ESTOQUES_URL = "estoques";

    @PostMapping(ESTOQUES_URL+"/criar")
    public ResponseEntity<Void> criarEstoque(@RequestBody EstoqueCriarDto estoque) {
        estoqueService.criarEstoque(estoque);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(ESTOQUES_URL+"/listar")
    public ResponseEntity<ArrayList<EstoqueListarDto>> listarEstoques() {
        return ResponseEntity.ok(estoqueService.listarEstoques());
    }

    @GetMapping(ESTOQUES_URL+"/{id}/listar")
    public ResponseEntity<Estoque> listarEstoquesPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(estoqueService.listarEstoquesPorId(id));
    }

    @GetMapping(ESTOQUES_URL+"/listarDisponiveis")
    public ResponseEntity<ArrayList<EstoquesDisponiveisListarDto>> listarEstoquesDisponiveis() {
        return ResponseEntity.ok(estoqueService.listarEstoquesDisponiveis());
    }

    @PostMapping(ESTOQUES_URL+"/{id}/editar")
    public ResponseEntity<Void> editarEstoque(@PathVariable UUID id, @RequestBody EstoqueCriarDto estoque) {
        estoqueService.editarEstoque(id, estoque);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(ESTOQUES_URL+"/{id}/remover")
    public ResponseEntity<Void> deletarEstoque(@PathVariable UUID id) {
        estoqueService.deletarEstoque(id);
        return ResponseEntity.noContent().build();
    }
}
