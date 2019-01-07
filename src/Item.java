
public class Item {

	private int plusHp = 1;
	
	private String art;
	
	private int x;
	
	private int y;
	
	Item(String art, int x, int y){
		setArt(art);
		setX(x);
		setY(y);
	}
	
	Item(String art, int x, int y, int plusHp){
		setArt(art);
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

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	
}
