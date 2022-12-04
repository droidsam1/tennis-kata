public class TennisGame2 implements TennisGame {

    public final Player player1;
    private final String player2Name;

    public int player2Points = 0;

    public String player2Score = "";

    public TennisGame2(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (player1.player1Points == player2Points && player1.player1Points < 4) {
            if (player1.player1Points == 0)
                score = "Love";
            if (player1.player1Points == 1)
                score = "Fifteen";
            if (player1.player1Points == 2)
                score = "Thirty";
            score += "-All";
        }
        if (player1.player1Points == player2Points && player1.player1Points >= 3)
            score = "Deuce";

        if (player1.player1Points > 0 && player2Points == 0) {
            if (player1.player1Points == 1)
                player1.player1Score = "Fifteen";
            if (player1.player1Points == 2)
                player1.player1Score = "Thirty";
            if (player1.player1Points == 3)
                player1.player1Score = "Forty";

            player2Score = "Love";
            score = player1.player1Score + "-" + player2Score;
        }
        if (player2Points > 0 && player1.player1Points == 0) {
            if (player2Points == 1)
                player2Score = "Fifteen";
            if (player2Points == 2)
                player2Score = "Thirty";
            if (player2Points == 3)
                player2Score = "Forty";

            player1.player1Score = "Love";
            score = player1.player1Score + "-" + player2Score;
        }

        if (player1.player1Points > player2Points && player1.player1Points < 4) {
            if (player1.player1Points == 2)
                player1.player1Score = "Thirty";
            if (player1.player1Points == 3)
                player1.player1Score = "Forty";
            if (player2Points == 1)
                player2Score = "Fifteen";
            if (player2Points == 2)
                player2Score = "Thirty";
            score = player1.player1Score + "-" + player2Score;
        }
        if (player2Points > player1.player1Points && player2Points < 4) {
            if (player2Points == 2)
                player2Score = "Thirty";
            if (player2Points == 3)
                player2Score = "Forty";
            if (player1.player1Points == 1)
                player1.player1Score = "Fifteen";
            if (player1.player1Points == 2)
                player1.player1Score = "Thirty";
            score = player1.player1Score + "-" + player2Score;
        }

        if (player1.player1Points > player2Points && player2Points >= 3) {
            score = "Advantage player1";
        }

        if (player2Points > player1.player1Points && player1.player1Points >= 3) {
            score = "Advantage player2";
        }

        if (player1.player1Points >= 4 && player2Points >= 0 && (player1.player1Points - player2Points) >= 2) {
            score = "Win for player1";
        }
        if (player2Points >= 4 && player1.player1Points >= 0 && (player2Points - player1.player1Points) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public void SetP1Score(int number) {

        player1.SetP1Score(number);
    }

    public void SetP2Score(int number) {

        for (int i = 0; i < number; i++) {
            incrementPlayer2Points();
        }

    }

    public void incrementPlayer1Points() {
        player1.incrementPlayer1Points();
    }

    public void incrementPlayer2Points() {
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player1.player1Name.equals(player))
            player1.incrementPlayer1Points();
        else
            incrementPlayer2Points();
    }
}