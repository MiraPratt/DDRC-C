

public class Playable extends Unit{

	private int[] inven;
	
	Playable(int[] inven, int hp, int mp, int melee, int magic, int speed, int physdef, int magdef){
		super( hp, mp, melee, magic, speed, physdef, magdef);
		this.inven = inven;
	}

	public int[] getInven() {
		return inven;
	}

	public void setInven(int[] inven) {
		this.inven = inven;
	}
	
	
}
