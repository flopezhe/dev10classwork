package learn.field_agent.domain;

import learn.field_agent.data.AliasRepository;
import learn.field_agent.models.Alias;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AliasServiceTest {

    @Autowired
    AliasService service;

    @MockBean
    AliasRepository repository;

    @Test
    void findByAgent() {
        Alias alias = makeAlias(1);
        List<Alias> expected = new ArrayList<>();
        expected.add(alias);
        when(repository.findByAgentId(1)).thenReturn(expected);

        List<Alias> actual = service.findByAgent(1);
        assertEquals(expected,actual);
    }

    @Test
    void findAll() {
        Alias alias = makeAlias(1);
        List<Alias> expected = new ArrayList<>();
        expected.add(alias);
        when(repository.findAll()).thenReturn(expected);

        List<Alias> actual = service.findAll();

        assertEquals(expected,actual);

    }

    private Alias makeAlias(int aliasId) {
        return new Alias(aliasId, "TestAliasName", "The alias for test", 1);
    }

    @Test
    void add() {
        Alias expected = makeAlias(1);
        expected.setAliasId(0);
        when(repository.add(expected)).thenReturn(makeAlias(1));

        Result<Alias> actual = service.add(expected);
        assertTrue(actual.isSuccess());
    }

    @Test
    void dontAddNullName(){
        Alias alias = new Alias(1, null,null,1);
        alias.setAliasId(0);
        when(repository.add(alias)).thenReturn(alias);
        Result<Alias> actual = service.add(alias);

        assertFalse(actual.isSuccess());
    }

    @Test
    void dontAddIfPersonaMatchesExistingName(){
        Alias aliasOne = new Alias(3, "Test",null,1);
        Alias aliasTwo = new Alias(4, "Test",null,1);
        aliasOne.setAliasId(0);
        aliasTwo.setAliasId(1);
        when(repository.add(aliasOne)).thenReturn(aliasOne);
        when(repository.add(aliasTwo)).thenReturn(aliasTwo);
        Result<Alias> firstActual = service.add(aliasOne);
        Result<Alias> secondActual = service.add(aliasTwo);

        assertTrue(firstActual.isSuccess());
        assertFalse(secondActual.isSuccess());
    }

    @Test
    void update() {
        Alias expected = makeAlias(1);
        expected.setAliasName("NEW NAME");
        when(repository.update(expected)).thenReturn(true);

        Result<Alias> actual = service.update(expected);
        assertTrue(actual.isSuccess());


    }

    @Test
    void delete() {
        Alias expected = makeAlias(1);
        when(repository.delete(1)).thenReturn(true);

        boolean actual = service.delete(1);

        assertTrue(actual);
    }
}