package ch.heebnet.snake.gamecomponents;
import java.awt.Graphics;
import java.awt.Point;

import ch.heebnet.snake.collision.ICollisionObject;


public class SnakePart implements ICollisionObject  {
	
	private int posx;
	private int posy;
	private int sidelength;
	private int arclength;
	
	public SnakePart(int posx, int posy, int sidelength, int arclength) {
		this.posx = posx;
		this.posy = posy;
		this.sidelength = sidelength;
		this.arclength = arclength;
	}

	public void draw(Graphics g) {
		g.fillRoundRect((int)(posx*sidelength+sidelength*0.1), (int)(posy*sidelength+sidelength*0.1), (int)(sidelength*0.8), (int)(sidelength*0.8), arclength, arclength);
	}
	
	public int getPosX() {
		return posx;
	}

	public void setPosX(int posx) {
		this.posx = posx;
	}

	public int getPosY() {
		return posy;
	}

	public void setPosY(int posy) {
		this.posy = posy;
	}

	@Override
	public Point getPosition() {
		return new Point(this.posx,this.posy);
	}

	@Override
	public boolean isDeadly() {
		return true;
	}

	@Override
	public boolean isEatable() {
		return false;
	}

	@Override
	public void collided() {
		
	}

}
