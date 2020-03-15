SET GLOBAL time_zone = '+3:00';
create schema if not exists netflix_assinante;
use netflix_assinante;

CREATE TABLE usuario (
  codigo BIGINT  NOT NULL   AUTO_INCREMENT,
  nome VARCHAR(45)  NOT NULL  ,
  email VARCHAR(45)  NOT NULL  ,
  senha VARCHAR(8)  NOT NULL  ,  
PRIMARY KEY(codigo));

CREATE TABLE cliente (
  codigo BIGINT  NOT NULL   AUTO_INCREMENT,
  nome VARCHAR(45)  NOT NULL  ,
  email VARCHAR(45)  NOT NULL  ,
  telefone VARCHAR(20)  NULL  ,
  plano_assinatura SMALLINT  NOT NULL   COMMENT '(1-Padrao;2-HD)'   ,
PRIMARY KEY(codigo));

CREATE TABLE pagamento_cliente (
  codigo BIGINT  NOT NULL   AUTO_INCREMENT,
  cliente_codigo BIGINT  NOT NULL  ,
  codigo_forma_pagamento SMALLINT  NOT NULL   COMMENT '(1-Cartao de credito;2-PayPal)' ,
  data_validade_pagamento DATE  NOT NULL    ,
PRIMARY KEY(codigo)  ,
INDEX Pagamento_Cliente_FKIndex1(cliente_codigo),
  FOREIGN KEY(cliente_codigo)
    REFERENCES cliente(codigo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

CREATE TABLE situacao_cliente_plataforma (
  cliente_codigo BIGINT  NOT NULL  ,
  codigo SMALLINT  NOT NULL   COMMENT '(1-Piloto;2-Pagante;3-Desativado)' ,
  data_ativacao DATE  NOT NULL  ,
  data_desativacao DATE  NULL    ,
PRIMARY KEY(cliente_codigo, codigo, data_ativacao)  ,
INDEX Situacao_Cliente_Plataforma_FKIndex1(cliente_codigo),
  FOREIGN KEY(cliente_codigo)
    REFERENCES cliente(codigo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

CREATE TABLE perfil_cliente (
  codigo BIGINT  NOT NULL   AUTO_INCREMENT,
  cliente_codigo BIGINT  NOT NULL  ,
  nome VARCHAR(45)  NOT NULL  ,
  data_criacao DATE  NOT NULL  ,
  data_exclusao DATE  NULL  ,
  foto BLOB  NULL  ,
  idioma SMALLINT  NOT NULL  ,
  tipo_conteudo_permitido SMALLINT  NOT NULL   COMMENT '(1-Livre;2-12 anos;3-14 anos;4-16 anos;5-Adulto)' ,
  som_ativado_home CHAR(1)  NOT NULL    ,
PRIMARY KEY(codigo)  ,
INDEX Perfil_Cliente_FKIndex1(cliente_codigo),
  FOREIGN KEY(cliente_codigo)
    REFERENCES cliente(codigo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

CREATE TABLE conteudo_perfil_cliente (
  perfil_cliente_codigo BIGINT  NOT NULL  ,
  codigo_conteudo INTEGER  NOT NULL  ,
  favorito CHAR(1)  NOT NULL   COMMENT 'S=Sim;N=Nao' ,
  avaliacao CHAR(1)  NOT NULL   COMMENT 'C=Curtiu;N=Nao curtiu' ,
  timestamp_ultimo_acesso TIMESTAMP  NOT NULL    ,
PRIMARY KEY(perfil_cliente_codigo, codigo_conteudo)  ,
INDEX Conteudo_Perfil_Cliente_FKIndex1(perfil_cliente_codigo),
  FOREIGN KEY(perfil_cliente_codigo)
    REFERENCES perfil_cliente(codigo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

CREATE TABLE historico_pagamento_cliente (
  codigo BIGINT  NOT NULL   AUTO_INCREMENT,
  pagamento_cliente_codigo BIGINT  NOT NULL  ,
  timestamp_uso TIMESTAMP  NOT NULL  ,
  estado_processamento_pagamento SMALLINT  NOT NULL   COMMENT '(1-Incluido;2-Em autorizacao;3-Autorizado;4-Pago)'   ,
PRIMARY KEY(codigo)  ,
INDEX Historico_Pagamento_Cliente_FKIndex1(pagamento_cliente_codigo),
  FOREIGN KEY(pagamento_cliente_codigo)
    REFERENCES pagamento_cliente(codigo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

CREATE TABLE dispositivo_assinante (
  codigo BIGINT  NOT NULL   AUTO_INCREMENT,
  cliente_codigo BIGINT  NOT NULL  ,
  descricao VARCHAR(30)  NULL  ,
  tipo SMALLINT  NULL   COMMENT '(1-Web Browser;2-Celular;3-Tablet;4-Console game)'   ,
PRIMARY KEY(codigo)  ,
INDEX Dispositivo_Assinante_FKIndex1(cliente_codigo),
  FOREIGN KEY(cliente_codigo)
    REFERENCES cliente(codigo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

CREATE TABLE historico_uso_plataforma (
  dispositivo_assinante_codigo BIGINT  NOT NULL  ,
  timestamp_acesso TIMESTAMP  NOT NULL  ,
  endereco_ip_acesso VARCHAR(45)  NOT NULL    ,
PRIMARY KEY(dispositivo_assinante_codigo, timestamp_acesso)  ,
INDEX Historico_Uso_Plataforma_FKIndex1(dispositivo_assinante_codigo),
  FOREIGN KEY(dispositivo_assinante_codigo)
    REFERENCES dispositivo_assinante(codigo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

CREATE TABLE chamado_tecnico (
  protocolo INTEGER  NOT NULL   AUTO_INCREMENT,
  dispositivo_assinante_codigo BIGINT  NOT NULL  ,
  timestamp_abertura TIMESTAMP  NOT NULL  ,
  timestamp_fechamento TIMESTAMP  NULL  ,
  descricao VARCHAR(200)  NOT NULL  ,
  foto BLOB  NULL  ,
  avaliacao CHAR(2)  NULL    ,
PRIMARY KEY(protocolo)  ,
INDEX Chamado_Tecnico_FKIndex1(dispositivo_assinante_codigo),
  FOREIGN KEY(dispositivo_assinante_codigo)
    REFERENCES dispositivo_assinante(codigo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

INSERT INTO `netflix_assinante`.`usuario` (`nome`, `email`, `senha`)
VALUES ('fernando', 'fernando@gmail.com', '12345678');

INSERT INTO `netflix_assinante`.`usuario` (`nome`, `email`, `senha`)
VALUES ('robson', 'robson@gmail.com', '12345678');

INSERT INTO `netflix_assinante`.`usuario` (`nome`, `email`, `senha`)
VALUES ('mariana', 'mariana@gmail.com', '12345678');

INSERT INTO `netflix_assinante`.`usuario` (`nome`, `email`, `senha`)
VALUES ('natalia', 'natalia@gmail.com', '12345678');

INSERT INTO `netflix_assinante`.`cliente` (`nome`, `email`, `telefone`, `plano_assinatura`)
VALUES ('Fernando Ramos da Silva', 'fernandoramos.dev@gmail.com', '11999800861', 2);

INSERT INTO `netflix_assinante`.`cliente` (`nome`, `email`, `telefone`, `plano_assinatura`)
VALUES ('Nathalia Rodrigues', 'nathaliarmoncao@gmail.com', '11123456789', 3);

INSERT INTO `netflix_assinante`.`cliente` (`nome`, `email`, `telefone`, `plano_assinatura`)
VALUES ('Mariana Araujo', 'mariana.araujo.88@gmail.com', '11123456789', 4);

INSERT INTO `netflix_assinante`.`cliente` (`nome`, `email`, `telefone`, `plano_assinatura`)
VALUES ('Robson Ferreira', 'br.robsonferreira@gmail.com', '11123456789', 1);

INSERT INTO `netflix_assinante`.`perfil_cliente` (`cliente_codigo`, `nome`, `data_criacao`,
`idioma`, `tipo_conteudo_permitido`, `som_ativado_home`)
VALUES (1, 'Pai', '2019-02-01', 2, 5 ,'N');

INSERT INTO `netflix_assinante`.`perfil_cliente` (`cliente_codigo`, `nome`, `data_criacao`,
`idioma`, `tipo_conteudo_permitido`, `som_ativado_home`)
VALUES (1, 'Mae', '2019-02-08', 2, 5 ,'S');

INSERT INTO `netflix_assinante`.`perfil_cliente` (`cliente_codigo`, `nome`, `data_criacao`,
`idioma`, `tipo_conteudo_permitido`, `som_ativado_home`)
VALUES (2, 'Maria', '2019-03-10', 2, 3 ,'N');

INSERT INTO `netflix_assinante`.`perfil_cliente` (`cliente_codigo`, `nome`, `data_criacao`,
`idioma`, `tipo_conteudo_permitido`, `som_ativado_home`)
VALUES (3, 'Jose', '2019-04-25', 2, 2 ,'S');

INSERT INTO `netflix_assinante`.`perfil_cliente` (`cliente_codigo`, `nome`, `data_criacao`,
`idioma`, `tipo_conteudo_permitido`, `som_ativado_home`)
VALUES (4, 'Bolinha', '2019-04-28', 2, 1 ,'S');

INSERT INTO `netflix_assinante`.`conteudo_perfil_cliente` (`perfil_cliente_codigo`, 
`codigo_conteudo`, `favorito`, `avaliacao`, `timestamp_ultimo_acesso`)
VALUES (1, 1, 'S','C', '2019-10-21');

INSERT INTO `netflix_assinante`.`conteudo_perfil_cliente` (`perfil_cliente_codigo`, 
`codigo_conteudo`, `favorito`, `avaliacao`, `timestamp_ultimo_acesso`)
VALUES (2, 1, 'N', 'N', '2019-10-10');

INSERT INTO `netflix_assinante`.`conteudo_perfil_cliente` (`perfil_cliente_codigo`, 
`codigo_conteudo`, `favorito`, `avaliacao`, `timestamp_ultimo_acesso`)
VALUES (2, 2, 'S', 'C', '2019-10-10');

INSERT INTO `netflix_assinante`.`situacao_cliente_plataforma` (`cliente_codigo`,
`codigo`, `data_ativacao`)
VALUES (1, 1, '2018-11-30');

INSERT INTO `netflix_assinante`.`situacao_cliente_plataforma` (`cliente_codigo`,
`codigo`, `data_ativacao`)
VALUES (2, 1, '2018-12-20');

INSERT INTO `netflix_assinante`.`situacao_cliente_plataforma` (`cliente_codigo`,
`codigo`, `data_ativacao`)
VALUES (3, 1, '2018-12-26');

INSERT INTO `netflix_assinante`.`pagamento_cliente` (`cliente_codigo`, `codigo_forma_pagamento`, 
`data_validade_pagamento`)
VALUES (1, 1, '2020-02-01');

INSERT INTO `netflix_assinante`.`pagamento_cliente` (`cliente_codigo`, `codigo_forma_pagamento`, 
`data_validade_pagamento`)
VALUES (2, 1, '2020-01-25');

INSERT INTO `netflix_assinante`.`pagamento_cliente` (`cliente_codigo`, `codigo_forma_pagamento`, 
`data_validade_pagamento`)
VALUES (3, 2, '2020-03-10');

INSERT INTO `netflix_assinante`.`pagamento_cliente` (`cliente_codigo`, `codigo_forma_pagamento`, 
`data_validade_pagamento`)
VALUES (4, 1, '2020-03-15');

INSERT INTO `netflix_assinante`.`historico_pagamento_cliente` (`pagamento_cliente_codigo`,
`timestamp_uso`, `estado_processamento_pagamento`)
VALUES 	(1, '2019-02-01 08:10:45', 1);

INSERT INTO `netflix_assinante`.`historico_pagamento_cliente` (`pagamento_cliente_codigo`,
`timestamp_uso`, `estado_processamento_pagamento`)
VALUES 	(1, '2019-02-01 08:11:30', 2);

INSERT INTO `netflix_assinante`.`historico_pagamento_cliente` (`pagamento_cliente_codigo`,
`timestamp_uso`, `estado_processamento_pagamento`)
VALUES 	(1, '2019-02-01 17:00:10', 3);

INSERT INTO `netflix_assinante`.`historico_pagamento_cliente` (`pagamento_cliente_codigo`,
`timestamp_uso`, `estado_processamento_pagamento`)
VALUES 	(1, '2019-02-02 10:010:10', 4);


INSERT INTO `netflix_assinante`.`dispositivo_assinante` (`cliente_codigo`, `descricao`, `tipo`)
VALUES (1, 'Moto G5', 2);
INSERT INTO `netflix_assinante`.`dispositivo_assinante` (`cliente_codigo`, `descricao`, `tipo`)
VALUES (1, 'Nintendo Wii U', 4);

INSERT INTO `netflix_assinante`.`historico_uso_plataforma` (`dispositivo_assinante_codigo`, 
`timestamp_acesso`, `endereco_ip_acesso`)
VALUES (1, '2019-10-21 21:00:00', '201.15.93.45');

INSERT INTO `netflix_assinante`.`historico_uso_plataforma` (`dispositivo_assinante_codigo`, 
`timestamp_acesso`, `endereco_ip_acesso`)
VALUES (2, '2019-10-21 15:30:00', '201.15.93.45');

INSERT INTO `netflix_assinante`.`chamado_tecnico` (`dispositivo_assinante_codigo`,
`timestamp_abertura`, `descricao`)
VALUES (1, '2019-10-21 21:05:58', 'Conexao caindo');

