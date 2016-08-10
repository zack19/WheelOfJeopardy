package teamAgile;

public class Scoreboard
{
    private int[] totalPoints = new int[3];

    public Scoreboard()
    {
        //Blank Constructor
    }

    // ----------------------------------------------------------
    /**
     * Loop through player list and print each player and points
     * Show points per round seperately
     * @param playerList
     * @param round
     * @param remainingSpins
     */
    public void displayStats(Player[] playerList, int round, int remainingSpins)
    {
        System.out.println("Wheel of Jeopardy! Round " + round + " / Spins Remaining: "
                + remainingSpins);
        for (int i = 0; i < playerList.length; i++)
        {
            System.out.println("Player " + (i + 1) + ": " + playerList[i].getName()
                + " has " + playerList[i].getPoints(round - 1) + " points");
        }

        return;
    }

    // ----------------------------------------------------------
    /**
     * Dsiplay Round
     * @param round
     */
    public void displayRound(int round)
    {
        //add some formating
        System.out.println(round);
    }

    // ----------------------------------------------------------
    /**
     * Print players names
     * @param playerList
     */
    public void displayPlayers(Player[] playerList)
    {
        return;
    }

    // ----------------------------------------------------------
    /**
     * print out the winning player
     * @param playerList
     */
    public void declareWinner(Player[] playerList)
    {
        System.out.println("Wheel of Jeopardy! Game Results:");
        System.out.println();
        for (int i = 0; i < playerList.length; i++)
        {
            System.out.println("Player " + (i + 1) + ": " + playerList[i].getName());
            System.out.println("    Round 1: " + playerList[i].getPoints(0) + " points");
            System.out.println("    Round 2: " + playerList[i].getPoints(1) + " points");
            totalPoints[i] = playerList[i].getPoints(0) + playerList[i].getPoints(1);
            System.out.println("    Total:   " + totalPoints[i] + " points");
            System.out.println();
        }

        int tempScore = 0;
        int tempPos = 0;

        for (int i = 0; i < playerList.length; ++i)
        {
            if (totalPoints[i] > tempScore)
            {
                tempScore = totalPoints[i];
                tempPos = i;
            }
        }

        System.out.println("The winner is " + playerList[tempPos].getName());
        return;
    }
}
