package learn.field_agent.data;


import learn.field_agent.data.mappers.SecurityClearanceMapper;
import learn.field_agent.models.SecurityClearance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class SecurityClearanceJdbcTemplateRepository implements SecurityClearanceRepository {

    private final JdbcTemplate jdbcTemplate;

    public SecurityClearanceJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SecurityClearance findById(int securityClearanceId) {

        final String sql = """
                select
                security_clearance_id,
                `name` as security_clearance_name
                from security_clearance
                where security_clearance_id = ?;
                """;

        return jdbcTemplate.query(sql, new SecurityClearanceMapper(), securityClearanceId)
                .stream()
                .findFirst().orElse(null);
    }

    @Override
    public List<SecurityClearance> findAll(){
        final String sql = """
                select
                security_clearance_id,
                `name`
                from security_clearance
                limit 1000;
                """;
        return jdbcTemplate.query(sql, new SecurityClearanceMapper());
    }

    @Override
    public SecurityClearance add(SecurityClearance securityClearance){
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("security_clearance")
                .usingGeneratedKeyColumns("security_clearance_id");

        HashMap<String, Object> args = new HashMap<>();
        args.put("name", securityClearance.getName());

        int scId = insert.executeAndReturnKey(args).intValue();
        securityClearance.setSecurityClearanceId(scId);
        return securityClearance;

    }

    @Override
    public boolean update(SecurityClearance securityClearance){
        final String sql =
                """
                update security_clearance set
                `name` = ?
                where security_clearance_id = ?;
                """;

        return jdbcTemplate.update(sql,securityClearance.getName(), securityClearance.getSecurityClearanceId()) > 0;
    }

    @Override
    public boolean delete(int scId){
        jdbcTemplate.update("delete from security_clearance where security_clearance_id = ?;", scId);
        return jdbcTemplate.update("delete from security_clearance where security_clearance_id = ?;", scId) > 0;
    }


}
