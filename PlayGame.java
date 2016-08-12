package teamAgile;

import java.util.Random;
import java.util.Scanner;

public class PlayGame
{
    private Player[] playerList;
    private int round;
    private int remainingSpins;
    private int playersTurn;
    private Question[][] gameBoard;

    Random rand = new Random();
    Scanner user_in = new Scanner(System.in);

    // ----------------------------------------------------------
    /**
     * Create a new PlayGame object.
     * @param playerList
     * @param board
     */
    public PlayGame(Player[] playerList, Question[][] board)
    {
        this.playerList = playerList;
        remainingSpins = 50;
        round = 1;
        playersTurn = 0;
        gameBoard = board;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void startGame()
    {
        Scoreboard board = new Scoreboard();

        while (round <= 2)
        {
            while (remainingSpins > 0)
            {
                board.displayStats(playerList, round, remainingSpins);
                System.out.println(playerList[playersTurn].getName() + "'s turn");
                int move = spinWheel();

                if (move == WheelOfJeopardy.PLAYERS_CHOICE)
                {
                    System.out.println("Player's Choice");
                    System.out.println("Please select a category");
                    for (int j = 0; j < 6; j++)
                    {
                        Question q = getQuestion(j);
                        if (q == null)
                            continue;
                        System.out.println((j + 1) + ". " + q.getCategory());
                    }
                    move = user_in.nextInt() - 1;
                }
                if (move == WheelOfJeopardy.OPP_CHOICE)
                {
                    System.out.println("Opponent's Choice");
                    System.out.println("Please select a category");
                    for (int j = 0; j < 6; j++)
                    {
                        Question q = getQuestion(j);
                        if (q == null)
                            continue;
                        System.out.println((j + 1) + ". " + q.getCategory());
                    }
                    move = user_in.nextInt() - 1;
                }
                if (move == WheelOfJeopardy.CAT1)
                {
                    Question currQuestion = getQuestion(WheelOfJeopardy.CAT1);
                    if (currQuestion == null)
                    {
                        System.out.println("This Category is empty, spinning again...");
                        continue;
                    }
                    System.out.println(currQuestion.getCategory());

                    int points = currQuestion.askQuestion();
                    playerList[playersTurn].updatePoints(points, round - 1);
                    if (points <= 0)
                        move = WheelOfJeopardy.LOSE_TURN;
                }
                if (move == WheelOfJeopardy.CAT2)
                {
                    Question currQuestion = getQuestion(WheelOfJeopardy.CAT2);
                    if (currQuestion == null)
                    {
                        System.out.println("This Category is empty, spinning again...");
                        continue;
                    }
                    System.out.println(currQuestion.getCategory());

                    int points = currQuestion.askQuestion();
                    playerList[playersTurn].updatePoints(points, round - 1);
                    if (points <= 0)
                        move = WheelOfJeopardy.LOSE_TURN;
                }
                if (move == WheelOfJeopardy.CAT3)
                {
                    Question currQuestion = getQuestion(WheelOfJeopardy.CAT3);
                    if (currQuestion == null)
                    {
                        System.out.println("This Category is empty, spinning again...");
                        continue;
                    }
                    System.out.println(currQuestion.getCategory());

                    int points = currQuestion.askQuestion();
                    playerList[playersTurn].updatePoints(points, round - 1);
                    if (points <= 0)
                        nextPlayer();
                }
                if (move == WheelOfJeopardy.CAT4)
                {
                    Question currQuestion = getQuestion(WheelOfJeopardy.CAT4);
                    if (currQuestion == null)
                    {
                        System.out.println("This Category is empty, spinning again...");
                        continue;
                    }
                    System.out.println(currQuestion.getCategory());

                    int points = currQuestion.askQuestion();
                    playerList[playersTurn].updatePoints(points, round - 1);
                    if (points <= 0)
                        move = WheelOfJeopardy.LOSE_TURN;
                }
                if (move == WheelOfJeopardy.CAT5)
                {
                    Question currQuestion = getQuestion(WheelOfJeopardy.CAT5);
                    if (currQuestion == null)
                    {
                        System.out.println("This Category is empty, spinning again...");
                        continue;
                    }
                    System.out.println(currQuestion.getCategory());

                    int points = currQuestion.askQuestion();
                    playerList[playersTurn].updatePoints(points, round - 1);
                    if (points <= 0)
                        move = WheelOfJeopardy.LOSE_TURN;
                }
                if (move == WheelOfJeopardy.CAT6)
                {
                    Question currQuestion = getQuestion(WheelOfJeopardy.CAT6);
                    if (currQuestion == null)
                    {
                        System.out.println("This Category is empty, spinning again...");
                        continue;
                    }
                    System.out.println(currQuestion.getCategory());

                    int points = currQuestion.askQuestion();
                    playerList[playersTurn].updatePoints(points, round - 1);
                    if (points <= 0)
                        move = WheelOfJeopardy.LOSE_TURN;
                }
                if (move == WheelOfJeopardy.LOSE_TURN)
                {
                    System.out.println("Lose Turn");
                    if (playerList[playersTurn].getTokens() > 0)
                    {
                        if (!playerList[playersTurn].useToken())
                            nextPlayer();
                    }
                    else
                        nextPlayer();
                }
                if (move == WheelOfJeopardy.FREE_TURN)
                {
                    System.out.println("Free Token");
                    playerList[playersTurn].addToken();
                    System.out.println(playerList[playersTurn].getName() + " now has "
                        + playerList[playersTurn].getTokens() + " Tokens");
                }
                if (move == WheelOfJeopardy.BANKRUPT)
                {
                    System.out.println("Bankrupt");
                    playerList[playersTurn].bankrupt(round);
                    nextPlayer();
                }
                if (move == WheelOfJeopardy.RE_SPIN)
                {
                    System.out.println("Spin Again");
                }
            }
            if (round == 1)
                System.out.println("Round 1 has ended, moving to round 2");
            round++;
            remainingSpins = 50;
        }
        board.declareWinner(playerList);
    }
    // ----------------------------------------------------------
    /**
     * Randomly choose an int between 0 and 11 to represent
     * spinning wheel
     * @return wheel segment
     */
    public int spinWheel()
    {
        remainingSpins--;
        System.out.println("Spinning Wheel...");
        return rand.nextInt(12);
    }

    // ----------------------------------------------------------
    /**
     * Move flow of control to next player
     */
    public void nextPlayer()
    {
        playersTurn++;
        if (playersTurn >= playerList.length)
        {
            playersTurn = 0;
        }
    }

    // ----------------------------------------------------------
    /**
     * Get a question from the board
     * @param category to get question from
     * @return Question
     */
    public Question getQuestion(int category)
    {
        for (int i = 0; i < 5; i++)
        {
            if (!gameBoard[(category) + (6 * (round - 1))][i].beenAsked())
                return gameBoard[(category) + (6 * (round - 1))][i];
        }
        return null;
    }
}
