use field_agent;

insert into agency(short_name, long_name)
	values ('NSA', 'National Security Agency');
    
select * from agency;

-- You need to include all values into the insert into
-- insert into agency(long_name)
	-- values('Department of Homeland Security');