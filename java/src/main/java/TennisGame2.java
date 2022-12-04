public class TennisGame2 implements TennisGame {

    public final Player player1;
    public final Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public String getScore() {
        if (isATie()) {
            return getTieScoreDescription();
        }

        if (!aPlayerWins() && player1.getPoints() > player2.getPoints() && player2.getPoints() >= 3) {
            return "Advantage " + getPlayerWithHigherScore().getName();
        }

        if (!aPlayerWins() && player2.getPoints() > player1.getPoints() && player1.getPoints() >= 3) {
            return "Advantage " + getPlayerWithHigherScore().getName();
        }

        if (aPlayerWins()) {
            if (player1.getPoints() >= 4 && player2.getPoints() >= 0 && (player1.getPoints() - player2.getPoints()) >= 2) {
                return "Win for " + player1.getName();
            }
            if (player2.getPoints() >= 4 && player1.getPoints() >= 0 && (player2.getPoints() - player1.getPoints()) >= 2) {
                return "Win for " + player2.getName();
            }
        }
        return player1.getScore() + "-" + player2.getScore();
    }

    private Player getPlayerWithHigherScore() {
        if (player1.getPoints() > player2.getPoints()) {
            return player1;
        }
        return player2;
    }

    private String getTieScoreDescription() {
        if (isDeuce()) {
            return "Deuce";
        }
        return player1.getScore() + "-All";
    }

    private boolean isDeuce() {
        return isATie() && player1.getPoints() >= 3;
    }

    private boolean isATie() {
        return player1.getPoints() == player2.getPoints();
    }

    private boolean aPlayerWins() {
        return (player1.getPoints() >= 4 || player2.getPoints() >= 4) && Math.abs(player2.getPoints() - player1.getPoints()) >= 2;
    }

    public void wonPoint(String player) {
        if (player1.getName().equals(player))
            player1.incrementPoints();
        else
            player2.incrementPoints();
    }
}