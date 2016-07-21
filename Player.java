package teamAgile;

public class Player
{
    String name;
    private int points;
    private int freePlayTokens;

    public Player(String name)
    {
        this.name = name;
        points = 0;
        freePlayTokens = 0;
    }

    // ----------------------------------------------------------
    /**
     * Update Player Points
     * @param pointChange
     */
    public void updatePoints(int pointChange)
    {

    }

    // ----------------------------------------------------------
    /**
     * Update Player Tokens
     * @param tokenChange
     */
    public void updateTokens(int tokenChange)
    {

    }

    // ----------------------------------------------------------
    /**
     * Ask if player wants to use token
     * @return player choice
     */
    public Boolean useToken()
    {
        return true;
    }
}
