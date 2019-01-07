

public class Playable extends Unit{

	private int[] inven;
	
	Playable(String art, int x, int y, int[] inven, int hp, int mp, int melee, int magic, int speed, int physdef, int magdef){
		super(art, x, y, hp, mp, melee, magic, speed, physdef, magdef);
		this.inven = inven;
	}

	public int[] getInven() {
		return inven;
	}

	public void setInven(int[] inven) {
		this.inven = inven;
	}
	
	
}
