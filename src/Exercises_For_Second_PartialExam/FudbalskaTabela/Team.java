package Exercises_For_Second_PartialExam.FudbalskaTabela;


import java.util.Comparator;

public class Team {
    private String teamName;
    private int countGames;
    private int wins;
    private int draws;
    private int losses;
    private int totalPoints;
    private int goalsAchieved;
    private int goalsReceived;

    public static Comparator<Team> comparator = Comparator.comparing(Team::getTotalPoints)
            .thenComparing(Team::getGoalDiff).reversed().thenComparing(Team::getTeamName);

    public Team(String teamName) {
        this.teamName = teamName;
        countGames = 0;
        wins = 0;
        draws = 0;
        losses = 0;
        totalPoints = 0;
        goalsAchieved = 0;
        goalsReceived = 0;
    }

    public int getGoalDiff() {
        return goalsAchieved - goalsReceived;
    }

    @Override
    public String toString() {
        return String.format("%-15s%5d%5d%5d%5d%5d", teamName, countGames, wins, draws, losses, totalPoints);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getCountGames() {
        return countGames;
    }

    public void setCountGames(int countGames) {
        this.countGames = countGames;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getGoalsAchieved() {
        return goalsAchieved;
    }

    public void setGoalsAchieved(int goalsAchieved) {
        this.goalsAchieved = goalsAchieved;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }


}
