-- CREATE USER_ACCOUNT TABLE --
DROP SEQUENCE IF EXISTS user_account_seq CASCADE;

CREATE SEQUENCE IF NOT EXISTS user_account_seq;

drop table if exists user_account;

create table if not exists user_account (
	user_id bigint not null DEFAULT nextval('user_account_seq') PRIMARY KEY,
	username varchar(255) NOT NULL UNIQUE,
	email varchar(255) NOT NULL UNIQUE,
	password varchar(255),
	role varchar(255),
	enabled boolean not null
);

-- CREATE VEHICLE TABLE --

drop table if exists vehicle;

create table if not exists vehicle (
	vehicle_id varchar(255) not null,
	registered boolean,
	primary key (vehicle_id)
);

-- CREATE GATE TABLE --
drop table if exists gate;

create table if not exists gate (
	gate_id bigint not null,
	toll_in_cents integer,
	primary key (gate_id)
);

-- CREATE TRANSACTION TABLE --
drop sequence if exists transaction_seq CASCADE;

create sequence if not exists transaction_seq;

drop table if exists transaction;

create table if not exists transaction (
	transaction_id bigint not null, 
	gate_id bigint not null, 
	lane_id integer not null, 
	timestamp timestamp, 
	toll_in_cents integer, 
	vehicle_id varchar(255), 
	primary key (transaction_id)
);