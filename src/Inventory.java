import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Inventory extends JPanel{
	
	private InventorySlot[] slots;
	
	Inventory(int length){
		
		try{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch(Exception e) {}
		
		this.setSize(600, 100);
		this.setSlots(new InventorySlot[length]);
		this.setLayout(new GridLayout(1, length));
		
		slots  =  new InventorySlot[4];
		
		for(int i = 0; i < length; i++) {
			slots[i] = new InventorySlot(i);
			this.add(slots[i]);
		}
		
	}


	public InventorySlot[] getSlots() {
		return slots;
	}

	public void setSlots(InventorySlot[] slots) {
		this.slots = slots;
	}
}
