import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//the local  map
public class Room extends JPanel implements KeyListener{

	private Tile[][] tiles;
	
	private Playable Hero;
	
	private Tile heroLocation;
	
	private Tile lastHeroLocation = null;
	
	
	Room(int sqr){
		
		try{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch(Exception e) {}
		
		this.setSize(500, 500);
		this.setTiles(new Tile[sqr][sqr]);
		this.setLayout(new GridLayout( sqr, sqr));
		this.setFocusable(true);
		this.addKeyListener(this);
		
		for(int i = 0 ; i < sqr ; i++) {
			
			for(int j = 0 ; j < sqr ; j++) {
	
				getTiles()[i][j] = new Tile(Image.Cobble, i,j, true);
				this.add(getTiles()[i][j]);
			}
			
		}
		
		//add hero
		Item[] inven = {null, new Item(Image.SmallHealth, -1, -1), null, null};
		Hero = new Playable(Image.Player,3, 3, inven, 9 ,5 ,5 ,5 ,5 ,5 ,5 );
		
		
		//place the character on the game board
		
		this.setHeroLocation(this.getTiles()[3][3]);
		this.getHeroLocation().setUnit(Hero);
		
		this.setVisible(true);
	
	}
	
	Room(int width, int height){
		
		try{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch(Exception e) {}
		
		this.setSize(600, 500);
		this.setTiles(new Tile[width][height]);
		this.setLayout(new GridLayout( width, height));
		this.setFocusable(true);
		this.addKeyListener(this);
		
		for(int i = 0 ; i < width ; i++) {
			
			for(int j = 0 ; j < height ; j++) {
	
				getTiles()[i][j] = new Tile(Image.Cobble, i, j, true);
				this.add(getTiles()[i][j]);

				
			}
			
		}
		
		//make character
		Item[] inven = {null, new Item(Image.SmallHealth, -1, -1), null, null};
		Hero = new Playable(Image.Player,3, 3, inven, 9 ,5 ,5 ,5 ,5 ,5 ,5 );
		
		
		
		//place the character on the game board
		
		this.setHeroLocation(this.getTiles()[3][3]);
		this.getHeroLocation().setUnit(Hero);
		
		//place an item
		this.getTiles()[10][10].setItem(new Item(Image.SmallHealth, 10, 10));
		
		//place an enemy
		this.getTiles()[11][11].setUnit(new Unit(Image.Goblin, 11, 11));
		this.getTiles()[12][12].setUnit(new Unit(Image.Goblin, 12, 12));
		this.getTiles()[13][13].setUnit(new Unit(Image.Goblin, 13, 13));
		
		//place a wall
		this.getTiles()[14][14].setPassable(false);
		this.getTiles()[14][14].setIcon(new ImageIcon(Image.Wall));
		
		this.setVisible(true);
	
	}
	
	
	//handles movement of player
	public void keyPressed(KeyEvent e) {
		char key = e.getKeyChar();
		
		Tile stile = null;
		Tile wtile = null;
		Tile atile = null;
		Tile dtile = null;
		if(this.getHeroLocation().get_X() + 1 < this.getTiles().length) {
			stile = this.getTiles()[this.getHeroLocation().get_X() + 1][this.getHeroLocation().get_Y()];
		}
		if(this.getHeroLocation().get_X() - 1 >= 0) {
			wtile = this.getTiles()[this.getHeroLocation().get_X() - 1][this.getHeroLocation().get_Y()];
		}
		if(this.getHeroLocation().get_Y() - 1 >= 0) {
			atile = this.getTiles()[this.getHeroLocation().get_X()][this.getHeroLocation().get_Y() - 1];
		}
		if(this.getHeroLocation().get_Y() + 1 < this.getTiles()[0].length ) {
			dtile = this.getTiles()[this.getHeroLocation().get_X()][this.getHeroLocation().get_Y() + 1];
		}
		//down
		if(key == 's') {
			
			//attack
			if( stile != null && stile.getUnit() != null) {
				Unit enemy = stile.getUnit();
				//Put a formula here later
				enemy.setHp(enemy.getHp() - 1);
				getHero().setHp(getHero().getHp() - 1);
				if(enemy.getHp() <= 0) {
					stile.setUnit(null);
				}
				if(getHero().getHp() <= 0) {
					getHeroLocation().setUnit(null);
					setHeroLocation(null);
					setHero(null);
				}
				
			}

			//move
			if( stile != null && stile.getUnit() == null && stile.isPassable()) {
				setHeroLocation(stile);
			}

		}
		//up
		if(key == 'w') {

			
			//attack
			if( wtile != null && wtile.getUnit() != null) {
				Unit enemy = wtile.getUnit();
				//Put a formula here later
				enemy.setHp(enemy.getHp() - 1);
				getHero().setHp(getHero().getHp() - 1);
				if(enemy.getHp() <= 0) {
					wtile.setUnit(null);
				}
				if(getHero().getHp() <= 0) {
					getHeroLocation().setUnit(null);
					setHeroLocation(null);
					setHero(null);
				}
				
			}

			//move
			if( wtile != null && wtile.getUnit() == null && wtile.isPassable()) {
				setHeroLocation(wtile);
			}

		}
		//left
		if(key == 'a') {
	
			//attack
			if( atile != null && atile.getUnit() != null) {
				Unit enemy = atile.getUnit();
				//Put a formula here later
				enemy.setHp(enemy.getHp() - 1);
				getHero().setHp(getHero().getHp() - 1);
				if(enemy.getHp() <= 0) {
					atile.setUnit(null);
				}
				if(getHero().getHp() <= 0) {
					getHeroLocation().setUnit(null);
					setHeroLocation(null);
					setHero(null);
				}
				
			}

			//move
			if( atile != null && atile.getUnit() == null && atile.isPassable()) {
				setHeroLocation(atile);
			}
		}
		//right
		if(key == 'd') {
			
			//attack
			if( dtile != null && dtile.getUnit() != null) {
				Unit enemy = dtile.getUnit();
				//Put a formula here later
				enemy.setHp(enemy.getHp() - 1);
				getHero().setHp(getHero().getHp() - 1);
				if(enemy.getHp() <= 0) {
					dtile.setUnit(null);
				}
				if(getHero().getHp() <= 0) {
					getHeroLocation().setUnit(null);
					setHeroLocation(null);
					setHero(null);
				}
				
			}

			//move
			if( dtile != null && dtile.getUnit() == null && dtile.isPassable()) {
				setHeroLocation(dtile);
			}
		}
	}
	
	
	
	
	
	//enemies move
	public void keyReleased(KeyEvent e) {
		//find enemies and make them move
		for(int i = 0; i < this.getTiles().length; i++) {
			for(int j = 0; j < this.getTiles()[0].length; j++) {
				if(this.getTiles()[i][j].getUnit() != null && this.getTiles()[i][j].getUnit() != Hero) {
					Unit enemy = this.getTiles()[i][j].getUnit();
					if(!enemy.isHasMoved()) {
						Tile space = this.getTiles()[i][j];
						Tile spaceToMove = getRandomAjacentSpace(space);
						if(space != spaceToMove && spaceToMove.isPassable() && (spaceToMove.getUnit() == null || spaceToMove.getUnit() != getHero())){
							space.setUnit(null);
							space.updateGraphic();
							spaceToMove.setUnit(enemy);
							enemy.setHasMoved(true);
							
						}
					}
				}
			}
		}
		
		//reset ability to move for next keystroke
		for(int i = 0; i < this.getTiles().length; i++) {
			for(int j = 0; j < this.getTiles()[0].length; j++) {
				if(this.getTiles()[i][j].getUnit() != null) {
					this.getTiles()[i][j].getUnit().setHasMoved(false);
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
			if(currentTile.get_X() + 1 < this.getTiles().length && this.getTiles()[currentTile.get_X() + 1][currentTile.get_Y()].getUnit() == null){
				return this.getTiles()[currentTile.get_X() + 1][currentTile.get_Y()];
			}
		}
		if(r > .25 && r < .50) {
			if(currentTile.get_X() - 1 >= 0 && this.getTiles()[currentTile.get_X() - 1][currentTile.get_Y()].getUnit() == null){
				return this.getTiles()[currentTile.get_X() - 1][currentTile.get_Y()];
			}
		}
		if(r > .50 && r < .75) {
			if(currentTile.get_Y() + 1 < this.getTiles().length && this.getTiles()[currentTile.get_X()][currentTile.get_Y() + 1].getUnit() == null){
				return this.getTiles()[currentTile.get_X()][currentTile.get_Y() + 1];
			}
		}
		if(r > .75 && r < 1.0) {
			if(currentTile.get_Y() - 1 >= 0 && this.getTiles()[currentTile.get_X()][currentTile.get_Y() - 1].getUnit() == null){
				return this.getTiles()[currentTile.get_X()][currentTile.get_Y() - 1];
			}
		}
		return currentTile;
	}

	
	
	
	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public Tile getHeroLocation() {
		return heroLocation;
	}

	public void setHeroLocation(Tile heroLocation) {
		if(lastHeroLocation != null) {
			lastHeroLocation.setUnit(null);
		}
		if(getHeroLocation() != null) {
			getHeroLocation().setUnit(null);
		}
		this.lastHeroLocation = getHeroLocation();
		this.heroLocation = heroLocation;
		getHeroLocation().setUnit(getHero());
	}

	public Playable getHero() {
		return Hero;
	}

	public void setHero(Playable hero) {
		Hero = hero;
	}

}
