package com.armazem.enderecos;

import com.armazem.galpoes.Galpao;
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
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    final String ENDERECOS_URL = "enderecos";

    @PostMapping(ENDERECOS_URL+"/criar")
    public ResponseEntity<Void> criarGalpao(@RequestBody Endereco endereco) {
        enderecoService.criarEndereco(endereco);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(ENDERECOS_URL+"/listar")
    public ResponseEntity<ArrayList<Endereco>> listarGalpao() {
        return ResponseEntity.ok(enderecoService.listarEnderecos());
    }

    @PostMapping(ENDERECOS_URL+"/{id}/editar")
    public ResponseEntity<Void> editarGalpao(@PathVariable UUID id, @RequestBody Endereco endereco) {
        enderecoService.editarEndereco(id, endereco);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(ENDERECOS_URL+"/{id}/remover")
    public ResponseEntity<Void> deletarGalpao(@PathVariable UUID id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
