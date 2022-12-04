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
        return switch (points) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> String.valueOf(points);
        };
    }

    public void setScore(String score) {
        this.score = score;
    }
}