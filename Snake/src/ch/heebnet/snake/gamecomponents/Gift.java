package ch.heebnet.snake.gamecomponents;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import ch.heebnet.snake.collision.ICollisionObject;


public class Gift implements IGameComponent, ICollisionObject {
	
	private int posx;
	private int posy;
	private int sidelength;
	private Color color;
	
	public Gift(int posx, int posy, int sidelength, Color color) {
		this.posx = posx;
		this.posy = posy;
		this.sidelength = sidelength;
		this.color = color;
	}

	@Override
	public void initialize() {
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics g) {
		Color oldcolor = g.getColor();
		g.setColor(this.color);
		g.fillRect((int)(posx*sidelength+sidelength*0.1), (int)(posy*sidelength+sidelength*0.1), (int)(sidelength*0.8), (int)(sidelength*0.8));
		g.setColor(oldcolor);
	}

	@Override
	public Point getPosition() {
		return new Point(this.posx, this.posy);
	}

	@Override
	public boolean isDeadly() {
		return false;
	}

	@Override
	public boolean isEatable() {
		return true;
	}

	@Override
	public void collided() {
		this.posx = (int)(Math.random()*20);
		this.posy = (int)(Math.random()*20);
	}

}
