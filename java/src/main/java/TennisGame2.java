public class TennisGame2 implements TennisGame {

    public final Player player1;
    public final Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public String getScore() {
        String score = "";
        if (player1.points == player2.points && player1.points < 4) {
            if (player1.points == 0)
                score = "Love";
            if (player1.points == 1)
                score = "Fifteen";
            if (player1.points == 2)
                score = "Thirty";
            score += "-All";
        }
        if (player1.points == player2.points && player1.points >= 3)
            score = "Deuce";

        if (player1.points > 0 && player2.points == 0) {
            if (player1.points == 1)
                player1.score = "Fifteen";
            if (player1.points == 2)
                player1.score = "Thirty";
            if (player1.points == 3)
                player1.score = "Forty";

            player2.score = "Love";
            score = player1.score + "-" + player2.score;
        }
        if (player2.points > 0 && player1.points == 0) {
            if (player2.points == 1)
                player2.score = "Fifteen";
            if (player2.points == 2)
                player2.score = "Thirty";
            if (player2.points == 3)
                player2.score = "Forty";

            player1.score = "Love";
            score = player1.score + "-" + player2.score;
        }

        if (player1.points > player2.points && player1.points < 4) {
            if (player1.points == 2)
                player1.score = "Thirty";
            if (player1.points == 3)
                player1.score = "Forty";
            if (player2.points == 1)
                player2.score = "Fifteen";
            if (player2.points == 2)
                player2.score = "Thirty";
            score = player1.score + "-" + player2.score;
        }
        if (player2.points > player1.points && player2.points < 4) {
            if (player2.points == 2)
                player2.score = "Thirty";
            if (player2.points == 3)
                player2.score = "Forty";
            if (player1.points == 1)
                player1.score = "Fifteen";
            if (player1.points == 2)
                player1.score = "Thirty";
            score = player1.score + "-" + player2.score;
        }

        if (player1.points > player2.points && player2.points >= 3) {
            score = "Advantage player1";
        }

        if (player2.points > player1.points && player1.points >= 3) {
            score = "Advantage player2";
        }

        if (player1.points >= 4 && player2.points >= 0 && (player1.points - player2.points) >= 2) {
            score = "Win for player1";
        }
        if (player2.points >= 4 && player1.points >= 0 && (player2.points - player1.points) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public void wonPoint(String player) {
        if (player1.name.equals(player))
            player1.incrementPoints();
        else
            player2.incrementPoints();
    }
}