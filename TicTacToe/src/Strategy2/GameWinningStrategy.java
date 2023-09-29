package Strategy2;

import models2.Board;
import models2.Move;

public interface GameWinningStrategy {
    boolean checkWinner(Board board, Move move);
    public void undo_last_move(Move move, Board board);
}
