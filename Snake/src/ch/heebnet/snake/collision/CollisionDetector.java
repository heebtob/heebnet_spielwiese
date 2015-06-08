package ch.heebnet.snake.collision;
import java.awt.Point;
import java.util.ArrayList;

import ch.heebnet.snake.gamecomponents.Wall;


public class CollisionDetector {
	
	private ArrayList<ICollisionObject> collisionList;
	private IMovableCollisionObject movingObject;
	
	public CollisionDetector() {
		collisionList = new ArrayList<ICollisionObject>();
	}
	
	public void registerCollisionObject(ICollisionObject collisionObject) {
		this.collisionList.add(collisionObject);
	}
	
	public void setMovableObject(IMovableCollisionObject movingObject) {
		this.movingObject = movingObject;
	}
	
	public IMovableCollisionObject getMovableObject() {
		return this.movingObject;
	}
	
	public ICollisionObject detectCollisions() {
		Point position = this.movingObject.getPosition();
		if (position.x<0 || position.y<0 || position.y>19 || position.x > 19){
			return new Wall();
		}
			
		for (ICollisionObject collisionObject : this.collisionList) {
			if (movingObject.collides(collisionObject)) {
				return collisionObject;
			}
		}
		return null;
	}

}
