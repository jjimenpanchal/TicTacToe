package LearnLLD.LLDPractice.TicTacToe.factories;

import LearnLLD.LLDPractice.TicTacToe.Models.BotDifficultyLevel;
import LearnLLD.LLDPractice.TicTacToe.strategies.BotPlayingStrategy.BotPlayingStrategy;
import LearnLLD.LLDPractice.TicTacToe.strategies.BotPlayingStrategy.RandomBotPlayingStrategy;

public class BotPlayingFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        // we can add more strategies here base on the difficulty level
        if (botDifficultyLevel == BotDifficultyLevel.EASY) {
            return new RandomBotPlayingStrategy();
        } else
            return new RandomBotPlayingStrategy();
    }
}
