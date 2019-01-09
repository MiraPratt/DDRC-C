import javax.swing.JButton;

public class InventorySlot extends JButton {

	private Item item;
	
	private int slot;
	
	InventorySlot(int slot, Item item){
		setSlot(slot);
		setItem(item);
	}
	InventorySlot(int slot){
		setSlot(slot);
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}
	
	
}
