package teamAgile;

public class Question
{
    private int pointValue;
    private Boolean isAnswered;
    private String category;

    public Question(int points, String category)
    {
        pointValue = points;
        this.category = category;
        isAnswered = false;
    }
}
