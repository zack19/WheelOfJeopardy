package teamAgile;

import java.util.Random;

public class PlayGame
{
    private Player[] playerList;
    private int round;
    private int remainingSpins;
    private int playersTurn;

    Random rand = new Random();

    public PlayGame(Player[] playerList)
    {
        this.playerList = playerList;
        remainingSpins = 10;
        round = 1;
        playersTurn = 0;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void startGame()
    {
        while (remainingSpins > 0)
        {
            System.out.println("Current Score");
            for (int i = 0; i < playerList.length; i++)
            {
                System.out.println(playerList[i].getName() + ": " + playerList[i].getPoints(round - 1));
            }
            int move = spinWheel();

            if (move == WheelOfJeopardy.CAT1)
            {
                System.out.println("Cat 1");
                Question currQuestion = getQuestion(1);
                playerList[playersTurn].updatePoints(currQuestion.askQuestion(), round - 1);
                nextPlayer();
            }
            else if (move == WheelOfJeopardy.CAT2)
            {
                System.out.println("Cat 2");
                Question currQuestion = getQuestion(2);
                playerList[playersTurn].updatePoints(currQuestion.askQuestion(), round - 1);
                nextPlayer();
            }
            else if (move == WheelOfJeopardy.CAT3)
            {
                System.out.println("Cat 3");
                Question currQuestion = getQuestion(3);
                playerList[playersTurn].updatePoints(currQuestion.askQuestion(), round - 1);
                nextPlayer();
            }
            else if (move == WheelOfJeopardy.CAT4)
            {
                System.out.println("Cat 4");
                Question currQuestion = getQuestion(4);
                playerList[playersTurn].updatePoints(currQuestion.askQuestion(), round - 1);
                nextPlayer();
            }
            else if (move == WheelOfJeopardy.CAT5)
            {
                System.out.println("Cat 5");
                Question currQuestion = getQuestion(5);
                playerList[playersTurn].updatePoints(currQuestion.askQuestion(), round - 1);
                nextPlayer();
            }
            else if (move == WheelOfJeopardy.CAT6)
            {
                System.out.println("Cat 6");
                Question currQuestion = getQuestion(6);
                playerList[playersTurn].updatePoints(currQuestion.askQuestion(), round - 1);
                nextPlayer();
            }
            else if (move == WheelOfJeopardy.LOSE_TURN)
            {
                System.out.println("Lose Turn");
                if (!playerList[playersTurn].useToken())
                    nextPlayer();
            }
            else if (move == WheelOfJeopardy.FREE_TURN)
            {
                System.out.println("Free Token");
                playerList[playersTurn].addToken();
                nextPlayer();
            }
            else if (move == WheelOfJeopardy.BANKRUPT)
            {
                System.out.println("Bankrupt");
                playerList[playersTurn].bankrupt(round);
                nextPlayer();
            }
            else if (move == WheelOfJeopardy.PLAYERS_CHOICE)
            {
                System.out.println("PLayer's Choice");
                nextPlayer();
            }
            else if (move == WheelOfJeopardy.OPP_CHOICE)
            {
                System.out.println("Opponent's Choice");
                nextPlayer();
            }
            else if (move == WheelOfJeopardy.RE_SPIN)
            {
                System.out.println("Spin Again");
            }
        }
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
        Question ques = new Question(50, "cat 1");
        return ques;
    }
}
