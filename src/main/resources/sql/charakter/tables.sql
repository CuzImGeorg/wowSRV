CREATE TABLE reg_user(
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
    id serial primary key,
    userid int,
	ability1 int,
	ability2 int,
	ability3 int,
	ability4 int,

    FOREIGN KEY (userid) REFERENCES reg_user(id)
);



CREATE TABLE charakter (
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
	cd int,
	description varchar(255),
	charid int,
	FOREIGN KEY(charid) REFERENCES charakter(id)
);

CREATE TABLE played(
	id serial PRIMARY KEY,
	charid int,
	games int,
	wins int,
	statsid int,
	FOREIGN KEY (charid) REFERENCES charakter(id),
    FOREIGN KEY (statsid) REFERENCES stats(id)

);

CREATE TABLE stats(
    	id serial PRIMARY KEY,
        userid int,
        hoursplayed int,
        minutesplayed int,
        kills int,
        deaths int,

        FOREIGN KEY (userid) REFERENCES reg_user(id)

);

CREATE TABLE usernamehistory(
        id serial PRIMARY KEY,
        userid int,
        changed int,
        dateandtime varchar(255),
        username varchar(30)  NOT NULL,
        FOREIGN KEY (userid) REFERENCES reg_user(id)

);

CREATE TABLE passwordhistory(
        id serial PRIMARY KEY,
        userid int,
        changed int,
        dateandtime varchar(255),
        newpassword varchar(30)  NOT NULL,
        FOREIGN KEY (userid) REFERENCES reg_user(id)

);

CREATE TABLE fightlog(
        id serial PRIMARY KEY,
        userid int,
        mate1 int,
        mate2 int,
        enemy1 int,
        enemy2 int,
        enemy3 int,
        won boolean,
        userchar int,
        matechar1 int,
        matechar2 int,
        enemychar1 int,
        enemychar2 int,
        enemychar3 int,
        kills int,
        survived boolean,
        gameduration varchar(15),
        dateandtime varchar(31),

        FOREIGN KEY (userid) REFERENCES reg_user(id),
        FOREIGN KEY (mate1) REFERENCES reg_user(id),
        FOREIGN KEY (mate2) REFERENCES reg_user(id),
        FOREIGN KEY (enemy1) REFERENCES reg_user(id),
        FOREIGN KEY (enemy2) REFERENCES reg_user(id),
        FOREIGN KEY (enemy3) REFERENCES reg_user(id),

        FOREIGN KEY (userchar) REFERENCES charakter(id),
        FOREIGN KEY (matechar1) REFERENCES charakter(id),
        FOREIGN KEY (matechar2) REFERENCES charakter(id),
        FOREIGN KEY (enemychar1) REFERENCES charakter(id),
        FOREIGN KEY (enemychar2) REFERENCES charakter(id),
        FOREIGN KEY (enemychar3) REFERENCES charakter(id)
);