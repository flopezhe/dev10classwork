package learn.field_agent.data.mappers;

import learn.field_agent.models.Alias;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AliasMapper implements RowMapper<Alias> {


    @Override
    public Alias mapRow(ResultSet rs, int rowNum) throws SQLException {
        Alias alias = new Alias();
        alias.setAliasId(rs.getInt("alias_id"));
        alias.setAliasName(rs.getString("name"));
        alias.setPersona(rs.getString("persona"));
        alias.setAgent(rs.getInt("agent_id"));

        return alias;
    }
}
