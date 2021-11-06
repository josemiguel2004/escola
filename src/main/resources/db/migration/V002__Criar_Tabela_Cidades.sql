CREATE TABLE cidade(
    codigo BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    codigo_estado BIGINT,
    FOREIGN KEY (codigo_estado) REFERENCES estado(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (1, 'Belo Horizonte', 5);
INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (2, 'Londrina', 3);
INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (3, 'Lençóis Paulista', 2);
INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (4, 'Paraty', 4);
INSERT INTO cidade (codigo, nome, codigo_estado) VALUES (5, 'Rio Branco', 1);