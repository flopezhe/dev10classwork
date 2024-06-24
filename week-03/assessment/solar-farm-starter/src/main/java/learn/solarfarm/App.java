package learn.solarfarm;

import learn.solarfarm.*;
import learn.solarfarm.data.SolarPanelFileRepository;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.ui.ConsoleIO;
import learn.solarfarm.ui.Controller;
import learn.solarfarm.ui.View;

import java.io.IOException;
//Row Col Year Material Tracking
//  1   1 2021     A_SI      yes
public class App {

    public static void main(String[] args) {
        SolarPanelFileRepository repository = new SolarPanelFileRepository("./data/solarfarm.txt");
        SolarPanelService service = new SolarPanelService(repository);
        ConsoleIO io = new ConsoleIO();
        View view = new View(io);
        Controller controller = new Controller(view, service);
       try {
           controller.run();
       } catch (Exception ex){ // this doesnt really catch anything but for now leave
           System.out.println("Didnt work");
       }


    }
}
