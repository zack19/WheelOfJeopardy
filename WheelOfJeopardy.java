package teamAgile;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

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
        Random rand = new Random();

        Question[][] board = readQuestions();
        System.out.println("Welcome to Wheel Of Jeopardy");
        System.out.println("Please enter the number of your selection");
        System.out.println("1. Play Game with Defualt Question Board");
        System.out.println("2. Load Custom Questions");
        if (user_in.nextInt() == 2)
            updateBoard(board);

        System.out.print("Enter the number of players: ");
        int players = user_in.nextInt();
        Player[] playerList = new Player[players];

        for (int i = 0; i < players; i++)
        {
            System.out.println("Enter Player " + (i + 1) + " Name: ");
            Player tempPlayer = new Player(user_in.next());
            int pos = rand.nextInt(players);
            while (playerList[pos] != null)
            {
                pos = rand.nextInt(players);
            }
            playerList[pos] = tempPlayer;
        }

        System.out.println("Player Order is...");
        for (int i = 0; i < playerList.length; i++)
        {
            System.out.println((i+1) + ". " + playerList[i].getName());
        }
        PlayGame game = new PlayGame(playerList, board);
        game.startGame();
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param qBoard
     */
    public static void updateBoard(Question[][] qBoard)
    {
        try
        {
            FileReader fr = new FileReader("additions.txt");
            BufferedReader br = new BufferedReader(fr);

            try
            {
                while (br.ready())
                {
                    int cat = Integer.parseInt(br.readLine());
                    int round = Integer.parseInt(br.readLine());
                    String catName = br.readLine();
                    int points = Integer.parseInt(br.readLine());
                    String question = br.readLine();
                    String[] answers = new String[4];
                    for (int i = 0; i < 4; i++)
                    {
                        answers[i] = br.readLine();
                    }
                    int answer = Integer.parseInt(br.readLine());

                    Question ques = new Question(points, catName, question, answers,
                        answer);

                    qBoard[(cat - 1) + (6 * (round - 1))][(points / (200 * round)) - 1] = ques;
                }
                br.close();
                fr.close();
            }
            catch (NumberFormatException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public static Question[][] readQuestions()
    {
        Question[][] board = new Question[12][5];
        try
        {
            FileReader fr = new FileReader("questions.txt");
            BufferedReader br = new BufferedReader(fr);

            try
            {
                while (br.ready())
                {
                    int cat = Integer.parseInt(br.readLine());
                    int round = Integer.parseInt(br.readLine());
                    String catName = br.readLine();
                    int points = Integer.parseInt(br.readLine());
                    String question = br.readLine();
                    String[] answers = new String[4];
                    for (int i = 0; i < 4; i++)
                    {
                        answers[i] = br.readLine();
                    }
                    int answer = Integer.parseInt(br.readLine());

                    Question ques = new Question(points, catName, question, answers,
                        answer);

                    board[(cat - 1) + (6 * (round - 1))][(points / (200 * round)) - 1] = ques;
                }
                br.close();
                fr.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return board;
    }
}
