import java.util.ArrayList;
import java.util.Random;

public class Gardener {
	private Cell cell;
	private Board board;
	private Snake snake;
	private ArrayList<Cell> snakeList;

	/**
	 * Constructor
	 * @param b
	 * @param snake
	 */
	public Gardener(Board b, Snake snake) {
		this.board = b;
		this.snake = snake;
		this.cell = getRandomCellFood();
	}

	/**
	 * amowmebs, gvelma tu aigo sachmeli, agebis shemtxvevashi, cvlis
	 * statistikas, irchevs random ujras, ise ro ar daemtxves snake-s da cell
	 * mianichebs axal mnishvnelobas.
	 */
	public void addRemoveFood() {
		if(checkSnakeEating()){
			Cell cl = getRandomCellFood();
			this.cell = new Cell(cl.getX(), cl.getY(), cl.getValue());
		}	
	}
	
	/**
	 * Choose Random Cell and Return it as the food
	 * 
	 * @return Cell
	 */
	private Cell getRandomCellFood(){
		Random random = new Random();
		snakeList = (ArrayList<Cell>) snake.getSnakeBody();
		int width = 0;
		int height = 0;
		Cell newCell;
		while(true){
			width = random.nextInt(board.getWidth()-1);
			height = random.nextInt(board.getHeight()-1);
			newCell = new Cell(width, height, 5);
			if(!snakeList.contains(newCell))break;
		}
		
		return newCell;
	}
	
	/**
	 * Checks if the head of the snake is on the Food Cell
	 * 
	 * @return boolean
	 */
	private boolean checkSnakeEating(){
		if(checkCellEqual(snakeList.get(0), getFoodCell()))return true;
		return false;
	}
	
	private boolean checkCellEqual(Cell c1, Cell c2){
		if(c1.getX() == c2.getY() && c1.getY() == c2.getY())return true;
		return false;
	}

	/**
	 * abrunebs cells
	 */
	public Cell getFoodCell() {
		return this.cell;
	}

}
