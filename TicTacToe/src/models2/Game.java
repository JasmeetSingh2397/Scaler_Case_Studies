package models2;

import Exceptions.InvalidGameDimensionException;
import Exceptions2.InvalidDimensionException;
import Strategy2.GameWinningStrategy;
import Strategy2.OrderOneGameWinningStrategy;

import javax.management.InvalidAttributeValueException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int nextPlayerIndex;
    private Player winningPlayer;
    private models2.GameStatus gameStatus;

    private GameWinningStrategy gameWinningStrategy;

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public Player getWinningPlayer() {
        return winningPlayer;
    }

    public void setWinningPlayer(Player winningPlayer) {
        this.winningPlayer = winningPlayer;
    }

    public models2.GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public void MakeNextMove(){
        Player playerwhoseMoveItIs= players.get(nextPlayerIndex);
        System.out.println("It is "+playerwhoseMoveItIs.getName()+"'s turn");

        Move move= playerwhoseMoveItIs.decideMove(board);

        int row= move.getCell().getRows();
        int col= move.getCell().getCols();

        if(board.getCells().get(row).get(col).getCellstate().equals(CellState.EMPTY)){
            board.applyMove(move);
            moves.add(move);

            if(gameWinningStrategy.checkWinner(board, move)){
                winningPlayer=playerwhoseMoveItIs;
                gameStatus= GameStatus.ENDED;
//                System.out.println(winningPlayer.getName());
            }
            if(moves.size()==board.getSize()*board.getSize()){
                gameStatus= GameStatus.DRAW;
            }

            playerwhoseMoveItIs.undo(board, move);


            nextPlayerIndex+=1;
            nextPlayerIndex%=players.size();
        }
        else{
            System.out.println("Invalid Move");
        }


    }

    public void askForUndo(){
        Scanner sc= new Scanner(System.in);
        System.out.println("If you wish to undo your move, please press u, else any other character");
        String input= sc.next();
        if(input.charAt(0)=='u'){
            this.undo_Move();
        }
    }
    public void undo_Move(){
        int last_ele= moves.size()-1;

        try {
            this.players.get(nextPlayerIndex).undo(board, moves.get(last_ele));
            moves.remove(last_ele);
            nextPlayerIndex -= 1;
            nextPlayerIndex %= players.size();
            gameWinningStrategy.undo_last_move(moves.get(last_ele),this.board);
        }catch (Exception e){
            System.out.println("Cannot undo, because no move is there.");
        }
    }


    public static class GameBuilder{
        private int dimension;
        private List<Player> players;

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Game build(){
            try{
                is_valid();
            }catch(InvalidDimensionException | InvalidAttributeValueException e){
                System.out.println(e.getMessage());
                return null;
            }
            Game game= new Game();
            game.setBoard(new Board(dimension));
            game.setPlayers(players);
            game.setMoves(new LinkedList<>());
            game.setNextPlayerIndex(0);
            game.setGameStatus(models2.GameStatus.IN_PROGRESS);
            game.setGameWinningStrategy(
                    new OrderOneGameWinningStrategy(dimension));
            return game;

        }

        public boolean is_valid() throws InvalidDimensionException, InvalidAttributeValueException {
            if (dimension<3){
                throw new InvalidDimensionException("Dimensions cannot be less than 3.");

            }
            if(players.size()<2 | players.size()>dimension){
                throw new InvalidAttributeValueException("Players cannot be less than 2 or greater than board size");
            }
            return true;

        }
    }
}
