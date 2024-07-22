package learn.field_agent.data;

import learn.field_agent.models.SecurityClearance;

import java.util.List;

public interface SecurityClearanceRepository {
    SecurityClearance findById(int securityClearanceId);

    List<SecurityClearance> findAll();

    boolean update(SecurityClearance securityClearance);

    boolean delete(int scId);

     SecurityClearance add(SecurityClearance securityClearance);

    int CountSc(int scId);
}
