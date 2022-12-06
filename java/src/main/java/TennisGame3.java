public class TennisGame3 implements TennisGame {

    private final String player1Name;
    private final String player2Name;
    private int player2Points;
    private int player1Points;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private static String getPointsDescription(int points) {
        return new String[]{"Love", "Fifteen", "Thirty", "Forty"}[points];
    }

    public String getScore() {
        if (player1Points >= 4 || player2Points >= 4 || player1Points + player2Points == 6) {
            if (isATie())
                return "Deuce";
        }
        if (player1Points >= 4 || player2Points >= 4 || player1Points + player2Points == 6) {
            String s = player1Points > player2Points ? player1Name : player2Name;
            return ((player1Points - player2Points) * (player1Points - player2Points) == 1) ? "Advantage " + s : "Win for " + s;
        } else {
            if (isATie()) {
                return getPointsDescription(player1Points) + "-All";
            }
            return getPointsDescription(player1Points) + "-" + getPointsDescription(player2Points);
        }
    }

    private boolean isATie() {
        return player1Points == player2Points;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            this.player1Points += 1;
        else
            this.player2Points += 1;

    }

}
