package LearnLLD.LLDPractice.TicTacToe.Models;

import LearnLLD.LLDPractice.TicTacToe.exceptions.InvalidMoveException;

import java.util.Scanner;

public class Player {
    char symbol;
    String name;
    PlayerType playerType;

    public Player(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    Move decideMove(Board board) throws InvalidMoveException {
        //we can add some condition to check if the row and col is valid or not using board
        Scanner sc = new Scanner(System.in);

        System.out.println("Current Player is : " + this.getName() + " " +
                " Pls Enter Row and column number to place your symbol there ");
        try {
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (row >= board.getDimension() || col >= board.getDimension() || row < 0 || col < 0) {
                throw new InvalidMoveException("Invalid Move pls Enter row and col number between " + 0 + " and " + (board.getDimension() - 1) + " ");
            }
            Cell cell = board.getCellFromBoard(row, col);
            Move move = new Move(cell, this);
            return move;

        } catch (Exception e) {
            throw new InvalidMoveException("Invalid Move pls Enter row and col number between " + 0 + " and " + (board.getDimension() - 1) + " ");
        }


    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
