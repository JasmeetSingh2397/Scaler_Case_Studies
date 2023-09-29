package models2;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> cells;

    public Board(int size) {
        this.size = size;
        this.cells = new LinkedList<>();
        for(int i=0; i<size;i++){
            this.cells.add(new LinkedList<>());
            for(int j=0; j<size; j++){
                this.cells.get(i).add(new Cell(i,j));
            }

        }
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void displayBoard(){
        for(int i=0;i<size;i++){
            for(int j=0; j<size;j++){
                if(this.cells.get(i).get(j).getCellstate().equals(CellState.EMPTY)){
                    System.out.print("| |");

                }
                else{
                    System.out.print("|"+cells.get(i).get(j).getPlayer().getSymbol()+"|");
                }

            }System.out.println();
        }
    }
    public void applyMove(Move move){
        int row= move.getCell().getRows();
        int col= move.getCell().getCols();
        this.getCells().get(row).get(col).setCellstate(CellState.OCCUPIED);
        this.getCells().get(row).get(col).setPlayer(move.getPlayer());
    }

    public void remove_last_Move(Move move){
        int row= move.getCell().getRows();
        int col= move.getCell().getCols();
        this.getCells().get(row).get(col).setCellstate(CellState.EMPTY);
        this.getCells().get(row).get(col).setPlayer(null);

    }
}
