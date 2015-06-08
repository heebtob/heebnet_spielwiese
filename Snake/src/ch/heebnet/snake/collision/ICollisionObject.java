package ch.heebnet.snake.collision;
import java.awt.Point;


public interface ICollisionObject {
	public Point getPosition();
	public boolean isDeadly();
	public boolean isEatable();
	public void collided();
}
