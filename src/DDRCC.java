import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.IOException;


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
		ddrcc.start(9 ,9 );
		
	}
	
	//start the game 
	public void start(int herox, int heroy) {
		//make a playable character
		int[] inven = {1, 0, 0, 0};
		Hero = new Playable(inven, 9 ,5 ,5 ,5 ,5 ,5 ,5 );
		
		
		//place the character on the game board
		
		currentRoom.getTiles()[herox][heroy].setIcon( new ImageIcon( Image.Player ));
		currentRoom.setHeroLocation(currentRoom.getTiles()[herox][heroy]);
		currentRoom.getHeroLocation().setUnit(Hero);
		
		//place an enemy on the board
		
		currentRoom.getTiles()[5][5].setIcon( new ImageIcon( Image.Goblin ));
		currentRoom.getTiles()[5][5].setUnit(new Unit(5 ,5 ));
		
		
		//place an enemy on the board
		
		currentRoom.getTiles()[6][6].setIcon( new ImageIcon( Image.Goblin ));
		currentRoom.getTiles()[6][6].setUnit(new Unit(5 ,5 ));
		
		//place an enemy on the board
		
		currentRoom.getTiles()[7][7].setIcon( new ImageIcon( Image.Goblin ));
		currentRoom.getTiles()[7][7].setUnit(new Unit(5 ,5 ));
		
		//place an enemy on the board
		
		currentRoom.getTiles()[8][8].setIcon( new ImageIcon( Image.Goblin ));
		currentRoom.getTiles()[8][8].setUnit(new Unit(5 ,5 ));
		
		//place another enemy on the board
		
		
		currentRoom.getTiles()[15][15].setIcon( new ImageIcon( Image.Goblin ));
		currentRoom.getTiles()[15][15].setUnit(new Unit(15 ,15 ));
		
		//place a wall
		currentRoom.getTiles()[10][10].setIcon( new ImageIcon( Image.Wall ));
		currentRoom.getTiles()[10][10].setPassable(false);
		
	}
	
	//handles movement
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		Tile stile = null;
		Tile wtile = null;
		Tile atile = null;
		Tile dtile = null;
		if(currentRoom.getHeroLocation().get_X() + 1 < currentRoom.getTiles().length) {
			stile = currentRoom.getTiles()[currentRoom.getHeroLocation().get_X() + 1][currentRoom.getHeroLocation().get_Y()];
		}
		if(currentRoom.getHeroLocation().get_X() - 1 >= 0) {
			wtile = currentRoom.getTiles()[currentRoom.getHeroLocation().get_X() - 1][currentRoom.getHeroLocation().get_Y()];
		}
		if(currentRoom.getHeroLocation().get_Y() - 1 >= 0) {
			atile = currentRoom.getTiles()[currentRoom.getHeroLocation().get_X()][currentRoom.getHeroLocation().get_Y() - 1];
		}
		if(currentRoom.getHeroLocation().get_Y() + 1 < currentRoom.getTiles()[0].length ) {
			dtile = currentRoom.getTiles()[currentRoom.getHeroLocation().get_X()][currentRoom.getHeroLocation().get_Y() + 1];
		}
		//down
		if(key == 's') {
			currentRoom.getHeroLocation().setIcon( new ImageIcon(Image.Cobble ));
			
			
			
			//attack a unit
			if(stile != null && stile.getUnit() != null) {
				Unit enemy = currentRoom.getTiles()[currentRoom.getHeroLocation().get_X() + 1][currentRoom.getHeroLocation().get_Y()].getUnit();
				Tile space = currentRoom.getTiles()[currentRoom.getHeroLocation().get_X() + 1][currentRoom.getHeroLocation().get_Y()];
				enemy.setHp( enemy.getHp() - (int)(Hero.getMelee() * .2));
				if(enemy.getHp() <= 0 ) {
					space.setUnit(null);
					space.setIcon(new ImageIcon(Image.Cobble));
				}
				Tile playerSpace = currentRoom.getHeroLocation();
				Hero.setHp( Hero.getHp() - (int) (enemy.getMelee() * .2) );
				
				//GAME OVER
				if(Hero.getHp() <= 0) {
					playerSpace.setUnit(null);
					playerSpace.setIcon(new ImageIcon(Image.Cobble));
					Hero = null;
					dispose();
				}
			}
			
			//stay in the room and move onto unoccupied tile
			if(stile != null && stile.getUnit() == null && stile.isPassable()) {
				currentRoom.getHeroLocation().setUnit(null);
				currentRoom.setHeroLocation(currentRoom.getTiles()[currentRoom.getHeroLocation().get_X() + 1][currentRoom.getHeroLocation().get_Y()]);
				currentRoom.getHeroLocation().setUnit(Hero);
			}
			
			
			currentRoom.getHeroLocation().setIcon( new ImageIcon(Image.Player ));

		}
		//up
		if(key == 'w') {
			currentRoom.getHeroLocation().setIcon( new ImageIcon(Image.Cobble));

			
			
			//attack a unit
			if( wtile != null && wtile.getUnit() != null) {
				Unit enemy = currentRoom.getTiles()[currentRoom.getHeroLocation().get_X() - 1][currentRoom.getHeroLocation().get_Y()].getUnit();
				Tile space = currentRoom.getTiles()[currentRoom.getHeroLocation().get_X() - 1][currentRoom.getHeroLocation().get_Y()];
				enemy.setHp( enemy.getHp() - (int)(Hero.getMelee() * .2));
				if(enemy.getHp() <= 0 ) {
					space.setUnit(null);
					space.setIcon(new ImageIcon(Image.Cobble));
				}
				Tile playerSpace = currentRoom.getHeroLocation();
				Hero.setHp( Hero.getHp() - (int) (enemy.getMelee() * .2) );
				
				//GAME OVER
				if(Hero.getHp() <= 0) {
					playerSpace.setUnit(null);
					playerSpace.setIcon(new ImageIcon(Image.Cobble));
					Hero = null;
					dispose();
				}
			}
			
			//stay in the room
			if(wtile != null && wtile.getUnit() == null && wtile.isPassable()) {
				currentRoom.getHeroLocation().setUnit(null);
				currentRoom.setHeroLocation(currentRoom.getTiles()[currentRoom.getHeroLocation().get_X() - 1][currentRoom.getHeroLocation().get_Y()]);
				currentRoom.getHeroLocation().setUnit(Hero);
			}
			currentRoom.getHeroLocation().setIcon( new ImageIcon(Image.Player ));

		}
		//left
		if(key == 'a') {
			currentRoom.getHeroLocation().setIcon( new ImageIcon(Image.Cobble ));

			

			
			//attack a unit
			if(atile != null &&  atile.getUnit() != null) {
				Unit enemy = currentRoom.getTiles()[currentRoom.getHeroLocation().get_X()][currentRoom.getHeroLocation().get_Y() - 1].getUnit();
				Tile space = currentRoom.getTiles()[currentRoom.getHeroLocation().get_X()][currentRoom.getHeroLocation().get_Y() - 1];
				enemy.setHp( enemy.getHp() - (int)(Hero.getMelee() * .2));
				if(enemy.getHp() <= 0 ) {
					space.setUnit(null);
					space.setIcon(new ImageIcon(Image.Cobble));
				}
				Tile playerSpace = currentRoom.getHeroLocation();
				Hero.setHp( Hero.getHp() - (int) (enemy.getMelee() * .2) );
				
				//GAME OVER
				if(Hero.getHp() <= 0) {
					playerSpace.setUnit(null);
					playerSpace.setIcon(new ImageIcon(Image.Cobble));
					Hero = null;
					dispose();
				}
			}
			//stay in the room
			if(atile != null && atile.getUnit() == null && atile.isPassable()) {
				currentRoom.getHeroLocation().setUnit(null);
				currentRoom.setHeroLocation(currentRoom.getTiles()[currentRoom.getHeroLocation().get_X()][currentRoom.getHeroLocation().get_Y() - 1]);
				currentRoom.getHeroLocation().setUnit(Hero);
			}
			
			currentRoom.getHeroLocation().setIcon( new ImageIcon(Image.Player ));

		}
		//right
		if(key == 'd') {
			currentRoom.getHeroLocation().setIcon( new ImageIcon(Image.Cobble ));

			
			//attack a unit
			if(dtile != null && dtile.getUnit() != null) {
				Unit enemy = currentRoom.getTiles()[currentRoom.getHeroLocation().get_X()][currentRoom.getHeroLocation().get_Y() + 1].getUnit();
				Tile space = currentRoom.getTiles()[currentRoom.getHeroLocation().get_X()][currentRoom.getHeroLocation().get_Y() + 1];
				enemy.setHp( enemy.getHp() - (int)(Hero.getMelee() * .2));
				if(enemy.getHp() <= 0 ) {
					space.setUnit(null);
					space.setIcon(new ImageIcon(Image.Cobble));
				}
				Tile playerSpace = currentRoom.getHeroLocation();
				Hero.setHp( Hero.getHp() - (int) (enemy.getMelee() * .2) );
				
				//GAME OVER
				if(Hero.getHp() <= 0) {
					playerSpace.setUnit(null);
					playerSpace.setIcon(new ImageIcon(Image.Cobble));
					Hero = null;
					dispose();
				}
				
			}
			
			//stay in the room
			if(dtile != null && dtile.getUnit() == null && dtile.isPassable()) {
				currentRoom.getHeroLocation().setUnit(null);
				currentRoom.setHeroLocation(currentRoom.getTiles()[currentRoom.getHeroLocation().get_X()][currentRoom.getHeroLocation().get_Y() + 1]);
				currentRoom.getHeroLocation().setUnit(Hero);
			}
			
			currentRoom.getHeroLocation().setIcon( new ImageIcon(Image.Player ));

		}
	}
	
	//enemies move
	public void keyReleased(KeyEvent e) {
		//find enemies and make them move
		for(int i = 0; i < currentRoom.getTiles().length; i++) {
			for(int j = 0; j < currentRoom.getTiles()[0].length; j++) {
				if(currentRoom.getTiles()[i][j].getUnit() != null && currentRoom.getTiles()[i][j].getUnit() != Hero) {
					Unit enemy = currentRoom.getTiles()[i][j].getUnit();
					if(!enemy.isHasMoved()) {
						Tile space = currentRoom.getTiles()[i][j];
						Tile spaceToMove = getRandomAjacentSpace(space);
						if(space != spaceToMove && spaceToMove.isPassable()) {
							space.setUnit(null);
							space.setIcon(new ImageIcon(Image.Cobble));
							spaceToMove.setIcon(new ImageIcon( Image.Goblin));
							spaceToMove.setUnit(enemy);
							enemy.setHasMoved(true);
						}
					}
				}
			}
		}
		
		//reset ability to move for next keystroke
		for(int i = 0; i < currentRoom.getTiles().length; i++) {
			for(int j = 0; j < currentRoom.getTiles()[0].length; j++) {
				if(currentRoom.getTiles()[i][j].getUnit() != null) {
					currentRoom.getTiles()[i][j].getUnit().setHasMoved(false);
				}
			}
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	//must be in bounds
	public Tile getRandomAjacentSpace(Tile currentTile) {
		int x = currentTile.get_X();
		int y = currentTile.get_Y();
		double r = Math.random();
		if(r > 0 && r < .25) {
			if(currentTile.get_X() + 1 < currentRoom.getTiles().length && currentRoom.getTiles()[currentTile.get_X() + 1][currentTile.get_Y()].getUnit() == null){
				return currentRoom.getTiles()[currentTile.get_X() + 1][currentTile.get_Y()];
			}
		}
		if(r > .25 && r < .50) {
			if(currentTile.get_X() - 1 >= 0 && currentRoom.getTiles()[currentTile.get_X() - 1][currentTile.get_Y()].getUnit() == null){
				return currentRoom.getTiles()[currentTile.get_X() - 1][currentTile.get_Y()];
			}
		}
		if(r > .50 && r < .75) {
			if(currentTile.get_Y() + 1 < currentRoom.getTiles().length && currentRoom.getTiles()[currentTile.get_X()][currentTile.get_Y() + 1].getUnit() == null){
				return currentRoom.getTiles()[currentTile.get_X()][currentTile.get_Y() + 1];
			}
		}
		if(r > .75 && r < 1.0) {
			if(currentTile.get_Y() - 1 >= 0 && currentRoom.getTiles()[currentTile.get_X()][currentTile.get_Y() - 1].getUnit() == null){
				return currentRoom.getTiles()[currentTile.get_X()][currentTile.get_Y() - 1];
			}
		}
		return currentTile;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	

}
