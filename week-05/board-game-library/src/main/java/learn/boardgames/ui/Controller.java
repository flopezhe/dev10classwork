package learn.boardgames.ui;

import learn.boardgames.data.DataAccessException;
import learn.boardgames.domain.BoardGameService;
import learn.boardgames.domain.Result;
import learn.boardgames.models.BoardGame;

import java.util.List;

public class Controller {

    private final View view;
    private final BoardGameService service;

    public Controller(View view, BoardGameService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        view.displayTitle("Welcome to the Board Game Library");
        boolean exit;
        try {
            do {
                exit = runMenu();
            } while (!exit);
        } catch (DataAccessException e) {
            view.displayErrors(List.of(e.getMessage()));
        }

        view.displayMessage("Bye bye!");
    }

    private boolean runMenu() throws DataAccessException {
        int choice = view.getMenuChoice();

        switch (choice) {
            case 0:
                return true;
            case 1:
                viewAllGames();
                break;
            case 2:
                viewByNumberOfPlayers();
                break;
            case 3:
                addBoardGame();
                break;
            case 4:
                editBoardGame();
                break;
            case 5:
                deleteBoardGame();
                break;
        }
        return false;
    }

    private void viewAllGames() throws DataAccessException {
        view.displayHeader("Board Games");
        List<BoardGame> all = service.findAll();
        view.displayGames(all);
        view.enterToContinue();
    }

    private void viewByNumberOfPlayers() throws DataAccessException {
        int numberOfPlayers = view.readInt("Number of players: ");
        List<BoardGame> games = service.findByNumberOfPlayers(numberOfPlayers);
        view.displayGames(games);
    }

    private void addBoardGame() throws DataAccessException {
        BoardGame game = view.add();
        Result<BoardGame> result = service.add(game);
        if (result.isSuccess()) {
            view.displayMessage(String.format("%s successfully added!", game.getTitle()));
            view.displayMessage("");
        } else {
            view.displayErrors(result.getMessages());
        }
        view.enterToContinue();
    }

    private void editBoardGame() throws DataAccessException {
        String title = view.readString("Filter games by title: ");
        BoardGame game = view.chooseGame(service.findByTitle(title));
        view.editGame(game);
        Result<BoardGame> result = service.update(game);
        if (result.isSuccess()) {
            view.displayMessage(String.format("%s successfully updated!", game.getTitle()));
            view.displayMessage("");
        } else {
            view.displayErrors(result.getMessages());
        }
        view.enterToContinue();
    }

    private void deleteBoardGame() throws DataAccessException {
        String title = view.readString("Filter games by title: ");
        BoardGame game = view.chooseGame(service.findByTitle(title));
        boolean confirmed = view.confirmDelete(game);
        if (confirmed) {
            Result<Void> result = service.deleteById(game.getBoardGameId());
            if (result.isSuccess()) {
                view.displayMessage(String.format("%s successfully deleted!", game.getTitle()));
                view.displayMessage("");
            } else {
                view.displayErrors(result.getMessages());
            }
        }
        view.enterToContinue();
    }
}
