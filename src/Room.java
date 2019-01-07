import javax.swing.*;
import java.awt.*;

//the local  map
public class Room extends JPanel{

	private Tile[][] tiles;
	
	private Tile heroLocation;
	
	private Tile lastHeroLocation = null;
	
	
	Room(int sqr){
		
		try{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch(Exception e) {}
		
		this.setSize(500, 500);
		this.setTiles(new Tile[sqr][sqr]);
		this.setLayout(new GridLayout( sqr, sqr));
		
		for(int i = 0 ; i < sqr ; i++) {
			
			for(int j = 0 ; j < sqr ; j++) {
	
				getTiles()[i][j] = new Tile(Image.Cobble, i,j, true);
				this.add(getTiles()[i][j]);
			}
			
		}
		this.setVisible(true);
	
	}
	
	Room(int width, int height){
		
		try{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch(Exception e) {}
		
		this.setSize(500, 500);
		this.setTiles(new Tile[width][height]);
		this.setLayout(new GridLayout( width, height));
		
		for(int i = 0 ; i < width ; i++) {
			
			for(int j = 0 ; j < height ; j++) {
	
				getTiles()[i][j] = new Tile(Image.Cobble, i, j, true);
				this.add(getTiles()[i][j]);

				
			}
			
		}
		this.setVisible(true);
	
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
		this.lastHeroLocation = this.heroLocation;
		this.heroLocation = heroLocation;
	}
	
}
