package teamAgile;

import java.util.Scanner;

public class Player
{
    private String name;
    private int[] points;
    private int freePlayTokens;

    Scanner user_in = new Scanner(System.in);

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
        System.out.print("Would you like to use a free play token?");
        System.out.println(" You have " + freePlayTokens + " remaining");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int choice = user_in.nextInt();
        if (choice == 1)
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

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param round
     * @return
     */
    public int getPoints(int round)
    {
        return points[round];
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public int getTokens()
    {
        return freePlayTokens;
    }
}
