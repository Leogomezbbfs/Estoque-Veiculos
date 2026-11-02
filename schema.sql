-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS estoque_veiculos;
USE estoque_veiculos;

-- 1. Tabela de Marcas
CREATE TABLE IF NOT EXISTS marcas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- 2. Tabela de Modelos (Relacionada com Marca)
CREATE TABLE IF NOT EXISTS modelos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    marca_id BIGINT NOT NULL,
    CONSTRAINT fk_modelo_marca FOREIGN KEY (marca_id) REFERENCES marcas(id) ON DELETE CASCADE
);

-- 3. Tabela de Veículos (Relacionada com Modelo)
CREATE TABLE IF NOT EXISTS veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(7) NOT NULL UNIQUE,
    ano_fabricacao INT NOT NULL,
    ano_modelo INT NOT NULL,
    cor VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    quilometragem INT NOT NULL,
    status ENUM('DISPONIVEL', 'VENDIDO', 'EM_MANUTENCAO') NOT NULL,
    modelo_id BIGINT NOT NULL,
    CONSTRAINT fk_veiculo_modelo FOREIGN KEY (modelo_id) REFERENCES modelos(id) ON DELETE CASCADE
);

-- Carga inicial de dados para testes
INSERT INTO marcas (id, nome) VALUES 
(1, 'Fiat'), 
(2, 'Toyota');

INSERT INTO modelos (id, nome, marca_id) VALUES 
(1, 'Palio Young', 1), 
(2, 'Etios', 2);

INSERT INTO veiculos (placa, ano_fabricacao, ano_modelo, cor, preco, quilometragem, status, modelo_id) 
VALUES 
('ABC1234', 2001, 2001, 'Cinza', 12500.00, 185000, 'DISPONIVEL', 1),
('FZS3615', 2017, 2017, 'Branco', 35000.00, 30000, 'DISPONIVEL', 2);