package LearnLLD.LLDPractice.TicTacToe.Models;

import LearnLLD.LLDPractice.TicTacToe.exceptions.InvalidMoveException;
import LearnLLD.LLDPractice.TicTacToe.factories.BotPlayingFactory;
import LearnLLD.LLDPractice.TicTacToe.strategies.BotPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;
    public Bot(char symbol, String name, BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name);
        this.botDifficultyLevel = botDifficultyLevel;
        botPlayingStrategy = BotPlayingFactory.getBotPlayingStrategy(botDifficultyLevel);

    }

    Move decideMove(Board board) throws InvalidMoveException {
        System.out.println("Current Player is : " + this.getName());
        return botPlayingStrategy.decideMove(board, this);
    }
}
