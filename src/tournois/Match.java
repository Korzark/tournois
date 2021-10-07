package tournois;

import java.util.Set;

public class Match {

	private Set<Team> teams;
	private Team winner;

	public Match(Set<Team> teams) {
		this.teams = teams;
	}

	public Set<Team> getTeams() {
		return this.teams;
	}

	public void play(Team t1, int scoreT1, Team t2, int scoreT2) {
		if (scoreT2 > scoreT1) {
			this.winner = t2;
		} else if (scoreT1 > scoreT2) {
			this.winner = t1;
		} else {
			this.winner = null;
		}
	}

	public Team getWinner() {
		// TODO Auto-generated method stub
		return this.winner;
	}

}
