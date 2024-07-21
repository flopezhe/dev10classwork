use field_agent_test;

select
*
from alias;

select
a.alias_id,
a.`name`,
a.persona,
ai.agent_id
from alias a
left join agent ai on a.agent_id = ai.agent_id
where a.alias_id = 1;

select
count(security_clearance_id)
from agency_agent
where security_clearance_id = 1;

select *
from agency_agent
where security_clearance_id = 1;