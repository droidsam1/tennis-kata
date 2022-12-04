public class TennisGame2 implements TennisGame {

    public final Player player1;
    public final Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public String getScore() {
        if (isATie()) {
            if (isATie() && player1.getPoints() >= 3)
                return "Deuce";
            return player1.getScore() + "-All";
        }

        if (!aPlayerWins() && player1.getPoints() > player2.getPoints() && player2.getPoints() >= 3) {
            return "Advantage player1";
        }

        if (!aPlayerWins() && player2.getPoints() > player1.getPoints() && player1.getPoints() >= 3) {
            return "Advantage player2";
        }

        if (aPlayerWins()) {
            if (player1.getPoints() >= 4 && player2.getPoints() >= 0 && (player1.getPoints() - player2.getPoints()) >= 2) {
                return "Win for player1";
            }
            if (player2.getPoints() >= 4 && player1.getPoints() >= 0 && (player2.getPoints() - player1.getPoints()) >= 2) {
                return "Win for player2";
            }
        }
        return player1.getScore() + "-" + player2.getScore();
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