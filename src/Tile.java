import javax.swing.JLabel;

public class Tile extends JLabel{

	private Unit unit;
	
	private Item item;
	
	private int x;
	
	private int y;
	
	Tile(int x, int y){
		set_X(x);
		set_Y(y);
	}
	
	Tile(int x, int y, Unit unit){
		set_X(x);
		set_Y(y);
		this.unit = unit;
	}
	
	Tile(int x, int y, Item item){
		set_X(x);
		set_Y(y);
		this.item = item;
	}
	
	Tile(int x, int y, Unit unit, Item item){
		set_X(x);
		set_Y(y);
		this.unit = unit;
		this.item = item;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int get_X() {
		return x;
	}

	public void set_X(int x) {
		this.x = x;
	}

	public int get_Y() {
		return y;
	}

	public void set_Y(int y) {
		this.y = y;
	}
}
