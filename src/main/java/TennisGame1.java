/*
A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
        The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as "Love", "Fifteen", "Thirty", and "Forty" respectively.
        If at least three points have been scored by each player, and the scores are equal, the score is "Deuce".
        If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is "Advantage" for the player in the lead.
*/

public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;
    private String score = "";
    private Score gameScore = new Score();

    public TennisGame1(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String computeScore() {
        if (player1.hasSamePointsAs(player2)) {
            return computeScoreWhenPointsAreEqual(player1.getPoints());
        } else if (eitherPlayerHasEnoughPointsToWin()) {
            return computeScoreWhenPlayerHasAdvantageOrHasWon();
        } else {
            return computeScoreWhenOnePlayerIsInTheLeadButNotGotEnoughPointsToWin();
        }
    }

    private String computeScoreWhenOnePlayerIsInTheLeadButNotGotEnoughPointsToWin() {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1.getPoints();
            else {
                score += "-";
                tempScore = player2.getPoints();
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    private String computeScoreWhenPlayerHasAdvantageOrHasWon() {
        if (player1.hasAdvantageOver(player2)) return String.format("Advantage %s", player1.getName());
        else if (player2.hasAdvantageOver(player1)) return String.format("Advantage %s", player2.getName());
        else if (player1.hasWonOver(player2)) return String.format("Win for %s", player1.getName());
        else return String.format("Win for %s", player2.getName());
    }

    private String computeScoreWhenPointsAreEqual(int points) {
        switch (points) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private boolean eitherPlayerHasEnoughPointsToWin() {
        return player1.hasEnoughPointsToWin() || player2.hasEnoughPointsToWin();
    }

}
