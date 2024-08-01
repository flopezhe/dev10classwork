package learn.boardgames.ui;

import learn.boardgames.models.BoardGame;
import learn.boardgames.models.BoardGameWeight;

import java.util.List;
import java.util.Scanner;

public class View {

    private final Scanner console = new Scanner(System.in);

    public void displayTitle(String title) {
        displayHeader(title);
        System.out.println();
    }

    public void displayHeader(String header) {
        System.out.println(header);
        System.out.println("=".repeat(header.length()));
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    private void printMenu() {
        displayHeader("Main Menu");
        System.out.println("1. View all games");
        System.out.println("2. View by number of players");
        System.out.println("3. Add a game");
        System.out.println("4. Edit a game");
        System.out.println("5. Delete a game");
        System.out.println("0. Exit");
    }

    public int getMenuChoice() {
        int choice = -1;
        do {
            printMenu();
            choice = readInt("Choose [0-5]:");
        } while (choice < 0 || choice > 5);
        return choice;
    }

    public void displayGames(List<BoardGame> boardGames) {
        if (boardGames.isEmpty()) {
            displayMessage("No games have been added yet.");
        } else {
            String rowFormat = "| %-20s | %-7s | %-10s |%n";
            System.out.println("-".repeat(47));
            System.out.printf(rowFormat, "Board Game", "Players", "Available?");
            System.out.println("-".repeat(47));
            for (int i = 0; i < boardGames.size(); i++) {
                BoardGame game = boardGames.get(i);
                String numberOfPlayers = String.format("%s-%s", game.getMinimumPlayers(), game.getMaximumPlayers());
                String title = String.format("%s. %s", i+1, game.getTitle());
                System.out.printf(rowFormat, title, numberOfPlayers, game.isCheckedOut() ? "No" : "Yes");
            }
        }
        System.out.println();
    }

    public BoardGame chooseGame(List<BoardGame> boardGames) {
        displayHeader("Choose a Board Game");
        displayGames(boardGames);
        int choice = readInt(String.format("Choose [1-%s]:", boardGames.size()), 1, boardGames.size());
        return boardGames.get(choice - 1);
    }

    public BoardGame add() {
        displayHeader("New Board Game");
        BoardGame result = new BoardGame();
        result.setTitle(readString("Title: "));
        result.setRating(readDouble("Rating: "));
        result.setMinimumPlayers(readInt("Minimum players: "));
        result.setMaximumPlayers(readInt("Maximum players: "));
        result.setCheckedOut(readBoolean("Checked out [y/n]: "));
        result.setWeight(readBoardGameWeight("Weight: "));
        return result;
    }

    public void editGame(BoardGame game) {
        String title = readString(String.format("Title (%s): ", game.getTitle()));
        if (!title.isBlank()) {
            game.setTitle(title);
        }

        String ratingStr;
        double rating = -1;
        do {
            ratingStr = readString(String.format("Rating (%s): ", game.getRating()));
            if (!ratingStr.isBlank()) {
                try {
                    rating = Double.parseDouble(ratingStr);
                    game.setRating(rating);
                } catch (NumberFormatException e) {
                    System.out.println("Rating must be blank or a number 1-10.");
                }
            }
        }
        while(!ratingStr.isBlank() && rating == -1);

        String minPlayersStr;
        int minPlayers = -1;
        do {
            minPlayersStr = readString(String.format("Minimum players (%s): ", game.getMinimumPlayers()));
            if (!minPlayersStr.isBlank()) {
                try {
                    minPlayers = Integer.parseInt(minPlayersStr);
                    game.setMinimumPlayers(minPlayers);
                } catch (NumberFormatException e) {
                    System.out.println("Rating must be blank or a number 1-10.");
                }
            }
        } while(!minPlayersStr.isBlank() && minPlayers == -1);

        String maxPlayersStr;
        int maxPlayers = -1;
        do {
            maxPlayersStr = readString(String.format("Maximum players (%s): ", game.getMaximumPlayers()));
            if (!maxPlayersStr.isBlank()) {
                try {
                    maxPlayers = Integer.parseInt(maxPlayersStr);
                    game.setMinimumPlayers(maxPlayers);
                } catch (NumberFormatException e) {
                    System.out.println("Rating must be blank or a number 1-10.");
                }
            }
        } while(!minPlayersStr.isBlank() && maxPlayers == -1);

        String checkedOut = readString(String.format("Checked out (%s) [y/n]: ", game.isCheckedOut() ? "yes" : "no"));
        if (!checkedOut.isBlank()) {
            game.setCheckedOut(checkedOut.equalsIgnoreCase("y"));
        }

        if (readBoolean(String.format("Weight (%s). Update [y/n]?: ", game.getWeight()))) {
            game.setWeight(readBoardGameWeight(String.format("Weight (%s): ", game.getWeight())));
        }
    }

    public boolean confirmDelete(BoardGame game) {
        displayHeader(String.format("Delete %s? ", game.getTitle()));
        return readBoolean("Really delete? [y/n]:");
    }

    public void displayErrors(List<String> errors) {
        displayHeader("Something went wrong:");
        for (String err : errors) {
            System.out.println(err);
        }
        System.out.println();
    }

    public void enterToContinue() {
        readString("[enter] to continue...");
    }

    public String readString(String prompt) {
        displayMessage(prompt);
        return console.nextLine();
    }

    private boolean readBoolean(String prompt) {
        String result = readString(prompt);
        return result.equalsIgnoreCase("y");
    }

    public int readInt(String prompt) {
        while (true) {
            String value = readString(prompt);
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException ex) {
                System.out.printf("'%s' is not a valid number.%n", value);
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            String value = readString(prompt);
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException ex) {
                System.out.printf("'%s' is not a valid number.%n", value);
            }
        }
    }

    private int readInt(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.printf("Value must be between %s and %s.%n", min, max);
        }
    }

    private BoardGameWeight readBoardGameWeight(String prompt) {
        BoardGameWeight result = BoardGameWeight.CASUAL;
        System.out.println("1. Casual");
        System.out.println("2. Light");
        System.out.println("3. Medium");
        System.out.println("4. Heavy");
        int choice = readInt("Choose [1-4]: ", 1, 4);
        switch (choice) {
            case 1:
                result = BoardGameWeight.CASUAL;
                break;
            case 2:
                result = BoardGameWeight.LIGHT;
                break;
            case 3:
                result = BoardGameWeight.MEDIUM;
                break;
            case 4:
                result = BoardGameWeight.HEAVY;
                break;
        }

        return result;
    }
}
