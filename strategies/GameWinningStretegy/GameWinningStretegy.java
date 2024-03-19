package LearnLLD.LLDPractice.TicTacToe.strategies.GameWinningStretegy;

import LearnLLD.LLDPractice.TicTacToe.Models.Board;
import LearnLLD.LLDPractice.TicTacToe.Models.Cell;
import LearnLLD.LLDPractice.TicTacToe.Models.Player;

public interface GameWinningStretegy {

    boolean checkWinner(Board board, Player lastMovedPlayer, Cell cell);

}
