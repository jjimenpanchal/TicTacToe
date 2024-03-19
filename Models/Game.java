package LearnLLD.LLDPractice.TicTacToe.Models;
import LearnLLD.LLDPractice.TicTacToe.strategies.GameWinningStretegy.GameWinningStretegy;
import LearnLLD.LLDPractice.TicTacToe.strategies.GameWinningStretegy.OrderOneWinningStrategy;

import java.util.*;
public class Game {
    Board board;
    List<Player> players;
    List<Move> moves;
    GameStatus gameStatus;
    Player winner;
    GameWinningStretegy gameWinningStrategy;
    int nextPlayerIdx = 0;

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    void setBoard(Board board) {
        this.board = board;
    }

    void setPlayers(List<Player> players) {
        this.players = players;
    }

    void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    void setGameWinningStrategy(GameWinningStretegy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public int getNoOfFilledCells() {
        return moves.size();
    }

    public static Builder getBuilder() {
        return new Builder();
    }
    void setNextPlayerIdx(int nextPlayerIdx) {
        this.nextPlayerIdx = nextPlayerIdx;
    }
    public void makeMove () {
        Player player = players.get(nextPlayerIdx);
        try {
            Move move = player.decideMove(board);
            board.addMove(move);
            moves.add(move);
            if (gameWinningStrategy.checkWinner(board, player, move.cell)) {
                gameStatus = GameStatus.ENDED;
                winner = player;
            } else if (getNoOfFilledCells() == board.getTotalCells()) {
                gameStatus = GameStatus.DRAW;
            }
            nextPlayerIdx = (nextPlayerIdx + 1) % players.size();
            board.display();
            System.out.println("Added Move Successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
//            board.display();
            System.out.println("Pls make a valid move again");
            makeMove();
        }
    }

    public static class Builder {
        Board board;
        List<Player> players;
        int dimension;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Game build () {
            Game game = new Game();
            game.setBoard(new Board(this.dimension));
            game.setPlayers(this.players);
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setMoves(new ArrayList<>());
            game.setGameWinningStrategy(new OrderOneWinningStrategy(this.dimension));
            Random random = new Random();
            game.setNextPlayerIdx(random.nextInt(players.size()) );
            return game;
        }

    }

}
