-- <====> Criação do banco de dados <====>
DROP DATABASE IF EXISTS jmx_bolosDB;
CREATE DATABASE jmx_bolosDB;
USE jmx_bolosDB;

-- <====> INFORMAÇÕES SOBRE USUÁRIOS (CLIENTES E ADMINISTRADORES) <====>

-- Armazena os dados necessários para o gerenciamento dos clientes
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(18),
    cpf CHAR(11) UNIQUE NOT NULL,
    endereco VARCHAR(255) NOT NULL
);
-- Armazena os dados de cada administrador do sistema
CREATE TABLE adm (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    adm_login VARCHAR(30) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL,
    telefone VARCHAR(18)
);


-- <====> INFORMAÇÕES SOBRE OS PRODUTOS <====>

-- Armazena todas as categorias que determinado produto pode ter
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nome_categoria VARCHAR(100) NOT NULL
);
-- Contém as informações importantes sobre um produto
CREATE TABLE produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    data_adicionado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_categoria INT NOT NULL,
    foreign key (id_categoria) references categoria(id_categoria)
);
-- Contém a quantidade de unidades de determinado produto no estoque do sistema
CREATE TABLE estoque (
    id_produto INT PRIMARY KEY,
    quantidade INT NOT NULL,
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);


-- <====> TABELAS RELACIONADAS AO PAGAMENTO <====>

-- <====> MÉTODO DE PAGAMENTO <====>
CREATE TABLE metodo_pagamento( -- Ex: 'Cartão de Crédito', 'Dinheiro'
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50)
);
-- <====> STATUS DE PAGAMENTO <====>
CREATE TABLE status_pagamento( -- Ex: 'Pendente', 'Aprovado', 'Rejeitado'
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50)
);
-- <====> PAGAMENTO <====>
CREATE TABLE pagamento (
    id_pagamento INT AUTO_INCREMENT PRIMARY KEY,
    id_metodo_pagamento INT,
    id_status_pagamento INT, 
    data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_metodo_pagamento) REFERENCES metodo_pagamento(id),
    FOREIGN KEY (id_status_pagamento) REFERENCES status_pagamento(id)
);



-- <====> TABELAS RESPONSÁVEIS PELAS RELAÇÕES ENTRE O PRODUTO E O CLIENTE <====>

-- <====> STATUS DO PEDIDO <====>
CREATE TABLE status_pedido (
    id_status INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL  -- Ex: 'Em andamento', 'Finalizado', 'Cancelado'
);
-- <====> PEDIDOS <====>
CREATE TABLE pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_status INT NOT NULL,
    id_pagamento INT NOT NULL,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id),
    FOREIGN KEY (id_status) REFERENCES status_pedido(id_status),
    FOREIGN KEY (id_pagamento) REFERENCES pagamento(id_pagamento)
);
-- <====> ITENS DO PEDIDO <====>
CREATE TABLE itens_pedido (
    id_item INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);


-- <====> PROCEDIMENTOS ARMAZENADOS PARA FACILITAR A INSERÇÃO DE DADOS <====>

DELIMITER &&
CREATE PROCEDURE inserirDadoEstoque (produto int, quantidade int)
BEGIN
INSERT INTO estoque(id_produto, quantidade) VALUE (produto, quantidade);
END &&
DELIMITER ;

DELIMITER &&
CREATE PROCEDURE selectClienteByCPF(thisCPF CHAR(11))
BEGIN
SELECT * FROM clientes WHERE cpf=thisCPF;
END &&
DELIMITER ;

DELIMITER &&
CREATE PROCEDURE selectAdmByLogin(thisLogin VARCHAR(30))
BEGIN
SELECT * FROM adm WHERE adm_login = thisLogin;
END &&
DELIMITER ;


-- <=====> DEFAULT DATA <====>
INSERT INTO adm (nome, email, adm_login, senha, telefone)
VALUES
('Adm root', 'root.example@email.com', 'root', 'root', '(99) 99999-9999');
