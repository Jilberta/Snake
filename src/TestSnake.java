import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import java.util.*;

public class TestSnake {

	private Board board;
	
	
	@Test
	public void test() {
		board = new Board(10, 10);
		Snake snake  = new Snake(board);
		assertTrue(snake.getSnakeLength() == 3);
		snake.move(Direction.moveToRight);
		snake.grow();
		Collection<Cell> col = snake.getSnakeBody();
		assertTrue(snake.getSnakeLength() == 4);
		snake.move(Direction.moveToDown);
		assertTrue(snake.getSnakeLength() == 4);
		snake.grow();
		assertTrue(snake.getSnakeLength() == 5);
		snake.move(Direction.moveToLeft);
		Iterator it = col.iterator();
		while(it.hasNext()){
			Cell a = (Cell)it.next();
			System.out.println(a.getX() + " " + a.getY());	
		}
		
	}
}
