package learn.field_agent.controllers;

import learn.field_agent.domain.Result;
import learn.field_agent.domain.SecurityClearanceService;
import learn.field_agent.models.Location;
import learn.field_agent.models.SecurityClearance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecurityClearanceController {

    private final SecurityClearanceService service;

    public SecurityClearanceController(SecurityClearanceService service){
        this.service = service;
    }


    @GetMapping("/security")
    public List<SecurityClearance> findAll(){
        return service.findAll();
    }

    @GetMapping("/{securityId}")
    public SecurityClearance findById(@PathVariable int securityId) {
        return service.findById(securityId);
    }

    @PostMapping("/security")
    public ResponseEntity<Object> add(@RequestBody SecurityClearance securityClearance){
        Result<SecurityClearance> result = service.add(securityClearance);

        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @PutMapping("/{securityId}")
    public ResponseEntity<Object> update(@PathVariable int securityId, @RequestBody SecurityClearance securityClearance){
        if (securityId != securityClearance.getSecurityClearanceId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Result<SecurityClearance> result = service.update(securityClearance);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    }

    @DeleteMapping("/{securityId}")
    public ResponseEntity<Object> delete(@PathVariable int securityId){
        if (service.delete(securityId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
