package learn.boardgames;

//import learn.boardgames.data.BoardGameFileRepository;
import learn.boardgames.data.BoardGameJdbcTemplateRepository;
import learn.boardgames.data.BoardGameRepository;
import learn.boardgames.domain.BoardGameService;
import learn.boardgames.ui.Controller;
import learn.boardgames.ui.View;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
    public static void main(String[] args) {
        View view = new View();
//        BoardGameRepository repository = new BoardGameFileRepository("data/boardgames.csv");
        JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
        BoardGameRepository repository = new BoardGameJdbcTemplateRepository(jdbcTemplate);
        BoardGameService service = new BoardGameService(repository);
        Controller controller = new Controller(view, service);
        controller.run();
    }
}
