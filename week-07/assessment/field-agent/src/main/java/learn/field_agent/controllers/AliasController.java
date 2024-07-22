package learn.field_agent.controllers;

import learn.field_agent.domain.AliasService;
import learn.field_agent.domain.Result;
import learn.field_agent.models.Alias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static learn.field_agent.controllers.ErrorResponse.build;

@RestController
public class AliasController {

    private final AliasService service;

    public AliasController(AliasService service) {
        this.service = service;
    }

    @GetMapping("/alias")
    public List<Alias> findAll(){
        return service.findAll();
    }

    @GetMapping("/alias/{agentId}")
    public List<Alias> findByAgent(@PathVariable int agentId){
        return service.findByAgent(agentId);
    }

    @PostMapping("/alias")
    public ResponseEntity<Object> add(@RequestBody Alias alias){
        Result<Alias> result = service.add(alias);

        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return build(result);
    }

    @PutMapping("/alias/update/{aliasId}")
    public ResponseEntity<Object> update(@PathVariable int aliasId, @RequestBody Alias alias){
        if (aliasId != alias.getAliasId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Result<Alias> result = service.update(alias);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return build(result);
    }

    @DeleteMapping("/alias/delete/{aliasId}")
    public ResponseEntity<Void> delete(@PathVariable int aliasId){
        if (service.delete(aliasId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
