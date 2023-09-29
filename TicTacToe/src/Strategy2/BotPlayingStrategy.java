package Strategy2;

import models2.Board;
import models2.Move;
import models2.Player;

public interface BotPlayingStrategy {
    public Move decideMove(Player player, Board board);
}
