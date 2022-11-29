import java.util.Objects;

public class TennisGame1 implements TennisGame {

    public static final String ALL = "All";
    public static final String DEUCE = "Deuce";
    public static final String SEPARATOR = "-";
    public static final String ADVANTAGE = "Advantage";
    public static final String WIN_FOR = "Win for ";
    public static final String PLAYER_1 = "player1";
    public static final String PLAYER_2 = "player2";
    private int scorePlayerOne = 0;
    private int scorePlayerTwo = 0;

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, PLAYER_1))
            scorePlayerOne += 1;
        else
            scorePlayerTwo += 1;
    }

    public String getScore() {
        if (areTied()) {
            return getTiedScoreDescription();
        }
        if (thereIsWinner()) {
            return getWinningDescription();
        }
        if (atLeastThreePointsHaveBeenScoredByEachSide()) {
            return getAdvanceDescription();
        }

        return getScoreDescription(scorePlayerOne) + SEPARATOR + getScoreDescription(scorePlayerTwo);
    }

    private boolean thereIsWinner() {
        return ((scorePlayerOne >= 4 || scorePlayerTwo >= 4) && isScoreDifferenceBiggerThanTwoPoints());
    }

    private String getWinningDescription() {
        return WIN_FOR + getLeadPlayer();
    }

    private boolean isScoreDifferenceBiggerThanTwoPoints() {
        return Math.abs(scorePlayerTwo - scorePlayerOne) >= 2;
    }

    private String getAdvanceDescription() {
        return ADVANTAGE + " " + getLeadPlayer();
    }

    private String getLeadPlayer() {
        if (scorePlayerOne > scorePlayerTwo) {
            return PLAYER_1;
        }
        return PLAYER_2;
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

    private boolean isDeuce() {
        return areTied() && atLeastThreePointsHaveBeenScoredByEachSide();
    }

    private boolean areTied() {
        return scorePlayerOne == scorePlayerTwo;
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
