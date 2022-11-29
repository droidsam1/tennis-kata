import java.util.Objects;

public class TennisGame1 implements TennisGame {

    public static final String ALL = "All";
    public static final String DEUCE = "Deuce";
    public static final String SEPARATOR = "-";
    private int scorePlayerOne = 0;
    private int scorePlayerTwo = 0;

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1"))
            scorePlayerOne += 1;
        else
            scorePlayerTwo += 1;
    }

    public String getScore() {
        if (areTied()) {
            return getTiedScoreDescription();
        }
        if (scorePlayerOne >= 4 || scorePlayerTwo >= 4) {
            int minusResult = scorePlayerOne - scorePlayerTwo;
            String player2 = "player2";
            String player1 = "player1";
            if (minusResult == 1) return "Advantage " + player1;
            else if (minusResult == -1) return "Advantage " + player2;
            else if (minusResult >= 2) return "Win for " + player1;
            return "Win for " + player2;
        } else {
            return getScoreDescription(scorePlayerOne) + SEPARATOR + getScoreDescription(scorePlayerTwo);
        }
    }

    private String getTiedScoreDescription() {
        if (isDeuce()) {
            return DEUCE;
        }
        return getScoreDescription(scorePlayerOne) + SEPARATOR + ALL;
    }

    private boolean areTied() {
        return scorePlayerOne == scorePlayerTwo;
    }

    private boolean isDeuce() {
        return areTied() && scorePlayerOne >= 3;
    }

    private String getScoreDescription(int tempScore) {
        return switch (tempScore) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> String.valueOf(tempScore);
        };
    }
}
