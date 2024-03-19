package LearnLLD.LLDPractice.TicTacToe.strategies.GameWinningStretegy;

import LearnLLD.LLDPractice.TicTacToe.Models.Board;
import LearnLLD.LLDPractice.TicTacToe.Models.Cell;
import LearnLLD.LLDPractice.TicTacToe.Models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneWinningStrategy implements GameWinningStretegy{
    List<Map<Character, Integer>> rowsData;
    List<Map<Character, Integer>> colsData;
    Map<Character, Integer> diagonalData;
    Map<Character, Integer> antiDiagonalData;

    public OrderOneWinningStrategy(int dimension) {
        rowsData = new ArrayList<>();
        colsData = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            rowsData.add(new HashMap<>());
            colsData.add(new HashMap<>());
        }
        diagonalData = new HashMap<>();
        antiDiagonalData = new HashMap<>();

    }

    void updateCurSymbols(int row, int col, char symbol) {
        rowsData.get(row).put(symbol, rowsData.get(row).getOrDefault(symbol, 0) + 1);
        colsData.get(col).put(symbol, colsData.get(col).getOrDefault(symbol, 0) + 1);
        if (row == col) {
            diagonalData.put(symbol, diagonalData.getOrDefault(symbol, 0) + 1);
        }
        if (row + col == rowsData.size() - 1) {
            antiDiagonalData.put(symbol, antiDiagonalData.getOrDefault(symbol, 0) + 1);
        }
    }
    @Override
    public boolean checkWinner(Board board, Player lastMovedPlayer, Cell cell) {
        char symbol = lastMovedPlayer.getSymbol();
        int row = cell.getRow();
        int col = cell.getCol();
        int dimension = rowsData.size();
        updateCurSymbols(row, col, symbol);
        if (rowsData.get(row).get(symbol) == dimension || colsData.get(col).get(symbol) == dimension
                || diagonalData.getOrDefault(symbol, 0) == dimension || antiDiagonalData.getOrDefault(symbol, 0) == dimension) {
            return true;
        }

        return false;
    }
}
