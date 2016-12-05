CREATE TABLE IF NOT EXISTS usuario (
	id integer,
	login varchar(50) NOT NULL UNIQUE,
	senha varchar(50) NOT NULL,
	nome varchar(100) NOT NULL,
	dataNascimento Date NOT NULL,
	rg varchar(10) NOT NULL,
	cpf varchar(11) NOT NULL UNIQUE,
	sexo varchar(1) NOT NULL,
	telefone varchar(11) NOT NULL,
	email varchar(100) NOT NULL UNIQUE,
	id_endereco integer references endereco(id),
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS endereco (
	id integer,
	rua varchar(100) NOT NULL,
	cep varchar(8) NOT NULL,
	bairro varchar(50) NOT NULL,
	numero integer NOT NULL,
	id_usuario integer references usuario(id),
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS usuario_endereco (
	id integer,
	usuario_id integer NOT NULL,
	endereco_id integer NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS recepcionista (
	id integer,
	usuario_id integer NOT NULL,
	codigo varchar(10) NOT NULL UNIQUE,
	PRIMARY KEY(id)
);