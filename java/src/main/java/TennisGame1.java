import java.util.Objects;

public class TennisGame1 implements TennisGame {

    public static final String ALL = "All";
    public static final String DEUCE = "Deuce";
    public static final String SEPARATOR = "-";
    public static final String ADVANTAGE = "Advantage";
    public static final String WIN_FOR = "Win for ";
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
        if (scorePlayerOne >= 4) {
            if (scorePlayerOne > scorePlayerTwo && isScoreDifferenceBiggerThanTwoPoints())
                return WIN_FOR + getLeadPlayer();
        }

        if (scorePlayerTwo >= 4) {
            if (scorePlayerTwo > scorePlayerOne && isScoreDifferenceBiggerThanTwoPoints())
                return WIN_FOR + getLeadPlayer();
        }


        if (atLeastThreePointsHaveBeenScoredByEachSide()) {
            return getAdvanceDescription();
        }

        return getScoreDescription(scorePlayerOne) + SEPARATOR + getScoreDescription(scorePlayerTwo);
    }

    private boolean isScoreDifferenceBiggerThanTwoPoints() {
        return Math.abs(scorePlayerTwo - scorePlayerOne) >= 2;
    }

    private String getAdvanceDescription() {
        return ADVANTAGE + " " + getLeadPlayer();
    }

    private String getLeadPlayer() {
        if (scorePlayerOne > scorePlayerTwo) {
            return "player1";
        }
        return "player2";
    }

    private boolean atLeastThreePointsHaveBeenScoredByEachSide() {
        return scorePlayerOne >= 3 && scorePlayerTwo >= 3;
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
