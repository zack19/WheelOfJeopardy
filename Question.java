package teamAgile;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

public class Question
{
    private int pointValue;
    private Boolean isAnswered;
    private String category;
    private String question;
    private String[] answers;
    private int answer;

    BufferedReader br;

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
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return assigned points
     */
    public int askQuestion()
    {
        Date sTime = new Date();

        System.out.println(question);
        isAnswered = true;
        for (int i = 0; i < 4; i++)
        {
            System.out.println((i + 1) + ". " + answers[i]);
        }

        long startTime = sTime.getTime();
        long currTime = startTime;
        try
        {
            while (!br.ready())
            {
                Date cTime = new Date();
                currTime = cTime.getTime();
                Thread.sleep(1000);
                if ((currTime - startTime) > 10000)
                {
                    System.out.println("Question timed out after 10 seconds, no points awarded");
                    return 0;
                }
            }
        }
        catch (IOException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        catch (InterruptedException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        int userAns = 0;
        try
        {
            userAns = Integer.parseInt(br.readLine());
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
