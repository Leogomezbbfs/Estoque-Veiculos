package com.gestaoestoque.estoque_veiculos.service;

import com.gestaoestoque.estoque_veiculos.model.Marca;
import com.gestaoestoque.estoque_veiculos.model.Modelo;
import com.gestaoestoque.estoque_veiculos.repository.ModeloRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;
    private final MarcaService marcaService;

    public ModeloService(ModeloRepository modeloRepository, MarcaService marcaService) {
        this.modeloRepository = modeloRepository;
        this.marcaService = marcaService;
    }

    public List<Modelo> listarTodos() {
        return modeloRepository.findAll();
    }

    public List<Modelo> listarPorMarca(Long marcaId) {
        marcaService.buscarPorId(marcaId);
        return modeloRepository.findByMarcaId(marcaId);
    }

    public Modelo buscarPorId(Long id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado com o ID: " + id));
    }

    public Modelo salvar(Modelo modelo, Long marcaId) {
        Marca marca = marcaService.buscarPorId(marcaId);

        if (modeloRepository.existsByNomeIgnoreCaseAndMarcaId(modelo.getNome(), marcaId)) {
            throw new RuntimeException("Já existe o modelo " + modelo.getNome() + " para esta marca.");
        }

        modelo.setMarca(marca);
        return modeloRepository.save(modelo);
    }

    public Modelo atualizar(Long id, Modelo modeloAtualizado, Long marcaId) {
        Modelo modeloExistente = buscarPorId(id);
        Marca marca = marcaService.buscarPorId(marcaId);

        modeloExistente.setNome(modeloAtualizado.getNome());
        modeloExistente.setMarca(marca);

        return modeloRepository.save(modeloExistente);
    }

    public void deletar(Long id) {
        Modelo modelo = buscarPorId(id);
        modeloRepository.delete(modelo);
    }
}