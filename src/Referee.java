import java.util.ArrayList;

public class Referee {
	
	private Board board;
	private Snake snake;
	
	public Referee(Board board, Snake snake) {
		this.board = board;
		this.snake = snake;
	}

	// Returns whether the game is still in progress.
	public boolean isAlive(Snake snake){
		ArrayList<Cell> body = (ArrayList<Cell>) snake.getSnakeBody();
		Cell head = body.get(0);
		for(int i = 0; i < body.size(); i++){
			Cell c = body.get(i);
			if(!inBounds(c) || (i != 0 && cellEquals(head, c)))return false;
		}
		return true;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param head
	 * @param c
	 * @return
	 */
	private boolean cellEquals(Cell c1, Cell c2) {
		return c1.getX() == c2.getX() && c1.getY() == c2.getY();
	}

	/**
	 * Returns true if cell is in bounds
	 *
	 * @param c
	 */
	private boolean inBounds(Cell c) {
		if(c.getX() < 0 || c.getY() < 0 || c.getX() >= board.getWidth() || c.getY() >= board.getHeight())return false;
		return true;
	}

	// Returns the score.
	public int getScore() {
		return snake.getSnakeLength() - 3;
	}
}