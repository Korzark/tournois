package tournois;

import java.util.Set;

public class Match {

	private Set<Team> teams;

	public Match(Set<Team> teams) {
		this.teams = teams;
	}

	public Set<Team> getTeams() {
		return this.teams;
	}

}
