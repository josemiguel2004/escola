create table escola(
    codigo BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(100),
    codigo_cidade BIGINT,
    FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO escola (codigo,nome,telefone,codigo_cidade) values (1,'Etec cidade do Livro','32634589',3);
INSERT INTO escola (codigo,nome,telefone,codigo_cidade) values (2,'Faculdade Federal do Paraná','32650023',2);
INSERT INTO escola (codigo,nome,telefone,codigo_cidade) values (3,'Centro educacional de Minas Gerais','996124587',1);
INSERT INTO escola (codigo,nome,telefone,codigo_cidade) values (4,'Escola Estadual Emilio Matarazo','32557842',5);