package com.gestaoestoque.estoque_veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestaoestoque.estoque_veiculos.model.Modelo;
import java.util.List;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    List<Modelo> findByMarcaId(Long marcaId);

    boolean existsByNomeIgnoreCaseAndMarcaId(String nome, Long marcaId);
}