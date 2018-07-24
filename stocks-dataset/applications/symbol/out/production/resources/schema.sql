DROP TABLE IF EXISTS symbols;

CREATE TABLE symbols (
	id int not null auto_increment,
    symbol varchar(32) not null,
    primary key (id)
);

