package LearnLLD.LLDPractice.TicTacToe.Models;

public class Cell {
    int row, col;
    Player player;
    CellState cellState;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.player = null;
        this.cellState = CellState.EMPTY;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
