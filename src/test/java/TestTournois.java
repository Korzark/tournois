package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import main.java.tournois.Bracket;
import main.java.tournois.Match;
import main.java.tournois.NotEnoughTeamsException;
import main.java.tournois.Team;
import main.java.tournois.Tournois;

class TestTournois {

	@Test
	void twoTeams() {
		Tournois sut = new Tournois(); 	// sut == System Under Test
		
		Team t1 = new Team("Team1");
		Team t2 = new Team("Team2");
		
		sut.add(t1);
		sut.add(t2);
		
		sut.launch();
		Bracket res = sut.getBracket();
		Collection<Match> list = res.getNextMatches();
		
		assertEquals(1, list.size());
		Match m = list.iterator().next();
		assertEquals(new HashSet<>(Arrays.asList(t1,t2)),m.getTeams());
	}

	@Test
	void twoTeamsMatch1() {
		Tournois sut = new Tournois();
		
		Team t1 = new Team("Team1");
		Team t2 = new Team("Team2");
		
		sut.add(t1);
		sut.add(t2);
		
		sut.launch();
		Bracket res = sut.getBracket();
		Collection<Match> list = res.getNextMatches();
		
		Match m = list.iterator().next();
		m.play(t1,80, t2, 90);
		Team winner = m.getWinner();
		assertEquals(t2,winner);
	}
	
	@Test
	void twoTeamsMatch2() {
		Tournois sut = new Tournois();
		
		Team t1 = new Team("Team1");
		Team t2 = new Team("Team2");
		
		sut.add(t1);
		sut.add(t2);
		
		sut.launch();
		Bracket res = sut.getBracket();
		Collection<Match> list = res.getNextMatches();
		
		Match m = list.iterator().next();
		m.play(t1,90, t2, 80);
		Team winner = m.getWinner();
		assertEquals(t1,winner);
	}
	
	@Test
	void twoTeamsMatchEquality() {
		Tournois sut = new Tournois();
		
		Team t1 = new Team("Team1");
		Team t2 = new Team("Team2");
		
		sut.add(t1);
		sut.add(t2);
		
		sut.launch();
		Bracket res = sut.getBracket();
		Collection<Match> list = res.getNextMatches();
		
		Match m = list.iterator().next();
		m.play(t1,90, t2, 90);
		Team winner = m.getWinner();
		assertNull(winner);
	}
	
	@Test
	void oneTeamMatch() {
		Tournois sut = new Tournois();
		Team t1 = new Team ("team1");
		
		sut.add(t1);
		
		
		assertThrows(NotEnoughTeamsException.class, () -> sut.launch());
	}
}
