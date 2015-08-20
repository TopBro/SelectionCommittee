
DROP TABLE registrations;
DROP TABLE certificate_marks;
DROP TABLE vno_marks;
DROP TABLE enrollees;
DROP TABLE users;
DROP TABLE faculties;
DROP TABLE faculty_status;
DROP TABLE statuses;
DROP TABLE states;
DROP TABLE roles;


CREATE TABLE roles(

	id INTEGER NOT NULL, 	
	name VARCHAR(10) NOT NULL UNIQUE,
	PRIMARY KEY (id)
) ENGINE InnoDB CHARACTER SET utf8;

INSERT INTO roles VALUES(1, 'admin');
INSERT INTO roles VALUES(2, 'enrollee');


CREATE TABLE states(

	id INTEGER NOT NULL, 	
	name VARCHAR(10) NOT NULL UNIQUE,
	PRIMARY KEY (id)
) ENGINE InnoDB CHARACTER SET utf8;

INSERT INTO states VALUES(1, 'active');
INSERT INTO states VALUES(2, 'blocked');


CREATE TABLE statuses(

	id INTEGER NOT NULL, 	
	name VARCHAR(15) NOT NULL UNIQUE,
	PRIMARY KEY (id)
) ENGINE InnoDB CHARACTER SET utf8;

INSERT INTO statuses VALUES(1, 'waiting');
INSERT INTO statuses VALUES(2, 'budget');
INSERT INTO statuses VALUES(3, 'contract');
INSERT INTO statuses VALUES(4, 'not_enrolled');

CREATE TABLE faculty_status(

	id INTEGER NOT NULL, 	
	name VARCHAR(15) NOT NULL UNIQUE,
	PRIMARY KEY (id)
) ENGINE InnoDB CHARACTER SET utf8;

INSERT INTO faculty_status VALUES(1, 'open');
INSERT INTO faculty_status VALUES(2, 'closed');

CREATE TABLE faculties(

	id SERIAL, 	
	name VARCHAR(10) NOT NULL UNIQUE,
	budget INTEGER UNSIGNED NOT NULL,
	total INTEGER UNSIGNED NOT NULL,
	faculty_status_id INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (faculty_status_id) REFERENCES faculty_status(id)
	ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE InnoDB CHARACTER SET utf8;

INSERT INTO faculties VALUES(DEFAULT, 'œÃÃ', 90, 200, 1);
INSERT INTO faculties VALUES(DEFAULT, ' Õ', 78, 192, 1);
INSERT INTO faculties VALUES(DEFAULT, ' »”', 83, 185, 1);
INSERT INTO faculties VALUES(DEFAULT, '–“', 102, 210, 1);
INSERT INTO faculties VALUES(DEFAULT, '“ »“', 80, 195, 1);
INSERT INTO faculties VALUES(DEFAULT, '¿ “', 67, 152, 1);
INSERT INTO faculties VALUES(DEFAULT, '›“', 60, 147, 1);


CREATE TABLE users(

	id SERIAL,
	login VARCHAR(10) NOT NULL UNIQUE,
	password VARCHAR(10) NOT NULL,	
	role_id INTEGER NOT NULL,
	PRIMARY KEY (id),	
	FOREIGN KEY (role_id) REFERENCES roles(id)
	ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE InnoDB CHARACTER SET utf8;

INSERT INTO users VALUES(DEFAULT, 'admin', 'admin', 1);
	
CREATE TABLE enrollees(

	id SERIAL,
	user_id BIGINT UNSIGNED NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	middle_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	email VARCHAR(20) NOT NULL,
	city VARCHAR(20) NOT NULL,
	region VARCHAR(20) NOT NULL,
	education VARCHAR(20) NOT NULL,	
	state_id INTEGER NOT NULL,	
	PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES users(id)
	ON DELETE RESTRICT ON UPDATE CASCADE,
	FOREIGN KEY (state_id) REFERENCES states(id)
	ON DELETE RESTRICT ON UPDATE CASCADE	
) ENGINE InnoDB CHARACTER SET utf8;

CREATE TABLE vno_marks(

	id SERIAL,
	user_id BIGINT UNSIGNED NOT NULL,
	ukrainian INTEGER UNSIGNED NOT NULL,
	mathematics INTEGER UNSIGNED NOT NULL,
	physics INTEGER UNSIGNED NOT NULL,		
	PRIMARY KEY (id),	
	FOREIGN KEY (user_id) REFERENCES users(id)
	ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE InnoDB CHARACTER SET utf8;

CREATE TABLE certificate_marks(

	id SERIAL,
	user_id BIGINT UNSIGNED NOT NULL,	
	literature INTEGER UNSIGNED NOT NULL,
	history INTEGER UNSIGNED NOT NULL,
	english INTEGER UNSIGNED NOT NULL,
	informatics INTEGER UNSIGNED NOT NULL,
	geography INTEGER UNSIGNED NOT NULL,
	biology INTEGER UNSIGNED NOT NULL,
	chemistry INTEGER UNSIGNED NOT NULL,	
	PRIMARY KEY (id),	
	FOREIGN KEY (user_id) REFERENCES users(id)
	ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE InnoDB CHARACTER SET utf8;

CREATE TABLE registrations(

	id SERIAL, 	
	user_id BIGINT UNSIGNED NOT NULL,
	faculty_id BIGINT UNSIGNED NOT NULL,
	status_id INTEGER NOT NULL,	
	PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (faculty_id) REFERENCES faculties(id),
	FOREIGN KEY (status_id) REFERENCES statuses(id)
) ENGINE InnoDB CHARACTER SET utf8;