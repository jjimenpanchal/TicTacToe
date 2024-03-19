package LearnLLD.LLDPractice.TicTacToe.Models;

import LearnLLD.LLDPractice.TicTacToe.exceptions.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;
public class Board {
    List<List<Cell>> board;

    Board(int dimension) {
        board = new ArrayList<>();
        for (int row = 0; row < dimension; row++) {
            board.add(new ArrayList<>());
            for (int col = 0; col < dimension; col++) {
                board.get(row).add(new Cell(row, col));
            }
        }
    }

    public void addMove(Move move) throws InvalidMoveException {
        Cell cell = move.cell;
        int row = cell.getRow();
        int col = cell.getCol();
        Player player = move.player;
        if (board.get(row).get(col).getCellState() == CellState.EMPTY) {
            board.get(row).get(col).setPlayer(player);
            board.get(row).get(col).setCellState(CellState.FILLED);
        } else {
            throw new InvalidMoveException("Cell is already filled");
        }
    }

    Cell getCellFromBoard(int row, int col) {
        return board.get(row).get(col);
    }

    void display() {
        for (List<Cell> row : board) {
            for (Cell cell : row) {
                if (cell.getCellState() == CellState.EMPTY) {
                    System.out.print("   " + "  |  ");
                } else {
                    System.out.print("  " + cell.getPlayer().getSymbol() + "  |  ");
                }
            }
            System.out.println();
        }
    }

    int getDimension() {
        return board.size();
    }

    int getTotalCells() {
        return board.size() * board.size();
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

}
