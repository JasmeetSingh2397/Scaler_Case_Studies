package models2;

public class Cell {
    private Player player;
    private int rows;
    private int cols;
    private models2.CellState cellstate;

    public Cell( int rows, int cols) {
//        this.player = player;
        this.rows = rows;
        this.cols = cols;
        this.cellstate= models2.CellState.EMPTY;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public models2.CellState getCellstate() {
        return cellstate;
    }

    public void setCellstate(CellState cellstate) {
        this.cellstate = cellstate;
    }
}
