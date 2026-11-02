package com.gestaoestoque.estoque_veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestaoestoque.estoque_veiculos.model.Marca;
import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    Optional<Marca> findByNomeIgnoreCase(String nome);

    boolean existsByNomeIgnoreCase(String nome);
}