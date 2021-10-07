package tournois;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Bracket {

	private Collection<Match> matches = new HashSet<>();

	public Bracket(Set<Team> teams) {
		this.matches.add(new Match(teams));
	}

	public Collection<Match> getNextMatches() {
		return this.matches ;
	}


}
