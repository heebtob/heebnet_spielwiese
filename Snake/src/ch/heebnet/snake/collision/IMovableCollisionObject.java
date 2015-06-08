package ch.heebnet.snake.collision;
import java.awt.Point;


public interface IMovableCollisionObject {
	public boolean collides(ICollisionObject collisionObject);
	public void eat(ICollisionObject collisionObject);
	public Point getPosition();
}
