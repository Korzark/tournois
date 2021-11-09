package tournois;

public class Player {
	
	private boolean active = true;
	
	public void wakeUp() {
		active = true;
	}
	
	public void playerTested() {
		if (active) {
			System.out.println("I'm tired, bye...");
			active = false;
		}
		else {
			System.out.println("Zzzzz... Zzzzz...");
		}
	}
	
	public void playerPartiallyTested() {
		if (active) {
			System.out.println("I'm tired, bye...");
			active = false;
		}
		else {
			System.out.println("Zzzzz... Zzzzz...");
		}
	}
	
	public void playerNotTested() {
		if (active) {
			System.out.println("I'm tired, bye...");
			active = false;
		}
		else {
			System.out.println("Zzzzz... Zzzzz...");
		}
	}

}
