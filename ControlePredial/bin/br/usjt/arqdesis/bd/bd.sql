
CREATE DATABASE CONTROLE_PREDIAL DEFAULT CHARACTER SET utf8;

USE CONTROLE_PREDIAL;

CREATE TABLE IF NOT EXISTS USUARIO(
  ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(45) NOT NULL,
  CPF VARCHAR(11) NOT NULL,
  LOGIN VARCHAR(15) NOT NULL,
  SENHA VARCHAR(15) NOT NULL,
  TIPO_USUARIO VARCHAR(1) NOT NULL,
  PRIMARY KEY (ID, CPF),
  UNIQUE KEY (ID, CPF))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS EMPRESA(
  ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
  CNPJ VARCHAR(45) NOT NULL,
  RAZAO_SOCIAL VARCHAR(45) NOT NULL,
  HORARIO_FUNCIONAMENTO TIME NOT NULL,
  TEMPERATURA_MAXIMA_AR INT NOT NULL,
  PRIMARY KEY (ID, CNPJ),
  UNIQUE KEY (ID, CNPJ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SELECT * FROM USUARIO;