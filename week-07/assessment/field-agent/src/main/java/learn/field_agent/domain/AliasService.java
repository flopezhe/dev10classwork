package learn.field_agent.domain;

import learn.field_agent.data.AliasRepository;
import learn.field_agent.models.Alias;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AliasService {

    private final AliasRepository repository;

    public AliasService(AliasRepository repository) {
        this.repository = repository;
    }

    public List<Alias> findByAgent(int agentId){
        return repository.findByAgentId(agentId);
    }

    public List<Alias> findAll(){
        return repository.findAll();
    }
    public Result<Alias> add(Alias alias){

        Result<Alias> result = validate(alias);

        if (!result.isSuccess()) {
            return result;
        }

        if (alias.getAliasId() != 0) {
            result.addMessage("aliasId cannot be set for `add` operation", ResultType.INVALID);
            return result;
        }

        alias = repository.add(alias);
        result.setPayload(alias);
        return result;
    }

    public Result<Alias> update(Alias alias){

        Result<Alias> result = validate(alias);

        if (!result.isSuccess()) {
            return result;
        }

        if (alias.getAliasId() <= 0) {
            result.addMessage("aliasId must be set for `update` operation", ResultType.INVALID);
            return result;
        }

        if (!repository.update(alias)) {
            String msg = String.format("aliasId: %s, not found", alias.getAliasId());
            result.addMessage(msg, ResultType.NOT_FOUND);
        }

        return result;

    }
    public boolean delete(int aliasId){
        return repository.delete(aliasId);
    }

    private Result<Alias> validate(Alias alias){
        Result<Alias> result = new Result<>();
        if(alias == null){
            result.addMessage("Alias is needed", ResultType.INVALID);
        }



        List<Alias> aliases = repository.findAll();
        for(Alias a : aliases){

            String names = a.getAliasName();
            String personas = a.getPersona();
            if (names.equalsIgnoreCase(alias.getAliasName()) && alias.getPersona() == null){
                result.addMessage("Persona is required", ResultType.INVALID);
            }
            if(names.equalsIgnoreCase(alias.getAliasName()) && personas.equalsIgnoreCase(alias.getPersona())){
                result.addMessage("Personas can't be the same for same alias name", ResultType.INVALID);
            }
        }

        if (Validations.isNullOrBlank(alias.getAliasName())){
            result.addMessage("Name is required", ResultType.INVALID);
        }

        return result;
    }
}
