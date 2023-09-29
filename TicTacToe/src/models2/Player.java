package models2;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private Player_type playerType;

    public Player(String name, char symbol, Player_type playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Player_type getPlayerType() {
        return playerType;
    }

    public void setPlayerType(Player_type playerType) {
        this.playerType = playerType;
    }

    public Move decideMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select the row:");
        int row= sc.nextInt();
        System.out.println("Please select the column:");
        int col= sc.nextInt();

        return new Move(new Cell(row,col),this );

    }
    public void undo(Board board, Move move){
        Scanner sc= new Scanner(System.in);

//        System.out.println("If you wish to undo your move, please press u, if not, please press any other character");
//        String input= sc.next();

        board.remove_last_Move(move);


        }
    }

