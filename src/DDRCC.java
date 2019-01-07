import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// the window
public class DDRCC extends JFrame implements KeyListener {
	
	private Room currentRoom;
	
	private Playable Hero;
	
	DDRCC(int sqr) {
		currentRoom = new Room(sqr);
		addKeyListener(this);
		this.setSize(600,600);
		this.getContentPane().add(currentRoom);
		this.setTitle("DDRC&C");
		this.setVisible(true);
		
	}
	
	DDRCC(int width, int height) {
		currentRoom = new Room(width, height);
		addKeyListener(this);
		this.setSize(600,600);
		this.getContentPane().add(currentRoom);
		this.setTitle("DDRC&C");
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		DDRCC ddrcc = new DDRCC(20,20);
		ddrcc.start(0 ,0 );
		
	}
	
	//start the game 
	public void start(int herox, int heroy) {
		//make a playable character
		int[] inven = {1, 0, 0, 0};
		Hero = new Playable(inven, 5 ,5 ,5 ,5 ,5 ,5 ,5 );
		//place the character on the game board
		currentRoom.getTiles()[herox][heroy].setText("H");
		currentRoom.setHeroLocation(currentRoom.getTiles()[herox][heroy]);
	}
	
	//this handles movement
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		//down
		if(key == 's') {
			currentRoom.getHeroLocation().setText("e");
			
			//stay in the room
			if(currentRoom.getHeroLocation().get_X() + 1 < currentRoom.getTiles().length ) {
				currentRoom.setHeroLocation(currentRoom.getTiles()[currentRoom.getHeroLocation().get_X() + 1][currentRoom.getHeroLocation().get_Y()]);
			}
			
			currentRoom.getHeroLocation().setText("H");
		}
		//up
		if(key == 'w') {
			currentRoom.getHeroLocation().setText("e");
			
			//stay in the room
			if(currentRoom.getHeroLocation().get_X() - 1 >= 0 ) {
				currentRoom.setHeroLocation(currentRoom.getTiles()[currentRoom.getHeroLocation().get_X() - 1][currentRoom.getHeroLocation().get_Y()]);
			}
			
			currentRoom.getHeroLocation().setText("H");
		}
		//left
		if(key == 'a') {
			currentRoom.getHeroLocation().setText("e");
			
			//stay in the room
			if(currentRoom.getHeroLocation().get_Y() - 1 >= 0) {
				currentRoom.setHeroLocation(currentRoom.getTiles()[currentRoom.getHeroLocation().get_X()][currentRoom.getHeroLocation().get_Y() - 1]);
			}
			
			currentRoom.getHeroLocation().setText("H");
		}
		//right
		if(key == 'd') {
			currentRoom.getHeroLocation().setText("e");
			
			//stay in the room
			if(currentRoom.getHeroLocation().get_Y() + 1 < currentRoom.getTiles()[0].length) {
				currentRoom.setHeroLocation(currentRoom.getTiles()[currentRoom.getHeroLocation().get_X()][currentRoom.getHeroLocation().get_Y() + 1]);
			}
			
			currentRoom.getHeroLocation().setText("H");
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	

}
