package learn.boardgames.data;

import learn.boardgames.models.BoardGame;
import learn.boardgames.models.BoardGameWeight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BoardGameFileRepository implements BoardGameRepository {

    private final static String DELIMITER = ",";
    private final static String DELIMITER_REPLACEMENT = "@@@";

    private final String filePath;

    public BoardGameFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<BoardGame> findAll() throws DataAccessException {
        ArrayList<BoardGame> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                // 1,Lunar Rush,7.8,1,4,false,MEDIUM
                BoardGame game = gameFromLine(line);
                if (game != null) {
                    result.add(game);
                }
            }
        } catch (FileNotFoundException e) {
            // pass
        } catch (IOException e) {
            throw new DataAccessException(String.format("Could not read file: %s", filePath), e);
        }
        return result;
    }

    @Override
    public List<BoardGame> findByNumberOfPlayers(int numberOfPlayers) throws DataAccessException {
        ArrayList<BoardGame> result = new ArrayList<>();
        List<BoardGame> all = findAll();
        for (BoardGame game : all) {
            if (numberOfPlayers >= game.getMinimumPlayers() && numberOfPlayers <= game.getMaximumPlayers()) {
                result.add(game);
            }
        }
        return result;
    }

    @Override
    public List<BoardGame> findByTitle(String title) throws DataAccessException {
        ArrayList<BoardGame> result = new ArrayList<>();
        List<BoardGame> all = findAll();
        for (BoardGame game : all) {
            if (game.getTitle().toLowerCase().contains(title.trim().toLowerCase())) {
                result.add(game);
            }
        }
        return result;
    }

    @Override
    public BoardGame findById(int boardGameId) throws DataAccessException {
        List<BoardGame> all = findAll();
        for (BoardGame game : all) {
            if (game.getBoardGameId() == boardGameId) {
                return game;
            }
        }
        return null;
    }

    @Override
    public BoardGame add(BoardGame game) throws DataAccessException {
        List<BoardGame> all = findAll();
        int nextId = getNextId(all);
        game.setBoardGameId(nextId);
        all.add(game);
        writeGamesToFile(all);
        return game;
    }

    @Override
    public boolean update(BoardGame game) throws DataAccessException {
        List<BoardGame> all = findAll();
        for (int index = 0; index < all.size(); index ++) {
            if (all.get(index).getBoardGameId() == game.getBoardGameId()) {
                all.set(index, game);
                writeGamesToFile(all);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(int boardGameId) throws DataAccessException {
        List<BoardGame> all = findAll();
        for (int index = 0; index < all.size(); index ++) {
            if (all.get(index).getBoardGameId() == boardGameId) {
                all.remove(index);
                writeGamesToFile(all);
                return true;
            }
        }
        return false;
    }

    private int getNextId(List<BoardGame> all) {
        int maxId = 0;
        for (BoardGame game : all) {
            maxId = Math.max(game.getBoardGameId(), maxId);
        }
        return maxId + 1;
    }

    private void writeGamesToFile(List<BoardGame> all) throws DataAccessException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.println("boardGameId,title,rating,minimumPlayers,maximumPlayers,checkedOut,weight");
            for (BoardGame game : all) {
                writer.println(gameToLine(game));
            }
        } catch (IOException e) {
            throw new DataAccessException( String.format("Can't write to file: %s", filePath), e);
        }
    }

    private String gameToLine(BoardGame game) {
        StringBuilder builder = new StringBuilder();
        // 1,Lunar Rush,7.8,1,4,false,MEDIUM
        builder.append(game.getBoardGameId()).append(DELIMITER);
        builder.append(cleanString(game.getTitle())).append(DELIMITER);
        builder.append(game.getRating()).append(DELIMITER);
        builder.append(game.getMinimumPlayers()).append(DELIMITER);
        builder.append(game.getMaximumPlayers()).append(DELIMITER);
        builder.append(game.isCheckedOut() ? "true" : "false").append(DELIMITER);
        builder.append(game.getWeight());
        return builder.toString();
    }

    private BoardGame gameFromLine(String line) {
        BoardGame result = null;
        String[] tokens = line.split(DELIMITER);
        if (tokens.length == 7) {
            result = new BoardGame(
                    Integer.parseInt(tokens[0]),
                    restoreString(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Integer.parseInt(tokens[3]),
                    Integer.parseInt(tokens[4]),
                    "true".equals(tokens[5]),
                    BoardGameWeight.valueOf(tokens[6])
            );
        }
        return result;
    }

    private String restoreString(String value) {
        return value.replace(DELIMITER_REPLACEMENT, DELIMITER);
    }

    private String cleanString(String value) {
        return value.replace(DELIMITER, DELIMITER_REPLACEMENT);
    }
}
