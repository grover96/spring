DROP TABLE IF EXISTS stocks;

CREATE TABLE stocks (
	id int not null auto_increment,
    symbol varchar(32) not null,
    price float not null,
    volume bigint not null,
    date date,
    primary key (id)
);

