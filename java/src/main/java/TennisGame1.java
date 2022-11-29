import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private int scorePlayerOne = 0;
    private int scorePlayerTwo = 0;

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1"))
            scorePlayerOne += 1;
        else
            scorePlayerTwo += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (scorePlayerOne == scorePlayerTwo) {
            score = switch (scorePlayerOne) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            };
        } else if (scorePlayerOne >= 4 || scorePlayerTwo >= 4) {
            int minusResult = scorePlayerOne - scorePlayerTwo;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = scorePlayerOne;
                else {
                    score += "-";
                    tempScore = scorePlayerTwo;
                }
                switch (tempScore) {
                    case 0 -> score += "Love";
                    case 1 -> score += "Fifteen";
                    case 2 -> score += "Thirty";
                    case 3 -> score += "Forty";
                }
            }
        }
        return score;
    }
}
