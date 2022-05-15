package com.armazem.galpoes;

import com.armazem.galpoes.dto.GalpaoCriarDto;
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
public class GalpaoController {

    @Autowired
    private GalpaoService galpaoService;

    final String GALPOES_URL = "galpoes";

    @PostMapping(GALPOES_URL+"/criar")
    public ResponseEntity<Void> criarGalpao(@RequestBody GalpaoCriarDto galpao) {
        galpaoService.criarGalpao(galpao);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(GALPOES_URL+"/listar")
    public ResponseEntity<ArrayList<Galpao>> listarGalpoes() {
        return ResponseEntity.ok(galpaoService.listarGalpoes());
    }

    @PostMapping(GALPOES_URL+"/{id}/editar")
    public ResponseEntity<Void> editarGalpao(@PathVariable UUID id, @RequestBody GalpaoCriarDto galpao) {
        galpaoService.editarGalpao(id, galpao);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(GALPOES_URL+"/{id}/remover")
    public ResponseEntity<Void> deletarGalpao(@PathVariable UUID id) {
        galpaoService.deletarGalpao(id);
        return ResponseEntity.noContent().build();
    }
}
