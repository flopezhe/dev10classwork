package learn.solarfarm.controllers;

import learn.solarfarm.domain.ResultType;
import learn.solarfarm.domain.SolarPanelResult;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.SolarPanel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// step 7
@RestController
@RequestMapping("/api/panel")
public class SolarPanelController {

    // step 9
    // private final SolarPanelService service;
    private final SolarPanelService service;

    public SolarPanelController(SolarPanelService service) {
        this.service = service;
    }
    // GET /api/panel?section=Hill

    @GetMapping
    public List<SolarPanel> findBySection(@RequestParam String section) {
        return service.findBySection(section);
    }

    @GetMapping("/{section}")
    public List<SolarPanel> findBySectionPath(@PathVariable String section) {
        return service.findBySection(section);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody SolarPanel panel) {
        SolarPanelResult result = service.create(panel);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getSolarPanel(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result.getErrorMessages(), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{panelId}")
    public ResponseEntity<?> update(@PathVariable int panelId, @RequestBody SolarPanel panel) {

        if (panelId != panel.getId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        SolarPanelResult result = service.update(panel);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        if (result.getResultType() == ResultType.NOT_FOUND) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result.getErrorMessages(), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{panelId}")
    public ResponseEntity<?> deleteById(@PathVariable int panelId) {
        SolarPanelResult result = service.deleteById(panelId);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (result.getResultType() == ResultType.NOT_FOUND) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result.getErrorMessages(), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteByKey(@RequestParam String section,
                                         @RequestParam int row,
                                         @RequestParam int column) {

        SolarPanel panel = service.findByKey(section, row, column);
        if(panel  == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        SolarPanelResult result = service.deleteById(panel.getId());
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (result.getResultType() == ResultType.NOT_FOUND) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result.getErrorMessages(), HttpStatus.BAD_REQUEST);
    }
}
