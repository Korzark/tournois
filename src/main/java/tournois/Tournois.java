package tournois;

import java.util.HashSet;
import java.util.Set;

import tournois.ext.GameAPI;

public class Tournois {

	private Bracket bracket;
	private Set<Team> teams = new HashSet<>();
	private GameAPI ext;
   
	public Tournois(GameAPI ext) {
		this.ext = ext;
		// TODO Auto-generated constructor stub
		for(String t:ext.getTeams()) {
			this.add(new Team(t));
		}
	}

	public Tournois() {
		// TODO Auto-generated constructor stub
	}

	public void add(Team t) {
		this.teams.add(t);

	}

	public void launch() {
		if(this.teams.size() < 2) {
			throw new NotEnoughTeamsException();
		}
		this.bracket = new Bracket(this.teams);
		if(this.ext != null) this.ext.nextMatch("t1", "t2");
	}

	public Bracket getBracket() {
		return this.bracket;
	}

}
