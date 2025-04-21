# back-condominio Spring-Boot
Projeto Java com os endpoints sobre um possovel sistema de gestão de condominio.

## Stack
* Java 8
* SpringBoot
* Spring Data
* Spring Security
* Lombok
* JUnit

## Banco de Dados
* MySql

### Inserts Iniciais

INSERT INTO condominio.pessoa
(classificacao, cpf, dataNascimento, email, estadoCivil, nome, rg, sexo, situacao)
VALUES('MORADOR', '123123123', '1984-09-27', 'email@email.com', 'CASADO', 'André de Oliveira', '4567897898', 0, 'ATIVO');

INSERT INTO condominio.apartamento_pessoa
(apartamentoId, pessoaId)
VALUES(1, 1);

INSERT INTO condominio.endereco
(bairro, cep, cidade, complemento, numero, pais, rua, tipo, uf, pessoaId)
VALUES('bairro Teste', '09841560', 'Cidade Teste', 'Complemento Teste', '123', 'Brasil', 'Rua teste', 'RESIDENCIAL', 'SP', 1);

INSERT INTO condominio.telefone
(complemento, numero, tipo, pessoaId)
VALUES(NULL, '12312345', 'RESIDENCIAL', 1);


INSERT INTO condominio.perfil  (nome) values('ADMINISTRADOR');
INSERT INTO condominio.usuario (pessoaId, usuario, senha, ultimaAlteracaoSenha, bloqueado) values(1, 'ADMIN', '$2a$10$VOcdhsyXybwe9YsyXcxpWeVnNa2QJKU/l4MMoIhKAQPzhBV7WRO.W', "2020-10-10",0);
INSERT INTO condominio.usuario_perfil (usuario_id , perfis_id ) values(1,1);

INSERT INTO condominio.apartamento (apartamento, bloco) VALUES(11, 'MODERN');
INSERT INTO condominio.apartamento (apartamento, bloco) VALUES(12, 'MODERN');
INSERT INTO condominio.apartamento (apartamento, bloco) VALUES(13, 'MODERN');
INSERT INTO condominio.apartamento (apartamento, bloco) VALUES(14, 'MODERN');
INSERT INTO condominio.apartamento (apartamento, bloco) VALUES(15, 'MODERN');
INSERT INTO condominio.apartamento (apartamento, bloco) VALUES(16, 'MODERN');
INSERT INTO condominio.apartamento (apartamento, bloco) VALUES(11, 'AVANT');
INSERT INTO condominio.apartamento (apartamento, bloco) VALUES(12, 'AVANT');
INSERT INTO condominio.apartamento (apartamento, bloco) VALUES(13, 'AVANT');
INSERT INTO condominio.apartamento (apartamento, bloco) VALUES(14, 'AVANT');
INSERT INTO condominio.apartamento (apartamento, bloco) VALUES(15, 'AVANT');
INSERT INTO condominio.apartamento (apartamento, bloco) VALUES(16, 'AVANT');
