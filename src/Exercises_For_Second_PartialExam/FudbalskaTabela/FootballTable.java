package Exercises_For_Second_PartialExam.FudbalskaTabela;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FootballTable {

    Map<String, Team> teams;

    public FootballTable() {
        teams = new HashMap<>();
    }


    public void addGame(String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
        updateTeam(homeTeam, awayGoals, homeGoals);
        updateTeam(awayTeam, homeGoals, awayGoals);
    }

    private void updateTeam(String team, int homeGoals, int awayGoals) {
        teams.putIfAbsent(team, new Team(team));

        teams.computeIfPresent(team, (k, v) -> {
            v.setCountGames(v.getCountGames() + 1);
            v.setGoalsAchieved(v.getGoalsAchieved() + awayGoals);
            v.setGoalsReceived(v.getGoalsReceived() + homeGoals);
            int type = typeOfMatch(awayGoals, homeGoals);

            if (type == 0) v.setDraws(v.getDraws() + 1);
            else if (type >= 1) v.setWins(v.getWins() + 1);
            else v.setLosses(v.getLosses() + 1);

            v.setTotalPoints(v.getWins() * 3 + v.getDraws());

            return v;
        });

    }

    private int typeOfMatch(int homeGoals, int awayGoals) {
        return Integer.compare(homeGoals, awayGoals);
    }


    public void printTable() {
        List<Team> allTeams = teams.values().stream().sorted(Team.comparator).collect(Collectors.toList());

        IntStream.range(0, allTeams.size()).forEach(i -> {
            System.out.printf("%2d. %s\n", i + 1, allTeams.get(i));
        });
    }
}