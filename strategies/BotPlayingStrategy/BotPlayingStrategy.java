package LearnLLD.LLDPractice.TicTacToe.strategies.BotPlayingStrategy;

import LearnLLD.LLDPractice.TicTacToe.Models.Board;
import LearnLLD.LLDPractice.TicTacToe.Models.Move;
import LearnLLD.LLDPractice.TicTacToe.Models.Player;
import LearnLLD.LLDPractice.TicTacToe.exceptions.InvalidMoveException;

public interface BotPlayingStrategy {
    Move decideMove(Board board, Player Player) throws InvalidMoveException;
}
