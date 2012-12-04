import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;

public class Snake {
	
	private Deque<Cell> body;
	private Direction dir;
	private Cell tale;
	private boolean alive;
	
	public Snake(Board b) {
		body = new ArrayDeque<Cell>();
		int height = b.getHeight();
		int width = b.getWidth();
		Cell a = new Cell(height/2, width/2, 0);
		Cell d = new Cell(height/2, width/2 + 1, 0);
		Cell c = new Cell(height/2, width/2 + 2, 0);
		body.addFirst(c); body.addFirst(d); body.addFirst(a);
		dir = Direction.moveToLeft;
		tale = body.getFirst();
		alive = true;
	}
	
	

	// Grows the snake.
	public void grow() {
		body.addFirst(tale);
		
	}

	/**
	 * @return length of the snake
	 */
	public int getSnakeLength() {
		return body.size();
	}

	/**
	 * @return true if snake is alvie
	 */
	public boolean isSnakeAlive() { //es rad unda am klass ver mivxvdi mara tu amas abrunebs mashin
									//setAlive metodic unda romelsac dabla mivamateb
		return alive;
	}
	
	
	
	public void setAlive(boolean bool){
		alive = bool;
	}

	/**
	 * 
	 * @param direction
	 *            moves snake by one step to given direction
	 */
	public void move(Direction direction) {
		if(direction.equals(dir)) return;
		tale = body.removeFirst();
		
		Cell head = body.getLast();
		System.out.println(body.size());
		
		if(direction.equals(Direction.moveToRight)){
			body.addLast(new Cell(head.getX(), head.getY() + 1, head.getValue()));
			dir = Direction.moveToLeft;
			
		}else if(direction.equals(Direction.moveToLeft)){
			body.addLast(new Cell(head.getX(), head.getY() - 1, head.getValue()));
			dir = Direction.moveToRight;
			
		}else if(direction.equals(Direction.moveToUp)){
			body.addLast(new Cell(head.getX() - 1, head.getY(), head.getValue()));
			dir = Direction.moveToDown;
		
		}else if(direction.equals(Direction.moveToDown)){
			body.addLast(new Cell(head.getX() + 1, head.getY(), head.getValue()));
			dir = Direction.moveToUp;
		}
	}

	/**
	 * 
	 * @return list of all dots which is covered by snake the first element is a
	 *         head of the snake
	 */
	public Collection<Cell> getSnakeBody() {
		return body;
	}

}