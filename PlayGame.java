package teamAgile;

public class PlayGame
{
    private Player[] playerList;
    private int round;
    private String[] wheel;
    private int remainingSpins;

    public PlayGame(Player[] playerList)
    {
        this.playerList = playerList;
        remainingSpins = 50;
        round = 1;
    }

    // ----------------------------------------------------------
    /**
     * Randomly choose an int between 0 and 11 to represent
     * spinning wheel
     * @return wheel segment
     */
    public int spinWheel()
    {
        return 0;
    }

    // ----------------------------------------------------------
    /**
     * Move flow of control to next player
     */
    public void nextPlayer()
    {
    }

    // ----------------------------------------------------------
    /**
     * Get a question from the board
     * @param category to get question from
     */
    public void getQuestion(int category)
    {

    }
}
