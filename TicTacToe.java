package LearnLLD.LLDPractice.TicTacToe;

import LearnLLD.LLDPractice.TicTacToe.Controller.GameController;
import LearnLLD.LLDPractice.TicTacToe.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dimension = getDimensionsFromScanner(sc);
        List<Player> players = getPlayersFromScanner(sc, dimension - 1);

        GameController gameController = new GameController();
        Game game  = gameController.createGame(dimension, players);

        while (gameController.getGameStatus(game) == GameStatus.IN_PROGRESS) {
            gameController.makeMove(game);
        }

        if (gameController.getGameStatus(game) == GameStatus.ENDED && game.getWinner() != null){
            System.out.println("Player " + game.getWinner().getName() + " has won the game");
        } else if (gameController.getGameStatus(game) == GameStatus.DRAW){
            System.out.println("Game is a draw");
        } else {
            System.out.println("Game ended with no result");

        }

    }

    static int getDimensionsFromScanner(Scanner sc) {
        try {
            System.out.println("Enter the dimension of the board as an Integer");
            String s = sc.nextLine();
            int n = Integer.parseInt(s);
            return n;
        } catch (Exception e) {
            System.out.println("Invalid input, pls enter the dimension of the board as an Integer");
            return getDimensionsFromScanner(sc);
        }
    }
    static List<Player> getPlayersFromScanner(Scanner sc, int noOfPlayers) {
        System.out.println("There shound be dimension - 1 players to play the game so pls enter the details of the " +
                "players, there sould be " + noOfPlayers + " Players in your game ");

        List<Player> players = new ArrayList<>();

        System.out.println("Do you want to play with computer? If yes enter y/n ");
        char botPresent = sc.nextLine().charAt(0);
        if (botPresent == 'y') {
            System.out.println("Please Enter the symbol for the computer");
            char symbol = sc.nextLine().charAt(0);
            players.add(new Bot( symbol, "Computer", BotDifficultyLevel.EASY));
            noOfPlayers--;
        }

        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter the name of the player for player number " +  (players.size() + 1));
            String name = sc.nextLine();
            char symbol = getSymbolFromScanner(sc, players);
            players.add(new Player(symbol, name));
        }
        return players;
    }

    static char getSymbolFromScanner(Scanner sc, List<Player> players) {
        System.out.println("Enter the Symbol of the player for player number " + (players.size() + 1));
        char symbol = sc.nextLine().charAt(0);

        while (checkIfSymbolIsAlreadyTaken(players, symbol)) {
            System.out.println("Symbol is already taken, pls enter a different symbol");
            symbol = sc.nextLine().charAt(0);
        }

        return symbol;
    }

    static boolean checkIfSymbolIsAlreadyTaken(List<Player> players, char symbol) {
        for (Player player : players) {
            if (player.getSymbol() == symbol) {
                return true;
            }
        }
        return false;
    }
}
