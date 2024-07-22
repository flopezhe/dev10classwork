package learn.field_agent.data;

import learn.field_agent.data.mappers.AliasMapper;
import learn.field_agent.models.Alias;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class AliasJdbcTemplateRepository implements AliasRepository {

    private final JdbcTemplate jdbcTemplate;

    public AliasJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Alias> findAll(){
        final String sql = """
                select
                alias_id,
                `name`,
                persona,
                agent_id
                from alias
                limit 1000;
                """;
        return jdbcTemplate.query(sql, new AliasMapper());
    }

    @Override
    public List<Alias> findByAgentId(int agentId) {
        final String sql = """
                select
                a.alias_id,
                a.`name`,
                a.persona,
                i.agent_id,
                i.first_name,
                i.middle_name,
                i.last_name,
                i.dob,
                i.height_in_inches
                from alias a
                inner join agent i on a.agent_id = i.agent_id
                where a.agent_id = ?;
                """;
        return jdbcTemplate.query(sql,new Object[]{agentId}, new AliasMapper());
    }

    @Override
    public Alias add(Alias alias) {

        System.out.println(alias);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("alias")
                .usingGeneratedKeyColumns("alias_id");

        HashMap<String, Object> args = new HashMap<>();
        args.put("name", alias.getAliasName());
        args.put("persona", alias.getPersona());
        args.put("agent_id", alias.getAgent());


        int aliasId = insert.executeAndReturnKey(args).intValue();
        alias.setAliasId(aliasId);
        return alias;
    }

    @Override
    public boolean update(Alias alias) {
        final String sql =
                """
                update alias set
                `name` = ?,
                persona = ?
                where alias_id = ?;
                """;

        return jdbcTemplate.update(sql,alias.getAliasName(),alias.getPersona(),
                alias.getAliasId()) > 0;
    }

    @Override
    public boolean delete(int aliasId) {
        return jdbcTemplate.update("delete from alias where alias_id = ?;", aliasId) > 0;
    }
}
