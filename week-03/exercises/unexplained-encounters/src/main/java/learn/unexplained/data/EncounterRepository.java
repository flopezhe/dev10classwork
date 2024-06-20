package learn.unexplained.data;

import learn.unexplained.models.Encounter;
import learn.unexplained.models.EncounterType;

import java.util.ArrayList;
import java.util.List;

public interface EncounterRepository {
    List<Encounter> findAll() throws DataAccessException;

    Encounter add(Encounter encounter) throws DataAccessException;
//    public default List<Encounter> findByType(EncounterType ofAGivenType){
//        List<Encounter> testEncounter = new ArrayList<>();
//        return testEncounter;
//
//    };
    boolean deleteById(int encounterId) throws DataAccessException;

    List<Encounter> findByType(EncounterType encounterType);
}
