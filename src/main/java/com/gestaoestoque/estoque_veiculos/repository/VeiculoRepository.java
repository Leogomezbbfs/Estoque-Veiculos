package com.gestaoestoque.estoque_veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestaoestoque.estoque_veiculos.model.Veiculo;
import com.gestaoestoque.estoque_veiculos.model.StatusVeiculo;
import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Optional<Veiculo> findByPlaca(String placa);

    boolean existsByPlaca(String placa);

    List<Veiculo> findByStatus(StatusVeiculo status);

    List<Veiculo> findByModeloId(Long modeloId);
}