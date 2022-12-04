public class TennisGame2 implements TennisGame {
    private final String player1Name;
    private final String player2Name;
    public int player1Points = 0;
    public int player2Points = 0;
    public String P1res = "";
    public String P2res = "";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (player1Points == player2Points && player1Points < 4) {
            if (player1Points == 0)
                score = "Love";
            if (player1Points == 1)
                score = "Fifteen";
            if (player1Points == 2)
                score = "Thirty";
            score += "-All";
        }
        if (player1Points == player2Points && player1Points >= 3)
            score = "Deuce";

        if (player1Points > 0 && player2Points == 0) {
            if (player1Points == 1)
                P1res = "Fifteen";
            if (player1Points == 2)
                P1res = "Thirty";
            if (player1Points == 3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (player2Points > 0 && player1Points == 0) {
            if (player2Points == 1)
                P2res = "Fifteen";
            if (player2Points == 2)
                P2res = "Thirty";
            if (player2Points == 3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (player1Points > player2Points && player1Points < 4) {
            if (player1Points == 2)
                P1res = "Thirty";
            if (player1Points == 3)
                P1res = "Forty";
            if (player2Points == 1)
                P2res = "Fifteen";
            if (player2Points == 2)
                P2res = "Thirty";
            score = P1res + "-" + P2res;
        }
        if (player2Points > player1Points && player2Points < 4) {
            if (player2Points == 2)
                P2res = "Thirty";
            if (player2Points == 3)
                P2res = "Forty";
            if (player1Points == 1)
                P1res = "Fifteen";
            if (player1Points == 2)
                P1res = "Thirty";
            score = P1res + "-" + P2res;
        }

        if (player1Points > player2Points && player2Points >= 3) {
            score = "Advantage player1";
        }

        if (player2Points > player1Points && player1Points >= 3) {
            score = "Advantage player2";
        }

        if (player1Points >= 4 && player2Points >= 0 && (player1Points - player2Points) >= 2) {
            score = "Win for player1";
        }
        if (player2Points >= 4 && player1Points >= 0 && (player2Points - player1Points) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            P1Score();
        }

    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            P2Score();
        }

    }

    public void P1Score() {
        player1Points++;
    }

    public void P2Score() {
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            P1Score();
        else
            P2Score();
    }
}