package models2;

public enum BotDifficulty {
    EASY(1),
    MED(2),
    HARD(3);


    private final int value;

    BotDifficulty(int value) {
        this.value= value;
    }

    public int getValue() {
        return value;
    }
}
