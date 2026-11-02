package com.gestaoestoque.estoque_veiculos.controller;

import com.gestaoestoque.estoque_veiculos.model.Modelo;
import com.gestaoestoque.estoque_veiculos.service.ModeloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/modelos")
@CrossOrigin(origins = "*")
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping
    public ResponseEntity<List<Modelo>> listarTodos() {
        return ResponseEntity.ok(modeloService.listarTodos());
    }

    @GetMapping("/marca/{marcaId}")
    public ResponseEntity<List<Modelo>> listarPorMarca(@PathVariable Long marcaId) {
        return ResponseEntity.ok(modeloService.listarPorMarca(marcaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(modeloService.buscarPorId(id));
    }

    @PostMapping("/marca/{marcaId}")
    public ResponseEntity<Modelo> criar(@RequestBody Modelo modelo, @PathVariable Long marcaId) {
        Modelo novoModelo = modeloService.salvar(modelo, marcaId);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoModelo);
    }

    @PutMapping("/{id}/marca/{marcaId}")
    public ResponseEntity<Modelo> atualizar(@PathVariable Long id, @RequestBody Modelo modelo, @PathVariable Long marcaId) {
        Modelo modeloAtualizado = modeloService.atualizar(id, modelo, marcaId);
        return ResponseEntity.ok(modeloAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        modeloService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}