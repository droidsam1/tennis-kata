public class Player {
    private final String name;
    private int points = 0;
    private String score = "";

    public Player(String name) {
        this.name = name;
    }

    public void incrementPoints() {
        points++;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getScore() {
        if (getPoints() == 0)
            return "Love";
        if (getPoints() == 1)
            return "Fifteen";
        if (getPoints() == 2)
            return "Thirty";
        if (getPoints() == 3)
            return "Forty";
        return String.valueOf(points);
    }

    public void setScore(String score) {
        this.score = score;
    }
}