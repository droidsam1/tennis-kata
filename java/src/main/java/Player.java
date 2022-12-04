public class Player {
    final String name;
    public int points = 0;
    public String player1Score = "";

    public Player(String name) {
        this.name = name;
    }

    public void SetP1Score(int number) {

        for (int i = 0; i < number; i++) {
            incrementPlayer1Points();
        }

    }

    public void incrementPlayer1Points() {
        points++;
    }
}