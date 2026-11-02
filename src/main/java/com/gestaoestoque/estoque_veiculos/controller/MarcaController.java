package com.gestaoestoque.estoque_veiculos.controller;

import com.gestaoestoque.estoque_veiculos.model.Marca;
import com.gestaoestoque.estoque_veiculos.service.MarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/marcas")
@CrossOrigin(origins = "*")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<List<Marca>> listarTodas() {
        return ResponseEntity.ok(marcaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(marcaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Marca> criar(@RequestBody Marca marca) {
        Marca novaMarca = marcaService.salvar(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMarca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> atualizar(@PathVariable Long id, @RequestBody Marca marca) {
        Marca marcaAtualizada = marcaService.atualizar(id, marca);
        return ResponseEntity.ok(marcaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        marcaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}