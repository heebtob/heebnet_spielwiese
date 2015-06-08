import java.awt.Point;


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
