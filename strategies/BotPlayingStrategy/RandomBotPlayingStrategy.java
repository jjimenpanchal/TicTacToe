package LearnLLD.LLDPractice.TicTacToe.strategies.BotPlayingStrategy;

import LearnLLD.LLDPractice.TicTacToe.Models.*;
import LearnLLD.LLDPractice.TicTacToe.exceptions.InvalidMoveException;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move decideMove(Board board, Player Player) throws InvalidMoveException {
        // add some time delay to make it look like a human move
        System.out.println(Player.getName() +  " is desiding the Move ....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState() == CellState.EMPTY) {
                    return new Move(cell, Player);
                }
            }
        }

        throw new InvalidMoveException("Bot is not able to decide a move since No empty cell found");
    }
}
