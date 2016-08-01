package teamAgile;

import java.util.Scanner;

public class Question
{
    private int pointValue;
    private Boolean isAnswered;
    private String category;
    private String question;
    private int answer;

    Scanner user_in = new Scanner(System.in);

    // ----------------------------------------------------------
    /**
     * Create a new Question object.
     * @param points
     * @param category
     */
    public Question(int points, String category)
    {
        pointValue = points;
        this.category = category;
        isAnswered = false;
        question = "1 or 2";
        answer = 1;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return assigned points
     */
    public int askQuestion()
    {
        System.out.println(question);
        int ans = user_in.nextInt();
        if (ans == answer)
        {
            System.out.println("Correct");
            return pointValue;
        }
        else
        {
            System.out.println("Incorrect");
            return pointValue * -1;
        }
    }
}
