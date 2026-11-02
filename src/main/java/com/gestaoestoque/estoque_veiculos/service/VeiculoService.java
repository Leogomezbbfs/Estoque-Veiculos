package com.gestaoestoque.estoque_veiculos.service;

import com.gestaoestoque.estoque_veiculos.model.Modelo;
import com.gestaoestoque.estoque_veiculos.model.StatusVeiculo;
import com.gestaoestoque.estoque_veiculos.model.Veiculo;
import com.gestaoestoque.estoque_veiculos.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ModeloService modeloService;

    public VeiculoService(VeiculoRepository veiculoRepository, ModeloService modeloService) {
        this.veiculoRepository = veiculoRepository;
        this.modeloService = modeloService;
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com o ID: " + id));
    }

    public Veiculo buscarPorPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa.toUpperCase())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com a placa: " + placa));
    }

    public Veiculo salvar(Veiculo veiculo, Long modeloId) {
        String placaFormatada = veiculo.getPlaca().toUpperCase().trim();

        if (veiculoRepository.existsByPlaca(placaFormatada)) {
            throw new RuntimeException("Já existe um veículo cadastrado com a placa: " + placaFormatada);
        }

        if (veiculo.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("O preço do veículo deve ser maior que zero.");
        }

        if (veiculo.getAnoFabricacao() > veiculo.getAnoModelo()) {
            throw new RuntimeException("O ano de fabricação não pode ser superior ao ano do modelo.");
        }

        Modelo modelo = modeloService.buscarPorId(modeloId);

        veiculo.setPlaca(placaFormatada);
        veiculo.setModelo(modelo);

        if (veiculo.getStatus() == null) {
            veiculo.setStatus(StatusVeiculo.DISPONIVEL);
        }

        return veiculoRepository.save(veiculo);
    }

    public Veiculo atualizarStatus(Long id, StatusVeiculo novoStatus) {
        Veiculo veiculo = buscarPorId(id);
        veiculo.setStatus(novoStatus);
        return veiculoRepository.save(veiculo);
    }

    public void deletar(Long id) {
        Veiculo veiculo = buscarPorId(id);
        veiculoRepository.delete(veiculo);
    }
}