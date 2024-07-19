package learn.solarfarm;

import learn.solarfarm.data.SolarPanelJdbcTemplateRepository;
import learn.solarfarm.data.SolarPanelRepository;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.ui.ConsoleIO;
import learn.solarfarm.ui.Controller;
import learn.solarfarm.ui.View;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
        SolarPanelRepository repository = new SolarPanelJdbcTemplateRepository(jdbcTemplate);
        SolarPanelService service = new SolarPanelService(repository);
        ConsoleIO io = new ConsoleIO();
        View view = new View(io);
        Controller controller = new Controller(view, service);
        controller.run();
    }
}
