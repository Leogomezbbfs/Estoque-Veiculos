package com.gestaoestoque.estoque_veiculos.controller;

import com.gestaoestoque.estoque_veiculos.model.StatusVeiculo;
import com.gestaoestoque.estoque_veiculos.model.Veiculo;
import com.gestaoestoque.estoque_veiculos.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodos() {
        return ResponseEntity.ok(veiculoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(veiculoService.buscarPorId(id));
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<Veiculo> buscarPorPlaca(@PathVariable String placa) {
        return ResponseEntity.ok(veiculoService.buscarPorPlaca(placa));
    }

    @PostMapping("/modelo/{modeloId}")
    public ResponseEntity<Veiculo> criar(@RequestBody Veiculo veiculo, @PathVariable Long modeloId) {
        Veiculo novoVeiculo = veiculoService.salvar(veiculo, modeloId);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Veiculo> atualizarStatus(@PathVariable Long id, @RequestParam StatusVeiculo status) {
        Veiculo veiculoAtualizado = veiculoService.atualizarStatus(id, status);
        return ResponseEntity.ok(veiculoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        veiculoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}