package LearnLLD.LLDPractice.TicTacToe.Controller;

import LearnLLD.LLDPractice.TicTacToe.Models.Game;
import LearnLLD.LLDPractice.TicTacToe.Models.GameStatus;
import LearnLLD.LLDPractice.TicTacToe.Models.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> Players) {
        return Game.getBuilder().
                setDimension(dimension).
                setPlayers(Players).
                build();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public int getNoOfFilledCells(Game game) {
        return game.getNoOfFilledCells();
    }
}
