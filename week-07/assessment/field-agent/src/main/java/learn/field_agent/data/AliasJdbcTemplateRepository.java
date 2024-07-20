package learn.field_agent.data;

import learn.field_agent.data.mappers.AliasMapper;
import learn.field_agent.data.mappers.SecurityClearanceMapper;
import learn.field_agent.models.Alias;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AliasJdbcTemplateRepository implements AliasRepository {

    private final JdbcTemplate jdbcTemplate;

    public AliasJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Alias> findByAgent(int agentId) {
        final String sql = """
                select
                security_clearance_id,
                `name` as security_clearance_name
                from security_clearance
                limit 1000;
                """;
        return jdbcTemplate.query(sql, new AliasMapper());
    }

    @Override
    public Alias add(Alias alias) {
        return null;
    }

    @Override
    public boolean update(Alias alias) {
        return false;
    }

    @Override
    public boolean delete(int aliasId) {
        return false;
    }
}
