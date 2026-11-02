package com.gestaoestoque.estoque_veiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Modelo> modelos;

    // Construtor padrão (obrigatório para o JPA)
    public Marca() {
    }

    // Construtor completo
    public Marca(Long id, String nome, List<Modelo> modelos) {
        this.id = id;
        this.nome = nome;
        this.modelos = modelos;
    }

    // Getters e Setters (Encapsulamento POO explícito)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }
}