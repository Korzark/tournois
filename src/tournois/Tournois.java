package tournois;

import java.util.HashSet;
import java.util.Set;

public class Tournois {

	private Bracket bracket;
	private Set<Team> teams = new HashSet<>();

	public void add(Team t) {
		this.teams.add(t);

	}

	public void launch() {
		this.bracket = new Bracket(this.teams);
	}

	public Bracket getBracket() {
		return this.bracket;
	}

}
