import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tile extends JLabel{

	private Unit unit;
	
	private Item item;
	
	private boolean passable = true;
	
	private String art;
	
	private int x;
	
	private int y;
	
	Tile(String art, int x, int y, boolean passable){
		setArt(art);
		set_X(x);
		set_Y(y);
		setPassable(passable);
		updateGraphic();
	}
	
	Tile(String art, int x, int y, Unit unit, boolean passable){
		setArt(art);
		set_X(x);
		set_Y(y);
		setUnit(unit);
		setPassable(passable);
		updateGraphic();
	}
	
	Tile(String art, int x, int y, Item item, boolean passable){
		setArt(art);
		set_X(x);
		set_Y(y);
		setItem(item);
		setPassable(passable);
		updateGraphic();
	}
	
	Tile(String art, int x, int y, Unit unit, Item item, boolean passable){
		setArt(art);
		set_X(x);
		set_Y(y);
		setUnit(unit);
		setItem(item);
		setPassable(passable);
		updateGraphic();
	}
	
	public void updateGraphic() {
		this.setIcon(new ImageIcon(this.getArt()));
		if(item != null) {
			this.setIcon(new ImageIcon(item.getArt()));
		}
		if(unit != null) {
			this.setIcon(new ImageIcon(unit.getArt()));
		}
		
	}
	
	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
		updateGraphic();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
		updateGraphic();
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

	public boolean isPassable() {
		return passable;
	}

	public void setPassable(boolean passable) {
		this.passable = passable;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}
}
