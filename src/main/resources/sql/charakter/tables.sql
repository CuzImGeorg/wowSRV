create table reg_user(
	id serial primary key,
	username varchar(30) NOT NULL unique,
	password varchar(30) NOT NULL,
	level int ,
	xp int,
	lastlogon varchar(255),
	createdate varchar(255),
	description varchar(255),
	status varchar(255)

	);
CREATE Table settings(
	ability1 varchar(6),
	ability2 varchar(6),
	ability3 varchar(6),
	ability4 varchar(6)

);



CREATE TABLE character (
	id serial PRIMARY KEY,
	maxHp int,
	ad int,
	ap int,
	description varchar(255),
	klasse varchar(63),
	name varchar(63)
);

CREATE TABLE ability(
	id serial PRIMARY KEY,
	name varchar(31),
	aid int,
	description varchar(255),
	charid int,
	FOREIGN KEY(charid) REFERENCES character(id)
);

CREATE TABLE played(
	id serial PRIMARY KEY,
	userid int,
	charid int,
	games int,
	FOREIGN KEY (userid) REFERENCES reg_user(id),
	FOREIGN KEY (charid) REFERENCES character(id)
);