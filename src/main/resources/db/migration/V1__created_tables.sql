-- Tabela "usuario_cnpj"
CREATE TABLE user_cnpj (
    id VARCHAR(40) PRIMARY KEY,
    cnpj VARCHAR(18) NOT NULL UNIQUE,
    username VARCHAR(20) NOT NULL UNIQUE,
    corporate_reason TEXT NOT NULL,
    last_login DATETIME,
    name_fantasy  TEXT,
    email VARCHAR(255) NOT NULL,
    branch VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    role TEXT NOT NULL
);

-- Tabela "usuario_cpf"
CREATE TABLE user_cpf (
    id VARCHAR(40) PRIMARY KEY,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    username VARCHAR(20) NOT NULL UNIQUE,
    full_name VARCHAR(255) NOT NULL,
    birth_date DATE,
    email VARCHAR(255) NOT NULL,
    branch VARCHAR(255),
    last_login DATETIME,
    password VARCHAR(255) NOT NULL,
    endereco_id VARCHAR(40),
    role TEXT NOT NULL
);

-- Tabela "endereco"
CREATE TABLE address (
    id VARCHAR(40) PRIMARY KEY,
    cep VARCHAR(10) NOT NULL,
    public_place VARCHAR(255) NOT NULL,
    number VARCHAR(10),
    complement VARCHAR(255),
    neighborhood VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(2),
    country VARCHAR(255)
);
