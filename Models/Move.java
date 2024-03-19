package LearnLLD.LLDPractice.TicTacToe.Models;

public class Move {
    Cell cell;
    Player player;

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }
}
