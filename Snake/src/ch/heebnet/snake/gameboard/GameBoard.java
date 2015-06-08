package ch.heebnet.snake.gameboard;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import ch.heebnet.snake.collision.CollisionDetector;
import ch.heebnet.snake.collision.ICollisionObject;
import ch.heebnet.snake.gamecomponents.Gift;
import ch.heebnet.snake.gamecomponents.IGameComponent;
import ch.heebnet.snake.gamecomponents.Snake;
import ch.heebnet.snake.input.KeyboardInput;

public class GameBoard extends JPanel {

	private ArrayList<IGameComponent> backgroundComponents;
	private ArrayList<IGameComponent> foregroundComponents;
	
	private int horizontaleKacheln;
	private int vertikaleKacheln;

	private boolean isInitialized;
	private boolean isGameOver;
	
	private CollisionDetector collisionDetector;

	public GameBoard(int horizontaleKacheln, int vertikaleKacheln, KeyboardInput keyboard) {
		this.isGameOver = false;
		
		this.horizontaleKacheln = horizontaleKacheln;
		this.vertikaleKacheln = vertikaleKacheln;
		this.backgroundComponents = new ArrayList<IGameComponent>();
		this.foregroundComponents = new ArrayList<IGameComponent>();
		
		this.collisionDetector = new CollisionDetector();

		for (int i = 0; i < this.horizontaleKacheln; i++) {
			for (int a = 0; a < this.vertikaleKacheln; a++) {
				this.backgroundComponents.add(BackgroundFactory.create(
						"StandardTile", i, a, 20, Color.gray, false));
			}
		}
		
		Snake snake = (Snake)ForegroundFactory.create("Snake", 5, 5, 20, keyboard, collisionDetector);
		this.collisionDetector.setMovableObject(snake);
		this.foregroundComponents.add(snake);
		
		Gift gift = (Gift)ForegroundFactory.create("Gift", 10, 5, 20, keyboard, collisionDetector);
		this.collisionDetector.registerCollisionObject((ICollisionObject)gift);
		this.foregroundComponents.add(gift);

		this.isInitialized = false;
	}

	public void initialize() {

		for (IGameComponent component : this.backgroundComponents) {
			component.initialize();
		}
		for (IGameComponent component : this.foregroundComponents) {
			component.initialize();
		}

		this.isInitialized = true;
	}

	public void update(double deltatime) {
		if (isInitialized) {

			
			for (IGameComponent component : this.backgroundComponents) {
				component.update();
			}
			for (IGameComponent component : this.foregroundComponents) {
				component.update();
			}
			
			ICollisionObject collisionObject = this.collisionDetector.detectCollisions();
			if (collisionObject!=null) {
				if (collisionObject.isDeadly()) {
					this.isGameOver = true;
					System.out.println("GAME OVER");
				}
				if (collisionObject.isEatable()) {
					this.collisionDetector.getMovableObject().eat(collisionObject);
					collisionObject.collided();
				}
			}
		}
	}

	public void paint(Graphics g) {
		if (isInitialized) {
			for (IGameComponent component : this.backgroundComponents) {
				component.draw(g);
			}
			for (IGameComponent component : this.foregroundComponents) {
				component.draw(g);
			}
		}
	}

	public boolean isGameOver() {
		System.out.println("isgameover "+this.isGameOver);
		return isGameOver;
	}

}
