

public class Playable extends Unit{

	private Item[] inven;
	
	Playable(String art, int x, int y, Item[] inven, int hp, int mp, int melee, int magic, int speed, int physdef, int magdef){
		super(art, x, y, hp, mp, melee, magic, speed, physdef, magdef);
		this.inven = inven;
	}

	public Item[] getInven() {
		return inven;
	}

	public void setInven(Item[] inven) {
		this.inven = inven;
	}
	
	
}
