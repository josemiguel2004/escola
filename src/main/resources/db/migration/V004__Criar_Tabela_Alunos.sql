CREATE TABLE aluno(
 codigo BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 nome VARCHAR(100) NOT NULL,
 nome_pai VARCHAR(100),
 nome_mae VARCHAR(100),
 codigo_escola BIGINT,
 FOREIGN KEY (codigo_escola) REFERENCES escola(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO aluno (codigo,nome,nome_pai,nome_mae,codigo_escola) values (1,'Miguel Jose','Carlos Alberto','Rosimeire Albano',1);
INSERT INTO aluno (codigo,nome,nome_pai,nome_mae,codigo_escola) values (2,'Gabriel Soto','Henrique Soto','Ivana Soto',1);
INSERT INTO aluno (codigo,nome,nome_pai,nome_mae,codigo_escola) values (3,'Cleiton Silva','Josnaldo Silva','Maria Silva',4);
INSERT INTO aluno (codigo,nome,nome_pai,nome_mae,codigo_escola) values (4,'Mariana Godoy','Rodrigo Godoy','Kamilly Godoy',2);