package Strategy2;

import models2.*;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move decideMove(Player player, Board board) {
        int size= board.getSize();
        for(int i=0;i<size;i++){
            for(int j=0; j<size;j++){
                if(board.getCells().get(i).get(j).getCellstate().equals(CellState.EMPTY)){
                    return new Move(new Cell(i,j), player);
                }

            }
        }return null;
    }
}
