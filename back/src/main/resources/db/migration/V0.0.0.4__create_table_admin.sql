CREATE TABLE IF NOT EXISTS gestao.admin (
    id VARCHAR(255),
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    
    PRIMARY KEY (id)
);
