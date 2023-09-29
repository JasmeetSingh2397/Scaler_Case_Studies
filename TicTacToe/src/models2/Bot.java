package models2;

import Strategy2.BotPlayingStrategy;
import Strategy2.EasyBotPlayingStrategy;

public class Bot extends Player{
    private BotDifficulty botDifficulty;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, char symbol, BotDifficulty botDifficulty) {
        super(name, symbol, Player_type.BOT);
        this.botDifficulty = botDifficulty;
        this.botPlayingStrategy = new EasyBotPlayingStrategy();
    }

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }

    public Move decideMove(Board board){
        return botPlayingStrategy.decideMove(this,board);
    }
}
