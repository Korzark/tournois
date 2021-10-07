package tournois;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class TestTournois {

	@Test
	void twoTeams() {
		
		Tournois sut = new Tournois(); //System under test
		
		Team t1 = new Team("teamOne");
		Team t2 = new Team("teamTwo");
		
		sut.add(t1);
		sut.add(t2);
		
		sut.launch();
		Bracket res = sut.getBracket();
		Collection<Match> list = res.getNextMatches();
		
		assertEquals(1,list.size());
		Match m = list.iterator().next();
		assertEquals(Set.of(t1, t2),m.getTeams());
	}
	
	@Test
	void twoTeamsMatchT2Wins() {
		
		Tournois sut = new Tournois(); //System under test
		
		Team t1 = new Team("teamOne");
		Team t2 = new Team("teamTwo");
		
		sut.add(t1);
		sut.add(t2);
		
		sut.launch();
		Bracket res = sut.getBracket();
		Collection<Match> list = res.getNextMatches();
		
		Match m = list.iterator().next();
		m.play(t1, 80, t2, 90);
		Team winner = m.getWinner();
		assertEquals(t2, winner);
	}
	
	@Test
	void twoTeamsMatchT1Wins() {
		
		Tournois sut = new Tournois(); //System under test
		
		Team t1 = new Team("teamOne");
		Team t2 = new Team("teamTwo");
		
		sut.add(t1);
		sut.add(t2);
		
		sut.launch();
		Bracket res = sut.getBracket();
		Collection<Match> list = res.getNextMatches();
		
		Match m = list.iterator().next();
		m.play(t1, 110, t2, 90);
		Team winner = m.getWinner();
		assertEquals(t1, winner);
	}
	
	@Test
	void twoTeamsMatchEquality() {
		
		Tournois sut = new Tournois(); //System under test
		
		Team t1 = new Team("teamOne");
		Team t2 = new Team("teamTwo");
		
		sut.add(t1);
		sut.add(t2);
		
		sut.launch();
		Bracket res = sut.getBracket();
		Collection<Match> list = res.getNextMatches();
		
		Match m = list.iterator().next();
		m.play(t1, 90, t2, 90);
		Team winner = m.getWinner();
		assertNull(winner);
	}
	
	

}
