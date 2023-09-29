package Strategy2;

import models2.Board;
import models2.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements GameWinningStrategy{

    private List<HashMap<Character,Integer>> row_Count_list = new ArrayList<>();
    private List<HashMap<Character,Integer>> col_count_list = new ArrayList<>();

    private HashMap<Character, Integer> leftDiag= new HashMap<>();

    private HashMap<Character, Integer> rightDiag= new HashMap<>();

    public OrderOneGameWinningStrategy(int dimension) {
        for (int i = 0; i < dimension; i++) {
            row_Count_list.add(new HashMap<Character, Integer>());
            col_count_list.add(new HashMap<Character, Integer>());
        }
    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        char symbol= move.getPlayer().getSymbol();
        int row= move.getCell().getRows();
        int col= move.getCell().getCols();
        int dimension = board.getCells().size();

        if(!row_Count_list.get(row).containsKey(symbol)){
            row_Count_list.get(row).put(symbol,0);
        }

        row_Count_list.get(row).put(symbol,row_Count_list.get(row).get(symbol)+1);

        if(!col_count_list.get(col).containsKey(symbol)){
            col_count_list.get(col).put(symbol,0);
        }

        col_count_list.get(col).put(symbol,col_count_list.get(col).get(symbol)+1);

        if(row==col){
            if (!leftDiag.containsKey(symbol)) {
                leftDiag.put(symbol,0);
            }
            leftDiag.put(symbol,leftDiag.get(symbol)+1);
        }
        if(row+col== dimension-1){
            if(!rightDiag.containsKey(symbol)){
                rightDiag.put(symbol,0);
            }
            rightDiag.put(symbol,rightDiag.get(symbol)+1);
        }

        if(row_Count_list.get(row).get(symbol)==dimension|| col_count_list.get(col).get(symbol)==dimension){
            return true;
        }

        if(row==col && leftDiag.get(symbol)==dimension){
            return true;
        }
        if(row+col== (dimension-1) && rightDiag.get(symbol)==dimension){
            return true;
        }
        return false;

    }

    public void undo_last_move(Move move, Board board){
        char symbol= move.getPlayer().getSymbol();
        int row= move.getCell().getRows();
        int col= move.getCell().getCols();
        int dimension = board.getCells().size();


        row_Count_list.get(row).put(symbol,row_Count_list.get(row).get(symbol)-1);

        col_count_list.get(col).put(symbol,col_count_list.get(col).get(symbol)-1);

        if(row==col){

            leftDiag.put(symbol,leftDiag.get(symbol)-1);
        }
        if(row+col== dimension-1){

            rightDiag.put(symbol,rightDiag.get(symbol)-1);
        }


    }
}
