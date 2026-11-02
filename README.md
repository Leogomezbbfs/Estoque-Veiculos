# 🚗 Sistema Automotivo - Gestão de Estoque de Veículos

[![Repositório no GitHub](https://img.shields.io/badge/GitHub-Estoque--Veiculos-181717?style=flat&logo=github)](https://github.com/Leogomezbbfs/Estoque-Veiculos.git)
[![Java](https://img.shields.io/badge/Java-25-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.x-6DB33F?style=flat&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=flat&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3-7952B3?style=flat&logo=bootstrap&logoColor=white)](https://getbootstrap.com/)

> **Link do Repositório:** [https://github.com/Leogomezbbfs/Estoque-Veiculos.git](https://github.com/Leogomezbbfs/Estoque-Veiculos.git)

API RESTful completa desenvolvida em **Java** com **Spring Boot** e persistência relacional em **MySQL**, acompanhada de interface web estática e responsiva para controle e gestão operacional de estoque automotivo em concessionárias[cite: 11, 14].

Projeto acadêmico avaliativo desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)** do curso de Análise e Desenvolvimento de Sistemas do Centro Universitário **UniFECAF**[cite: 7].

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 25 (OpenJDK)[cite: 11]
* **Framework Principal:** Spring Boot 4.1.x[cite: 11, 18]
* **Persistência de Dados:** Spring Data JPA / Hibernate
* **Banco de Dados Relacional:** MySQL Server 8.0[cite: 11]
* **Driver de Conexão:** MySQL Connector/J
* **Gerenciador de Dependências:** Apache Maven (Wrapper incluso)[cite: 15]
* **Front-End Integrado:** HTML5, Bootstrap 5.3, Bootstrap Icons, JavaScript (Fetch API assíncrono)[cite: 11]

---

## 🏛️ Arquitetura do Sistema

A aplicação foi estruturada seguindo o padrão de **4 camadas**, garantindo baixo acoplamento e separação estrita de responsabilidades:

1. **`model`**: Entidades de domínio mapeadas via JPA (`Marca`, `Modelo`, `Veiculo`) e constantes enumeradas (`StatusVeiculo`) com encapsulamento estrito (atributos privados e getters/setters)[cite: 16, 39].
2. **`repository`**: Interfaces de acesso a dados que estendem `JpaRepository`, aplicando polimorfismo de interface e consultas derivadas (`findByPlaca`, `findByStatus`).
3. **`service`**: Camada com regras de negócio, validações de unicidade de placa, coerência de anos e validação de preços maiores que zero[cite: 16].
4. **`controller`**: Controladores REST responsáveis pelo tratamento de requisições HTTP e serialização em JSON com injeção de dependências por construtor[cite: 16].
5. **`exception`**: Tratamento centralizado de exceções via `@RestControllerAdvice` (`GlobalExceptionHandler`), padronizando retornos em JSON (`400 Bad Request`, `404 Not Found`)[cite: 16].

---

## 📋 Endpoints da API REST

### Marcas (`/api/marcas`)
* `GET /api/marcas`: Lista todas as marcas cadastradas.
* `GET /api/marcas/{id}`: Busca marca por identificador.
* `POST /api/marcas`: Cadastra nova fabricante (`{"nome": "Fiat"}`)[cite: 9, 14].
* `PUT /api/marcas/{id}`: Atualiza os dados de uma marca.
* `DELETE /api/marcas/{id}`: Remove uma marca.

### Modelos (`/api/modelos`)
* `GET /api/modelos`: Lista todos os modelos.
* `GET /api/modelos/marca/{marcaId}`: Lista modelos de uma fabricante específica.
* `POST /api/modelos/marca/{marcaId}`: Cadastra modelo associado a uma marca[cite: 9].
* `DELETE /api/modelos/{id}`: Remove um modelo.

### Veículos (`/api/veiculos`)
* `GET /api/veiculos`: Lista todo o inventário em estoque[cite: 9].
* `GET /api/veiculos/{id}`: Busca veículo por ID.
* `GET /api/veiculos/placa/{placa}`: Consulta veículo por placa[cite: 9].
* `POST /api/veiculos/modelo/{modeloId}`: Registra veículo associado ao modelo[cite: 9].
* `PATCH /api/veiculos/{id}/status?status=VENDIDO`: Altera status operacional do veículo (`DISPONIVEL`, `VENDIDO`, `EM_MANUTENCAO`)[cite: 9, 13, 14].
* `DELETE /api/veiculos/{id}`: Remove um veículo do pátio com confirmação[cite: 9].

---

## 🗄️ Estrutura do Banco de Dados (MySQL)

O modelo físico do banco de dados está documentado e disponível para replicação no script [`schema.sql`](./schema.sql), contendo as tabelas:
* **`marcas`**: Chave primária (`id`) e `nome` único.
* **`modelos`**: Chave primária (`id`), `nome` e chave estrangeira (`marca_id` referenciando `marcas`).
* **`veiculos`**: Chave primária (`id`), `placa` única, dados técnicos/financeiros e chave estrangeira (`modelo_id` referenciando `modelos`).

---

## ⚙️ Pré-requisitos para Execução

* **Java JDK 17+** (Desenvolvido e homologado no OpenJDK 25)
* **MySQL Server 8.0+** ativo na porta padrão `3306`
* **Git** instalado

---

## 🚀 Como Executar o Projeto Localmente

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/Leogomezbbfs/Estoque-Veiculos.git](https://github.com/Leogomezbbfs/Estoque-Veiculos.git)
   cd Estoque-Veiculos