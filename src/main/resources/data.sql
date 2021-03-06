-- INSERT USER_ACCOUNTS --
insert into user_account (username, email, password, role, enabled)
	values ('admin', 'admin@ericyao.dev', 'admin', 'ADMIN', true);

insert into user_account (username, email, password, role, enabled)
	values ('user', 'user@ericyao.dev', 'user', 'USER', true);

insert into user_account (username, email, password, role, enabled)
	values ('test', 'test@ericyao.dev', 'test', 'USER', true);

-- INSERT TRANSACTIONS --
insert into vehicle (vehicle_id, registered)
	values ('APTX4869', true);

insert into vehicle (vehicle_id, registered)
	values ('ECI2793', true);

insert into vehicle (vehicle_id, registered)
	values ('ABC3502', false);

-- INSERT GATES --
insert into gate (gate_id, toll_in_cents)
	values (101, 991);
insert into gate (gate_id, toll_in_cents)
	values (102, 992);
insert into gate (gate_id, toll_in_cents)
	values (103, 993);
insert into gate (gate_id, toll_in_cents)
	values (104, 994);
insert into gate (gate_id, toll_in_cents)
	values (105, 995);

-- INSERT TRANSACTIONS --
insert into transaction (gate_id, lane_id, timestamp, toll_in_cents, vehicle_id, transaction_id) 
	values (101, 1, current_timestamp, 99, 'APTX4869', nextval('transaction_seq'));

insert into transaction (gate_id, lane_id, timestamp, toll_in_cents, vehicle_id, transaction_id) 
	values (102, 2, current_timestamp, 999, 'ECI2793', nextval('transaction_seq'));

insert into transaction (gate_id, lane_id, timestamp, toll_in_cents, vehicle_id, transaction_id) 
	values (101, 3, current_timestamp, 99, 'ABC3502', nextval('transaction_seq'));