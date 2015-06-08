import java.awt.Color;


public class ForegroundFactory {
	public static IGameComponent create(String name, int posx, int posy, int size, KeyboardInput keyboard, CollisionDetector collisionDetector) {
		IGameComponent component = null;
		if (name.equals("Snake")) {
			component = new Snake(posx, posy, size, 5, Color.GREEN, keyboard, collisionDetector);
		} else if (name.equals("Gift")) {
			component = new Gift(posx, posy, size, Color.yellow);
		}
		return component;
	}
}
