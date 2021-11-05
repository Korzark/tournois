package tournois;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import tournois.ext.GameAPI;
import tournois.ext.Result;


class TestExtTournois {
	
	protected boolean boolReturn;

	@Test
	void twoTeamsOneWinner() {
		boolReturn = false;
		
		GameAPI ext = new GameAPI() {
			
			@Override
			public Result nextMatch(String team1, String team2) {
				// TODO Auto-generated method stub
				boolReturn = ( ("t1".equals(team1)) && ("t2".equals(team2)) ||
						("t1".equals(team2)) && ("t2".equals(team1))
						);
				
				return null;
			}
			
			@Override
			public Set<String> getTeams() {
				// TODO Auto-generated method stub
				TreeSet<String> res = new TreeSet<>();
				res.add("t1");
				res.add("t2");
				return res;
			}
		};
		// ext should supply t1 and t2 as teams
		Tournois sut = new Tournois(ext);
		
		assertFalse(boolReturn);
		sut.launch();
		assertTrue(boolReturn);
		// assert that ext received message nextMatch(t1, t2) (or (t2, t1))
		
	}
	

}
