package Controller2;

import models2.Game;
import models2.GameStatus;
import models2.Move;
import models2.Player;

import java.util.List;

public class GameController {
    public Game generateGame(int dimension, List<Player> players){
        Game game= Game.getBuilder().setDimension(dimension).setPlayers(players).build();
        return game;
    }
    public models2.GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }
    public String getWinnername(Game game){
        return game.getWinningPlayer().getName();
    }

    public void setGameStatus(Game game, GameStatus gameStatus){
        game.setGameStatus(gameStatus);
    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public void executeNextMove(Game game){
        game.MakeNextMove();

    }
    public void undoMove(Game game){
        game.undo_Move();
    }

    public void askForUndo(Game game){
        game.askForUndo();
    }


}
