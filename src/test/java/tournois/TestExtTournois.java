package tournois;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import tournois.ext.GameAPI;
import tournois.ext.Result;


class TestExtTournois {
	
	@Test
	void twoTeamsOneWinner() {
		GameAPI ext = mock(GameAPI.class);
		
		Set<String> teamNames = new TreeSet<>();
		teamNames.add("t1");
		teamNames.add("t2");
		
		when(ext.getTeams()).thenReturn(teamNames);
		
		Tournois sut = new Tournois(ext);
		sut.launch();
		verify(ext).nextMatch("t1", "t2");
		
	}
	
	
	@Test
	void twoTeamsOneWinnerOld() {
		final boolean[] boolReturn = {false};
		
		GameAPI ext = new GameAPI() {
			
			@Override
			public Result nextMatch(String team1, String team2) {
				boolReturn[0] = ( ("t1".equals(team1)) && ("t2".equals(team2)) ||
						("t1".equals(team2)) && ("t2".equals(team1))
						);
				
				return null;
			}
			
			@Override
			public Set<String> getTeams() {
				Set<String> res = new TreeSet<>();
				res.add("t1");
				res.add("t2");
				return res;
			}
		};
		// ext should supply t1 and t2 as teams
		Tournois sut = new Tournois(ext);
		
		assertFalse(boolReturn[0]);
		sut.launch();
		// asserts that ext received message nextMatch(t1, t2) (or (t2, t1))
		assertTrue(boolReturn[0]);
		
	}
	
	
	

}
