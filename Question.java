package teamAgile;

import java.util.Scanner;

public class Question
{
    private int pointValue;
    private Boolean isAnswered;
    private String category;
    private String question;
    private String[] answers;
    private int answer;

    Scanner user_in = new Scanner(System.in);

    // ----------------------------------------------------------
    /**
     * Create a new Question object.
     * @param points
     * @param category
     * @param question
     * @param ans
     * @param answer
     */
    public Question(int points, String category, String question, String[] ans,
        int answer)
    {
        pointValue = points;
        this.category = category;
        isAnswered = false;
        this.question = question;
        answers = ans;
        this.answer = answer;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return assigned points
     */
    public int askQuestion()
    {
        System.out.println(question);
        isAnswered = true;
        for (int i = 0; i < 4; i++)
        {
            System.out.println((i + 1) + ". " + answers[i]);
        }

        int userAns = user_in.nextInt();

        if (userAns == answer)
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

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public boolean beenAsked()
    {
        return isAnswered;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return category
     */
    public String getCategory()
    {
        return category;
    }
}
