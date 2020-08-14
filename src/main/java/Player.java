public class Player {
    private final String name;
    private int points = 0;

    public Player(String name) {
        this.name = name;
    }

    public boolean hasSamePointsAs(Player player2) {
        return player2.getPoints() == this.points;
    }

    public int getPoints() {
        return points;
    }

    boolean hasEnoughPointsToWin() {
        return points >= 4;
    }

    public void incrementScore() {
        points +=1;
    }

    public boolean hasAdvantageOver(Player player2) {
        return (this.points -player2.getPoints()) == 1;
    }

    public boolean hasWonOver(Player player2) {
        return (this.points - player2.getPoints()) >= 2;
    }

    public String getName() {
        return name;
    }
}
