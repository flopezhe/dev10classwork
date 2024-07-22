package learn.solarfarm.ui;

import learn.solarfarm.domain.SolarPanelResult;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.SolarPanel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final SolarPanelService service;

    public Controller(SolarPanelService service) {

        this.service = service;
    }

    @GetMapping("/test")
    public String getStart(){
        return "Hello, this is working";
    }

    public void run() {

    }

    private void runApp()  {

    }

    private void findSolarPanelsBySection() {

    }

    private void addSolarPanel()  {

    }

    private void updateSolarPanel()  {

    }

    private void deleteSolarPanel() {

    }

    private SolarPanel findSolarPanel()  {

        return new SolarPanel();
    }

}
