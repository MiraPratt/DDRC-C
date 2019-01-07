
public class Item {

	private int plusHp = 1;
	
	private int x;
	
	private int y;
	
	Item(){
		
	}
	
	Item(int plusHp){
		setPlusHp(plusHp);
	}
	
	Item(int x, int y){
		setX(x);
		setY(y);
	}
	
	Item(int x, int y, int plusHp){
		setX(x);
		setY(y);
		setPlusHp(plusHp);
	}
	
	
	public int getPlusHp() {
		return plusHp;
	}

	public void setPlusHp(int plusHp) {
		this.plusHp = plusHp;
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

	
}
