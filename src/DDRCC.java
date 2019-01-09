
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.io.IOException;


// the window
public class DDRCC extends JFrame{
	
	private Room currentRoom;
	
	private Inventory inventory;
	
	//the player will go from room to room so a reference to their character is stored in the class of the window
	private Playable Hero;
	
	DDRCC(int sqr) {
		currentRoom = new Room(sqr);
		inventory = new Inventory(4);
		this.setSize(600,600);
		this.setLayout(new BorderLayout());
		this.getContentPane().add(currentRoom, BorderLayout.CENTER);
		this.getContentPane().add(inventory, BorderLayout.SOUTH);
		this.setTitle("DDRC&C");
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		
	}
	
	DDRCC(int width, int height) {
		currentRoom = new Room(width, height);
		inventory = new Inventory(4);
		this.setSize(600,600);
		this.getContentPane().add(currentRoom, BorderLayout.CENTER);
		this.getContentPane().add(inventory, BorderLayout.SOUTH);
		this.setTitle("DDRC&C");
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		DDRCC ddrcc = new DDRCC(20,20);
		
	}

	
	

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	

}
