package teamAgile;

public class Player
{
    private String name;
    private int[] points;
    private int freePlayTokens;

    public Player(String name)
    {
        this.name = name;
        points = new int[2];
        points[0] = 0;
        points[1] = 0;
        freePlayTokens = 0;
    }

    // ----------------------------------------------------------
    /**
     * Update Player Points
     * @param pointChange
     * @param round
     */
    public void updatePoints(int pointChange, int round)
    {
        points[round] += pointChange;
    }

    // ----------------------------------------------------------
    /**
     * Lose all points for round
     * @param round
     */
    public void bankrupt(int round)
    {
        points[round - 1] = 0;
    }

    // ----------------------------------------------------------
    /**
     * Update Player Tokens
     */
    public void addToken()
    {
        freePlayTokens++;
    }

    // ----------------------------------------------------------
    /**
     * Ask if player wants to use token
     * @return player choice
     */
    public Boolean useToken()
    {
        //TODO Prompt user yes or no
        if (freePlayTokens > 0)
        {
            freePlayTokens--;
            return true;
        }
        else
            return false;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public String getName()
    {
        return name;
    }

    public int getPoints(int round)
    {
        return points[round];
    }
}
