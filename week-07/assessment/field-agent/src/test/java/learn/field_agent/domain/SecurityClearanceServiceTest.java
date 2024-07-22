package learn.field_agent.domain;

import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.SecurityClearance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class SecurityClearanceServiceTest {

    @Autowired
    SecurityClearanceService service;

    @MockBean
    SecurityClearanceRepository repository;

    @Test
    void findById() {
        SecurityClearance expected = makeSecurityClearance(1);
        when(repository.findById(1)).thenReturn(expected);

        SecurityClearance actual = service.findById(1);
        assertEquals(expected,actual);

    }

    private SecurityClearance makeSecurityClearance(int scId) {
        SecurityClearance securityClearance = new SecurityClearance();
        securityClearance.setSecurityClearanceId(scId);
        securityClearance.setName("Random");
        return securityClearance;
    }

    @Test
    void findAll() {
        SecurityClearance sc = makeSecurityClearance(1);
        List<SecurityClearance> expected = new ArrayList<>();
        expected.add(sc);
        when(repository.findAll()).thenReturn(expected);

        List<SecurityClearance> actual = service.findAll();

        assertEquals(expected,actual);

    }

//    @Test
//    void countSc() {
//
//
//
//    }

    @Test
    void add() {
        SecurityClearance sc = makeSecurityClearance(1);
        sc.setSecurityClearanceId(0);
        when(repository.add(any())).thenReturn(makeSecurityClearance(1));

        Result<SecurityClearance> actual = service.add(sc);

        assertTrue(actual.isSuccess());
    }

    @Test
    void dontAddNullName(){
        SecurityClearance sc = new SecurityClearance(3, null);

        Result<SecurityClearance> actual = service.add(sc);

        assertFalse(actual.isSuccess());
    }

    @Test
    void shouldNotAddDuplicateName(){
        SecurityClearance first = makeSecurityClearance(3);
        service.add(first);
        SecurityClearance second = makeSecurityClearance(4);
        Result<SecurityClearance> actual = service.add(second);

        assertFalse(actual.isSuccess());
    }


    @Test
    void update() {
        SecurityClearance sc = makeSecurityClearance(1);
        sc.setName("New Name");
        when(repository.update(any())).thenReturn(true);

        Result<SecurityClearance> actual = service.update(sc);

        assertTrue(actual.isSuccess());

    }

    @Test
    void shouldNotUpdateNullName(){
        SecurityClearance sc = makeSecurityClearance(1);
        sc.setName(null);
        when(repository.update(any())).thenReturn(true);

        Result<SecurityClearance> actual = service.update(sc);

        assertFalse(actual.isSuccess());
    }

    @Test
    void delete() {
        when(repository.delete(anyInt())).thenReturn(true);
        Result<?> actual = service.delete(1);

        assertTrue(actual.isSuccess());
    }
}