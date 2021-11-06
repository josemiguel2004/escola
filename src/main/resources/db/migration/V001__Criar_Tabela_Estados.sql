CREATE TABLE estado(
    codigo BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    sigla_estado CHAR(2)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO estado (codigo, nome, sigla_estado) VALUES(1, 'Acre','AC');
INSERT INTO estado (codigo, nome, sigla_estado) VALUES(2, 'São Paulo','SP');
INSERT INTO estado (codigo, nome, sigla_estado) VALUES(3, 'Paraná','PR');
INSERT INTO estado (codigo, nome, sigla_estado) VALUES(4, 'Rio de Janeiro','RJ');
INSERT INTO estado (codigo, nome, sigla_estado) VALUES(5, 'Minas Gerais','MG');