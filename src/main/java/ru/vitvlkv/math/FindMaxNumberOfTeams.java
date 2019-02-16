package ru.vitvlkv.math;

import java.util.HashSet;
import java.util.Set;

/*
* There are N countries, each country has Ai players. You need to form teams of
* size K such that each player in the team is from a different country.
* Given N and number of players from each country and size K.
* Find the maximum number of teams you can form.
*
* Time complexity: O(playersCounts.length * sum(playersCounts)/teamSize)
* Where sum(playersCounts)/teamSize is the upper bound for teamsCount.
* */
public class FindMaxNumberOfTeams {
    public static int run(int[] playersCounts, int teamSize) {
        if (teamSize > playersCounts.length) {
            return 0;
        }

        int teamsCount = 0;

        while (true) {
            boolean isTeamCreated = false;
            Set<Integer> teamCountries = new HashSet<>();
            for (int i = 0; i < playersCounts.length; ++i) { // O(playersCounts.length)
                if (teamCountries.contains(i)) {
                    continue;
                }
                if (playersCounts[i] == 0) {
                    continue;
                }
                playersCounts[i]--;
                teamCountries.add(i);
                if (teamCountries.size() == teamSize) {
                    teamsCount++;
                    isTeamCreated = true;
                    break;
                }
            }
            if (!isTeamCreated) {
                break;
            }
        }

        return teamsCount;
    }
}
