package ch.heebnet.snake.gamecomponents;
import java.awt.Point;

import ch.heebnet.snake.collision.ICollisionObject;


public class Wall implements ICollisionObject {

	@Override
	public Point getPosition() {
		return null;
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
