package learn.boardgames.domain;

import learn.boardgames.data.BoardGameRepository;
import learn.boardgames.data.DataAccessException;
import learn.boardgames.models.BoardGame;

import java.util.List;

public class BoardGameService {

    private final BoardGameRepository boardGameRepository;

    public BoardGameService(BoardGameRepository boardGameRepository) {
        this.boardGameRepository = boardGameRepository;
    }

    public List<BoardGame> findAll() throws DataAccessException {
        return boardGameRepository.findAll();
    }

    public List<BoardGame> findByNumberOfPlayers(int numberOfPlayers) throws DataAccessException {
        return boardGameRepository.findByNumberOfPlayers(2);
    }

    public List<BoardGame> findByTitle(String title) throws DataAccessException {
        return boardGameRepository.findByTitle(title);
    }

    public BoardGame findById(int boardGameId) throws DataAccessException {
        return boardGameRepository.findById(boardGameId);
    }

    public Result<BoardGame> add(BoardGame game) throws DataAccessException {
        Result<BoardGame> result = validate(game);

        if (!result.isSuccess()) {
            return result;
        }

        if (game.getBoardGameId() != 0) {
            result.addMessage("New game must not have id set.");
            return result;
        }

        game = boardGameRepository.add(game);
        result.setPayload(game);
        return result;
    }

    public Result<BoardGame> update(BoardGame game) throws DataAccessException {
        Result<BoardGame> result = validate(game);

        if (!result.isSuccess()) {
            return result;
        }

        if (game.getBoardGameId() <= 0) {
            result.addMessage("Existing game must not have id set.");
            return result;
        }

        if (!boardGameRepository.update(game)) {
            result.addMessage(String.format("Board game %s not found.", game.getBoardGameId()));
        }
        return result;
    }

    public Result<Void> deleteById(int boardGameId) throws DataAccessException {
        Result<Void> result = new Result<>();
        boolean success = boardGameRepository.deleteById(boardGameId);
        if (!success) {
            result.addMessage(String.format("Board game %s not found.", boardGameId));
        }
        return result;
    }

    private Result<BoardGame> validate(BoardGame game) throws DataAccessException {
        Result<BoardGame> result = new Result<>();

        if (game == null) {
            result.addMessage("Board game is required.");
            return result;
        }

        if (game.getTitle() == null || game.getTitle().isBlank()) {
            result.addMessage("Board game title is required.");
        }

        if (game.getRating() < 1 || game.getRating() > 10) {
            result.addMessage("Board game rating must be 1-10.");
        }

        if (game.getMinimumPlayers() < 1 || game.getMinimumPlayers() > 100) {
            result.addMessage("Minimum players must be 1-100.");
        }

        if (game.getMaximumPlayers() < 1 || game.getMaximumPlayers() > 100) {
            result.addMessage("Maximum players must be 1-100.");
        }

        if (game.getMinimumPlayers() > game.getMaximumPlayers()) {
            result.addMessage("Maximum players must be more than minimum players.");
        }

        if (game.getWeight() == null) {
            result.addMessage("Weight is required.");
        }

        if (!result.isSuccess()) {
            return result;
        }

        if (titleIsDuplicate(game)) {
            result.addMessage(String.format("Board game already exists, title: \"%s\"", game.getTitle()));
        }

        return result;
    }

    private boolean titleIsDuplicate(BoardGame game) throws DataAccessException {
        List<BoardGame> all = findAll();
        for (BoardGame existingGame : all) {
            boolean sameGame = game.getBoardGameId() == existingGame.getBoardGameId();
            if (!sameGame && game.getTitle().equals(existingGame.getTitle())) {
                return true;
            }
        }
        return false;
    }
}
