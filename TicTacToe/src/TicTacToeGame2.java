import Controller2.GameController;
import models2.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame2 {
    public static void main(String[] args) {
        System.out.println("Hello World. welcome to Tic Tac Toe");
        Scanner sc= new Scanner(System.in);

        System.out.println("What is the size of the board");
        int dimension= sc.nextInt();

        System.out.println("No. of Players");
        int num_Players= sc.nextInt();

        System.out.println("Will there be a bot: y/n");
        String s= sc.next();

        List<Player> players= new LinkedList<>();

        if (s.charAt(0)=='y'){
            num_Players-=1;
            System.out.println("What will be the name of the bot?");
            String botname= sc.next();

            System.out.println("Bot Symbol?");
            String symbol= sc.next();

            System.out.println("Difficulty level of the bot : 1.EASY, 2.MEDIUM, 3.HARD ");
            int difficulty= sc.nextInt();

            players.add(new Bot(botname,symbol.charAt(0), BotDifficulty.EASY));

        }

        for(int i=0;i<num_Players;i++){
            System.out.println("What is the name of Player: "+(i+1));
            String player_Name= sc.next();

            System.out.println("What is the symbol of Player: "+(i+1));
            String symbol= sc.next();

            players.add(new Player(player_Name,symbol.charAt(0),Player_type.HUMAN));

        }
        GameController gameController= new Controller2.GameController();
        Game game= gameController.generateGame(dimension, players);

        while(gameController.getGameStatus(game)==(GameStatus.IN_PROGRESS)){
//            Scanner sc= new Scanner(System.in);
            System.out.println("Current Board:");
            gameController.displayBoard(game);
            gameController.executeNextMove(game);
            gameController.askForUndo(game);
//            System.out.println("If you wish to undo your move, please press u, else any other character");
//            String input= sc.next();



        }
        if(game.getGameStatus()==GameStatus.DRAW){
            System.out.println("Game has drawn");
        }
        else{
            gameController.displayBoard(game);
            System.out.println("Game has been won by: "+gameController.getWinnername(game));
        }

    }
}
