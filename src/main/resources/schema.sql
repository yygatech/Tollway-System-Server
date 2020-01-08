-- CREATE VEHICLE TABLE--

drop table if exists vehicle;

create table if not exists vehicle (
	vehicle_id varchar(255) not null,
	registered boolean,
	toll_tag_id bigint,
	primary key (vehicle_id)
);

-- CREATE GATE TABLE--
drop table if exists gate;

create table if not exists gate (
	gate_id varchar(255) not null,
	toll_in_cents integer,
	primary key (gate_id)
);

-- CREATE TRANSACTION TABLE--
drop sequence if exists transaction_seq;

create sequence if not exists transaction_seq;

drop table if exists transaction;

create table if not exists transaction (
	transaction_id bigint not null, 
	gate_id bigint not null, 
	lane_id integer not null, 
	registered boolean, 
	timestamp timestamp, 
	toll_in_cents integer, 
	toll_tag_id bigint, 
	vehicle_id varchar(255), 
	primary key (transaction_id)
);