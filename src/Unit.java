
public class Unit{
		
	int hp = 5;
	
	int mp = 5;
	
	int melee = 5;
	
	int magic = 5;
	
	int speed = 5;
	
	int physdef = 5;
	
	int magdef = 5;
	
	private int x;
	
	private int y;
	
	private boolean hasMoved = false;
	
	private String art;
	
	Unit(String art, int x, int y){
		setArt(art);
		setX(x);
		setY(y);
	}
	
	Unit(String art, int x, int y, int hp, int mp, int melee, int magic, int speed, int physdef, int magdef) {
		setArt(art);
		setX(x);
		setY(y);
		setHp(hp);
		setMp(mp);
		setMelee(melee);
		setMagic(magic);
		setSpeed(speed);
		setPhysdef(physdef);
		setMagdef(magdef);
	}
	
	//getter
	
	public int getHp() {
		return hp;
	}
	
	public int getMp() {
		return mp;
	}
	
	public int getMelee() {
		return melee;
	}
	
	public int getMagic() {
		return magic;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getPhysdef() {
		return physdef;
	}
	
	public int getMagdef() {
		return magdef;
	}
	
	//setter
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setMp(int mp) {
		this.mp = mp;
	}
	
	public void setMelee(int melee) {
		this.melee = melee;
	}
	
	public void setMagic(int magic) {
		this.magic = magic;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void setPhysdef(int physdef) {
		this.physdef = physdef;
	}
	
	public void setMagdef(int magdef) {
		this.magdef = magdef;
	}
	
	
	//location

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}

