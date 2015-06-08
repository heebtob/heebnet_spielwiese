package ch.heebnet.snake.gamecomponents;
import java.awt.Color;
import java.awt.Graphics;


public class Kachel implements IGameComponent {
	
	private boolean isDeadly;
	private Color color;
	
	private int posx;
	private int posy;
	private int sidelength;
	
	public Kachel(int posx, int posy, int sidelength, Color color, boolean isDeadly) {
		this.isDeadly = isDeadly;
		this.color = color;
		this.posx = posx;
		this.posy = posy;
		this.sidelength = sidelength;
	}
	
	@Override
	public void draw(Graphics g) {
		Color oldcolor = g.getColor();
		g.setColor(this.color);
		g.drawRect(posx*sidelength, posy*sidelength, sidelength, sidelength);
		g.setColor(oldcolor);
	}
	
	@Override
	public void initialize() {
		
	}

	@Override
	public void update() {
		
	}
	
	public boolean isDeadly() {
		return isDeadly;
	}

	public void setDeadly(boolean isDeadly) {
		this.isDeadly = isDeadly;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
