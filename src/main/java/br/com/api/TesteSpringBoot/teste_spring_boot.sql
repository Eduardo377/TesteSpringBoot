create database teste_spring_boot;

use teste_spring_boot;

SELECT * FROM usuario;

create table usuario(
	id integer not null auto_increment primary key, 
	nome        varchar(200) not null,
    username    varchar(100) not null,
	email       varchar(50) not null unique, 
	telefone    integer not null, 
    senha       text not null
);

INSERT INTO usuario VALUES
(null, 'Nando', 'Nandinho','nando@exemplo.com', 987654321, '1234'),
(null, 'Ravenna', 'Ravi', 'ravenna@exemplo.com',987654321, '1234'),
(null, 'Eduarda', 'Duda', 'eduarda@exemplo.com',987654321, '1234'),
(null, 'Morgana', 'Mogui Morgui', 'morgana@exemplo.com',987654321, '1234'),
(null, 'Maria', '', 'maria@exemplo.com',987654321, '1234'),
(null, 'Fernandinho', 'Fer', 'fernandinho@exemplo.com',987654321, '1234'),
(null, 'Ragnarok', 'Ragna', 'ragarok@exemplo.com',987654321, '1234');