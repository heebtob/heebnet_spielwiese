import javax.swing.JFrame;


public class Game {
	
	GameBoard board;
	JFrame window;
	
	public Game() {
		
	}
	
	public void initialize() {
		window = new JFrame("Snake");
		window.setBounds(100, 100, 500, 500);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		KeyboardInput keyboard = new KeyboardInput();
		window.addKeyListener(keyboard);
		
		board = new GameBoard(20,20,keyboard);
		board.initialize();
		window.add(board);

	}
	
	public void gameloop() {
		long currentMillis;
		long oldMillis = System.currentTimeMillis();
		long deltaMillis;
		
		while (!this.board.isGameOver()) {
			currentMillis = System.currentTimeMillis();
			deltaMillis = currentMillis-oldMillis;
			oldMillis = currentMillis;
			
			board.update(deltaMillis);
			
			if (this.board.isGameOver()) {
				break;
			}
			
			window.invalidate();
			window.repaint();
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.initialize();
		game.gameloop();
	}

}
