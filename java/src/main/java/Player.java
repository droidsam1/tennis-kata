public class Player {
    final String name;
    public int points = 0;
    public String score = "";

    public Player(String name) {
        this.name = name;
    }

    public void incrementPoints() {
        points++;
    }
}