package com.gestaoestoque.estoque_veiculos.service;

import com.gestaoestoque.estoque_veiculos.model.Marca;
import com.gestaoestoque.estoque_veiculos.repository.MarcaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<Marca> listarTodas() {
        return marcaRepository.findAll();
    }

    public Marca buscarPorId(Long id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com o ID: " + id));
    }

    public Marca salvar(Marca marca) {
        if (marcaRepository.existsByNomeIgnoreCase(marca.getNome())) {
            throw new RuntimeException("Já existe uma marca cadastrada com o nome: " + marca.getNome());
        }
        return marcaRepository.save(marca);
    }

    public Marca atualizar(Long id, Marca marcaAtualizada) {
        Marca marcaExistente = buscarPorId(id);
        
        if (!marcaExistente.getNome().equalsIgnoreCase(marcaAtualizada.getNome()) &&
            marcaRepository.existsByNomeIgnoreCase(marcaAtualizada.getNome())) {
            throw new RuntimeException("Já existe outra marca com o nome: " + marcaAtualizada.getNome());
        }

        marcaExistente.setNome(marcaAtualizada.getNome());
        return marcaRepository.save(marcaExistente);
    }

    public void deletar(Long id) {
        Marca marca = buscarPorId(id);
        marcaRepository.delete(marca);
    }
}