CREATE TABLE IF NOT EXISTS gestao.congregation (
    id VARCHAR(255),
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    contato VARCHAR(255),
    PRIMARY KEY (id)
);
