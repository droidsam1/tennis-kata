public class Player {
    final String player1Name;
    public int player1Points = 0;
    public String player1Score = "";

    public Player(String player1Name) {
        this.player1Name = player1Name;
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            incrementPlayer1Points();
        }

    }

    public void incrementPlayer1Points() {
        player1Points++;
    }
}