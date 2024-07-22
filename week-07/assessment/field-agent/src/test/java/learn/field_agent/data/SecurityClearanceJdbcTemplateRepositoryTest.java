package learn.field_agent.data;

import learn.field_agent.models.SecurityClearance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SecurityClearanceJdbcTemplateRepositoryTest {

    @Autowired
    SecurityClearanceJdbcTemplateRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state();");
    }

    @Test
    void shouldFindById() {
        SecurityClearance secret = new SecurityClearance(1, "Secret");
        SecurityClearance topSecret = new SecurityClearance(2, "Top Secret");

        SecurityClearance actual = repository.findById(1);
        assertEquals(secret, actual);

        actual = repository.findById(2);
        assertEquals(topSecret, actual);

        actual = repository.findById(3);
        assertEquals(null, actual);
    }

    @Test
    void findAll() {
        SecurityClearance secret = new SecurityClearance(1, "Secret");
        SecurityClearance topSecret = new SecurityClearance(2, "Top Secret");

        List<SecurityClearance> actual = repository.findAll();
        List<SecurityClearance> expected = new ArrayList<>();
        expected.add(secret);
        expected.add(topSecret);

        assertEquals(expected, actual);

    }

    @Test
    void add() {
        SecurityClearance expected = new SecurityClearance(3, "Test");
        SecurityClearance actual = repository.add(expected);

        assertEquals(expected, actual);
    }

    @Test
    void countScOne() {
        SecurityClearance securityClearance = new SecurityClearance(1, "Secret");

        int actual = repository.CountSc(securityClearance.getSecurityClearanceId());
        int expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    void countScZero(){
        SecurityClearance secret = new SecurityClearance(2, "Top Secret");
        int actual = repository.CountSc(secret.getSecurityClearanceId());
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void update() {
        SecurityClearance securityClearance = repository.findById(2);
        securityClearance.setName("Test time");

        boolean actual = repository.update(securityClearance);

        assertTrue(actual);

    }

    @Test
    void delete() {
        SecurityClearance securityClearance = repository.findById(2);

        boolean actual = repository.delete(securityClearance.getSecurityClearanceId());

        assertTrue(actual);
    }

    @Test
    void shouldNotDelete(){

        boolean actual = repository.delete(3);

        assertFalse(actual);

    }
}