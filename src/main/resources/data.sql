-- INSERT TRANSACTIONS --
insert into vehicle (vehicle_id, registered, toll_tag_id)
	values ('APTX4869', true, 10001);

insert into vehicle (vehicle_id, registered, toll_tag_id)
	values ('ECI2793', false, 10002);

insert into vehicle (vehicle_id, registered, toll_tag_id)
	values ('CYF2394', true, 10003);

-- INSERT GATES --
insert into gate (gate_id, gate_type)
	values (101, 0);
insert into gate (gate_id, gate_type)
	values (102, 1);

-- INSERT TRANSACTIONS --
insert into transaction (gate_id, gate_type, lane_id, registered, timestamp, toll, toll_tag_id, vehicle_id, transaction_id) 
	values (101, 0, 1, true, current_timestamp, 1.01, 10001, 'APTX4869', nextval('transaction_seq'));

insert into transaction (gate_id, gate_type, lane_id, registered, timestamp, toll, toll_tag_id, vehicle_id, transaction_id) 
	values (102, 1, 2, true, current_timestamp, 1.02, 10002, 'ECI2793', nextval('transaction_seq'));

insert into transaction (gate_id, gate_type, lane_id, registered, timestamp, toll, toll_tag_id, vehicle_id, transaction_id) 
	values (101, 1, 3, false, current_timestamp, 1.03, null, 'ABC3502', nextval('transaction_seq'));