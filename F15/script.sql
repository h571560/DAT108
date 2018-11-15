set search_path to f15;

create table klasse
(
kode character varying (10),
program character varying(40),
primary key (kode)
);

create table student
(
id character (7),
navn character varying(40),
klasse_kode character varying(10),
primary key (id),
foreign key(klasse_kode) references klasse(kode)
);
INSERT INTO klasse values
('17hData','Dataingeniør'),
('17hInf','Informasjonsteknologi');

INSERT INTO student VALUES
('162456','Arne','17hData'),
('123676','Jonas','17hData'),
('113456','Peder','17hData'),
('133456','Anne','17hData'),
('126456','Anna','17hData');

