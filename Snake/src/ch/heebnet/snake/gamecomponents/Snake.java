package ch.heebnet.snake.gamecomponents;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import ch.heebnet.snake.collision.CollisionDetector;
import ch.heebnet.snake.collision.ICollisionObject;
import ch.heebnet.snake.collision.IMovableCollisionObject;
import ch.heebnet.snake.input.KeyboardInput;


public class Snake implements IGameComponent, IMovableCollisionObject {
	
	private LinkedList<SnakePart> snakeParts;
	private int initialLength;
	private KeyboardInput keyboard;
	
	//
	private int startposx;
	private int startposy;
	private int sidelength;
	private int arclength;
	private Color color;
	
	CollisionDetector collisionDetector;
	
	public Snake(int startposx, int startposy, int sidelength, int arclength, Color color, KeyboardInput keyboard, CollisionDetector collisionDetector) {
		this.startposx = startposx;
		this.startposy = startposy;
		this.sidelength = sidelength;
		this.arclength = arclength;
		this.color = color;
		this.initialLength = 10;
		this.keyboard = keyboard;
		this.collisionDetector = collisionDetector;
	}

	@Override
	public void draw(Graphics g) {
		Color oldcolor = g.getColor();
		g.setColor(this.color);
		for (SnakePart snakepart : this.snakeParts) {
			snakepart.draw(g);
		}
		g.setColor(oldcolor);
	}

	@Override
	public void initialize() {
		this.snakeParts = new LinkedList<SnakePart>();
		for (int i=startposy; i<(initialLength+startposy); i++) {
			SnakePart snakepart = new SnakePart(startposx,i,sidelength,arclength);
			this.snakeParts.add(snakepart);
			this.collisionDetector.registerCollisionObject(snakepart);
		}
	}

	@Override
	public void update() {
		
		// letztes Element entfernen -> kommt jetzt an den Anfang
		SnakePart tail = this.snakeParts.removeLast();
		
		this.setPositionOfNewSnakepart(tail);
		
		// letztes Element am Anfang wieder einfügen
		this.snakeParts.addFirst(tail);
	}
	
	private void setPositionOfNewSnakepart(SnakePart snakepart) {
		SnakePart head = this.snakeParts.getFirst();
		
		// Bewegung der Schlange
		switch (this.keyboard.getCurrentDirection()) {
		case KeyEvent.VK_UP:
			snakepart.setPosX(head.getPosX());
			snakepart.setPosY(head.getPosY()-1);
			break;
		case KeyEvent.VK_DOWN:
			snakepart.setPosX(head.getPosX());
			snakepart.setPosY(head.getPosY()+1);
			break;
		case KeyEvent.VK_LEFT:
			snakepart.setPosX(head.getPosX()-1);
			snakepart.setPosY(head.getPosY());
			break;
		case KeyEvent.VK_RIGHT:
			snakepart.setPosX(head.getPosX()+1);
			snakepart.setPosY(head.getPosY());
			break;
		}
	}

	@Override
	public boolean collides(ICollisionObject collisionObject) {
		SnakePart snakepart = this.snakeParts.getFirst();
		
		if (snakepart==collisionObject)
			return false;
		
		if (snakepart.getPosX()==collisionObject.getPosition().x) 
			if (snakepart.getPosY()==collisionObject.getPosition().y)
				return true;
		
		return false;
	}

	@Override
	public void eat(ICollisionObject collisionObject) {
		SnakePart snakepart = new SnakePart(0,0,sidelength,arclength);
		this.setPositionOfNewSnakepart(snakepart);
		this.collisionDetector.registerCollisionObject(snakepart);
		this.snakeParts.addLast(snakepart);
	}

	public LinkedList<SnakePart> getSnakeParts() {
		return snakeParts;
	}

	@Override
	public Point getPosition() {
		return this.snakeParts.getFirst().getPosition();
	}

}
