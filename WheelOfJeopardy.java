package teamAgile;

import java.util.Scanner;

public class WheelOfJeopardy
{
    public static final int CAT1 = 0;
    public static final int CAT2 = 1;
    public static final int CAT3 = 2;
    public static final int CAT4 = 3;
    public static final int CAT5 = 4;
    public static final int CAT6 = 5;
    public static final int LOSE_TURN = 6;
    public static final int FREE_TURN = 7;
    public static final int BANKRUPT = 8;
    public static final int PLAYERS_CHOICE = 9;
    public static final int OPP_CHOICE = 10;
    public static final int RE_SPIN = 11;

    public static void main(String[] args)
    {
        Scanner user_in = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int players = user_in.nextInt();
        Player[] playerList = new Player[players];

        for (int i = 0; i < players; i++)
        {
            System.out.println("Enter Player " + (i + 1) + " Name: ");
            Player tempPlayer = new Player(user_in.next());
            //TODO put in random order
            playerList[i] = tempPlayer;
        }

        PlayGame game = new PlayGame(playerList);
    }
}
