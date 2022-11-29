import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private int scorePlayerOne = 0;
    private int scorePlayerTwo = 0;

    private static String getMidGameScore(String score, int tempScore) {
        switch (tempScore) {
            case 0 -> score += "Love";
            case 1 -> score += "Fifteen";
            case 2 -> score += "Thirty";
            case 3 -> score += "Forty";
        }
        return score;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1"))
            scorePlayerOne += 1;
        else
            scorePlayerTwo += 1;
    }

    public String getScore() {
        if (scorePlayerOne == scorePlayerTwo) {
            return switch (scorePlayerOne) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            };
        } else if (scorePlayerOne >= 4 || scorePlayerTwo >= 4) {
            int minusResult = scorePlayerOne - scorePlayerTwo;
            String player2 = "player2";
            String player1 = "player1";
            if (minusResult == 1) return "Advantage " + player1;
            else if (minusResult == -1) return "Advantage " + player2;
            else if (minusResult >= 2) return "Win for " + player1;
            return "Win for " + player2;
        } else {
            String score = getMidGameScore("", scorePlayerOne);
            score += "-";
            score += getMidGameScore("", scorePlayerTwo);
            return score;
        }
    }
}
