
public class Unit{
		
	int hp;
	
	int mp;
	
	int melee;
	
	int magic;
	
	int speed;
	
	int physdef;
	
	int magdef;
	
	Unit(int hp, int mp, int melee, int magic, int speed, int physdef, int magdef) {
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
}

