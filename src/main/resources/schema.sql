CREATE TABLE IF NOT EXISTS SPEAKER (
	ID IDENTITY,
	NAME VARCHAR(20) NOT NULL,
	POSITION VARCHAR(10) NOT NULL,
	CREATED_AT TIMESTAMP NOT NULL
);


CREATE TABLE IF NOT EXISTS LECTURE (
	ID IDENTITY,
	TITLE VARCHAR(50) NOT NULL,
	CONTENTS varchar(250) NOT NULL,
	LECTURE_TYPE VARCHAR(15) NOT NULL,
	PUBLISH BIT NOT NULL,
	CREATED_AT TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS LECTURE_SPEAKER (
	LECTURE BIGINT NOT NULL,
	SPEAKER BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS USERS (
	USERNAME VARCHAR(20) NOT NULL,
	PASSWORD VARCHAR(100) NOT NULL,
	ENABLED BIT NOT NULL
);

CREATE TABLE IF NOT EXISTS AUTHORITIES(
	USERNAME VARCHAR(20) NOT NULL,
	AUTHORITY VARCHAR(20) NOT NULL
);