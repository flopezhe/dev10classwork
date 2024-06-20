package learnexplorevenus.venus.data;

import learnexplorevenus.venus.models.Orbiter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrbiterFileRepositoryTest {

    private OrbiterFileRepository repository = new OrbiterFileRepository("./data/orbiters.csv");

    @Test
    void shouldFindFiveOrbiters(){
        List<Orbiter> actual = repository.findAll();

        assertNotNull(actual);

        assertEquals(5, actual.size());
    }

//    public Orbiter findBy(int orbiterId){
//
//    }
}