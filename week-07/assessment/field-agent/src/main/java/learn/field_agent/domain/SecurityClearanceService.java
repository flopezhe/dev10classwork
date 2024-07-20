package learn.field_agent.domain;

import learn.field_agent.data.AgencyAgentRepository;
import learn.field_agent.data.AgencyRepository;
import learn.field_agent.data.AgentRepository;
import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.AgencyAgent;
import learn.field_agent.models.SecurityClearance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityClearanceService {

    private final SecurityClearanceRepository repository;


    public SecurityClearanceService(SecurityClearanceRepository repository, AgencyAgentRepository agencyAgentRepository, AgencyRepository agencyRepository, AgentRepository agentRepository) {
        this.repository = repository;

    }

    public SecurityClearance findById(int scId){
        return repository.findById(scId);
    }

    public List<SecurityClearance> findAll(){
        return repository.findAll();
    }

    public int countSc(int scId){
        return repository.CountSc(scId);
    }

    public Result<SecurityClearance> add(SecurityClearance securityClearance){
        Result<SecurityClearance> result = validate(securityClearance);

        if (!result.isSuccess()) {
            return result;
        }

        if (securityClearance.getSecurityClearanceId() != 0) {
            result.addMessage("securityId cannot be set for `add` operation", ResultType.INVALID);
            return result;
        }

        securityClearance = repository.add(securityClearance);
        result.setPayload(securityClearance);
        return result;

    }

    public Result<SecurityClearance> update(SecurityClearance securityClearance){
        Result<SecurityClearance> result = validate(securityClearance);

        if (!result.isSuccess()) {
            return result;
        }

        if (securityClearance.getSecurityClearanceId() <= 0) {
            result.addMessage("securityId must be set for `update` operation", ResultType.INVALID);
            return result;
        }

        if (!repository.update(securityClearance)) {
            String msg = String.format("securityId: %s, not found", securityClearance.getSecurityClearanceId());
            result.addMessage(msg, ResultType.NOT_FOUND);
        }

        return result;
    }
    public Result<?> delete(int scId){
        Result<?> result = new Result<>();
        int count = repository.CountSc(scId);
        if (count > 0) {
            result.addMessage("Can't delete a Security Clearance that is currently in use", ResultType.INVALID);
            return result;
        } else {
            boolean success = repository.delete(scId);
            if (!success) {
                result.addMessage("Error", ResultType.NOT_FOUND);
                return result;
            }
        }

        return result;
    }

    private Result<SecurityClearance> validate(SecurityClearance securityClearance){
        Result<SecurityClearance> result = new Result<>();

        if(securityClearance == null){
            result.addMessage("Security Clearance can't be null.", ResultType.INVALID);
            return result;
        }

        List<SecurityClearance> clearances = repository.findAll();
        for(SecurityClearance s : clearances){
            String names = s.getName();
            if(names.equalsIgnoreCase(securityClearance.getName())){
                result.addMessage("Can't have duplicate names.", ResultType.INVALID);
            }

        }
        if (Validations.isNullOrBlank(securityClearance.getName())){
            result.addMessage("Name is required", ResultType.INVALID);
        }
        return result;
    }
}
