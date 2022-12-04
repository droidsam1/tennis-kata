public class TennisGame2 implements TennisGame {

    public final Player player1;
    public final Player player2;

    public int player2Points = 0;

    public String player2Score = "";

    public TennisGame2(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public String getScore() {
        String score = "";
        if (player1.points == player2Points && player1.points < 4) {
            if (player1.points == 0)
                score = "Love";
            if (player1.points == 1)
                score = "Fifteen";
            if (player1.points == 2)
                score = "Thirty";
            score += "-All";
        }
        if (player1.points == player2Points && player1.points >= 3)
            score = "Deuce";

        if (player1.points > 0 && player2Points == 0) {
            if (player1.points == 1)
                player1.score = "Fifteen";
            if (player1.points == 2)
                player1.score = "Thirty";
            if (player1.points == 3)
                player1.score = "Forty";

            player2Score = "Love";
            score = player1.score + "-" + player2Score;
        }
        if (player2Points > 0 && player1.points == 0) {
            if (player2Points == 1)
                player2Score = "Fifteen";
            if (player2Points == 2)
                player2Score = "Thirty";
            if (player2Points == 3)
                player2Score = "Forty";

            player1.score = "Love";
            score = player1.score + "-" + player2Score;
        }

        if (player1.points > player2Points && player1.points < 4) {
            if (player1.points == 2)
                player1.score = "Thirty";
            if (player1.points == 3)
                player1.score = "Forty";
            if (player2Points == 1)
                player2Score = "Fifteen";
            if (player2Points == 2)
                player2Score = "Thirty";
            score = player1.score + "-" + player2Score;
        }
        if (player2Points > player1.points && player2Points < 4) {
            if (player2Points == 2)
                player2Score = "Thirty";
            if (player2Points == 3)
                player2Score = "Forty";
            if (player1.points == 1)
                player1.score = "Fifteen";
            if (player1.points == 2)
                player1.score = "Thirty";
            score = player1.score + "-" + player2Score;
        }

        if (player1.points > player2Points && player2Points >= 3) {
            score = "Advantage player1";
        }

        if (player2Points > player1.points && player1.points >= 3) {
            score = "Advantage player2";
        }

        if (player1.points >= 4 && player2Points >= 0 && (player1.points - player2Points) >= 2) {
            score = "Win for player1";
        }
        if (player2Points >= 4 && player1.points >= 0 && (player2Points - player1.points) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public void incrementPlayer2Points() {
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player1.name.equals(player))
            player1.incrementPlayer1Points();
        else
            incrementPlayer2Points();
    }
}