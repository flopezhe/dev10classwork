package learn.field_agent.data;

import learn.field_agent.models.Alias;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AliasJdbcTemplateRepositoryTest {

    @Autowired
    AliasJdbcTemplateRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state();");
    }

    @Test
    void findAll() {

        List<Alias> aliases = repository.findAll();

        assertNotNull(aliases);
    }



    @Test
    void findByAgentId() {
        List<Alias> alises = repository.findByAgentId(1);

        assertNotNull(alises);
    }

    @Test
    void add() {
        Alias alias = new Alias(1, "TestAliasName", "The alias for test", 1);

        Alias actual = repository.add(alias);

        assertEquals(alias, actual);
    }

    @Test
    void update() {
        Alias alias = new Alias(1, "TestAliasName", "The alias for test", 1);
        alias.setAliasName("GOAT");
        boolean actual = repository.update(alias);

        assertTrue(actual);
    }


    @Test
    void delete() {
        boolean actual = repository.delete(1);

        assertTrue(actual);

    }
}