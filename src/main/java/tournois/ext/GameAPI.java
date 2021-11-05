package tournois.ext;

import java.util.Set;

public interface GameAPI {
	
	Set<String> getTeams();
	
	Result nextMatch(String team1, String Team2);

}
