# 🚗 Sistema Automotivo - Gestão de Estoque de Veículos

API RESTful completa desenvolvida em **Java** com **Spring Boot** e persistência em **MySQL**, acompanhada de interface web estática responsiva para controle e gestão operacional do estoque de automóveis em concessionárias.

Projeto acadêmico desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)** do curso de Análise e Desenvolvimento de Sistemas do Centro Universitário **UniFECAF**.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 25 (OpenJDK)
- **Framework Principal:** Spring Boot 4.1.x
- **Persistência de Dados:** Spring Data JPA / Hibernate
- **Banco de Dados:** MySQL 8.0
- **Driver de Conexão:** MySQL Connector/J
- **Gerenciador de Dependências:** Apache Maven (Wrapper incluso)
- **Front-End Integrado:** HTML5, Bootstrap 5.3, Bootstrap Icons, JavaScript (Fetch API)

---

## 🏛️ Arquitetura do Sistema

A aplicação foi estruturada seguindo o padrão de **4 camadas**, garantindo baixo acoplamento e separação estrita de responsabilidades:

1. **`model`**: Entidades de domínio mapeadas via JPA (`Marca`, `Modelo`, `Veiculo`) e constantes enumeradas (`StatusVeiculo`).
2. **`repository`**: Interfaces de acesso a dados que estendem `JpaRepository`, aplicando consultas derivadas (`findByPlaca`, `findByStatus`).
3. **`service`**: Camada com regras de negócio, validações de unicidade de placa, coerência de anos e preços maiores que zero.
4. **`controller`**: Controladores REST responsáveis pelo tratamento de requisições HTTP e serialização em JSON com injeção de dependências por construtor.
5. **`exception`**: Tratamento centralizado de exceções via `@RestControllerAdvice` (`GlobalExceptionHandler`), padronizando retornos em JSON (`400 Bad Request`, `404 Not Found`).

---

## 📋 Endpoints da API REST

### Marcas (`/api/marcas`)
- `GET /api/marcas`: Lista todas as marcas.
- `GET /api/marcas/{id}`: Busca marca por identificador.
- `POST /api/marcas`: Cadastra nova marca (`{"nome": "Fiat"}`).
- `PUT /api/marcas/{id}`: Atualiza os dados de uma marca.
- `DELETE /api/marcas/{id}`: Remove uma marca.

### Modelos (`/api/modelos`)
- `GET /api/modelos`: Lista todos os modelos.
- `GET /api/modelos/marca/{marcaId}`: Lista modelos de uma fabricante específica.
- `POST /api/modelos/marca/{marcaId}`: Cadastra modelo associado a uma marca.
- `DELETE /api/modelos/{id}`: Remove um modelo.

### Veículos (`/api/veiculos`)
- `GET /api/veiculos`: Lista todo o catálogo de estoque.
- `GET /api/veiculos/{id}`: Busca veículo por ID.
- `GET /api/veiculos/placa/{placa}`: Busca veículo pela placa.
- `POST /api/veiculos/modelo/{modeloId}`: Cadastra veículo associado ao modelo.
- `PATCH /api/veiculos/{id}/status?status=VENDIDO`: Atualiza transição operacional do veículo (`DISPONIVEL`, `VENDIDO`, `EM_MANUTENCAO`).
- `DELETE /api/veiculos/{id}`: Remove um veículo do pátio.

---

## ⚙️ Pré-requisitos para Execução

- **Java JDK 17+** (Desenvolvido e homologado no JDK 25)
- **MySQL Server 8.0+** ativo na porta padrão `3306`
- **Git** instalado

---

## 🚀 Como Executar o Projeto Localmente

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/Leogomezbbfs/Estoque-Veiculos.git](https://github.com/Leogomezbbfs/Estoque-Veiculos.git)
   cd Estoque-Veiculos