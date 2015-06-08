package ch.heebnet.snake.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardInput implements KeyListener {
	
	private int currentDirection;
	
	public KeyboardInput() {
		currentDirection = KeyEvent.VK_UP;
	}
	
	public int getCurrentDirection() {
		return currentDirection;
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		int newcode = arg0.getKeyCode();
		if (newcode==KeyEvent.VK_DOWN || newcode==KeyEvent.VK_UP || newcode==KeyEvent.VK_RIGHT || newcode==KeyEvent.VK_LEFT) {
			if (currentDirection==KeyEvent.VK_DOWN&&newcode==KeyEvent.VK_UP)
				return;
			if (currentDirection==KeyEvent.VK_UP&&newcode==KeyEvent.VK_DOWN)
				return;
			if (currentDirection==KeyEvent.VK_LEFT&&newcode==KeyEvent.VK_RIGHT)
				return;
			if (currentDirection==KeyEvent.VK_RIGHT&&newcode==KeyEvent.VK_LEFT)
				return;
			currentDirection = newcode;
		}
			
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
