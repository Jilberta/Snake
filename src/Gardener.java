import java.util.ArrayList;
import java.util.Random;

public class Gardener {
	private Cell cell;
	private Board board;
	private Snake snake;
	private ArrayList<Cell> snakeList;

	public Gardener(Board b, Snake snake) {
		this.board = b;
		this.snake = snake;
		snakeList = (ArrayList<Cell>) snake.getSnakeBody();
		addRemoveFood();
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
	
	private Cell getRandomCellFood(){
		Random random = new Random();
		int width = 0;
		int height = 0;
		Cell newCell;
		while(true){
			width = random.nextInt(board.getWidth());
			height = random.nextInt(board.getHeight());
			newCell = new Cell(width, height, 5);
			if(!snakeList.contains(newCell))break;
		}
		
		return newCell;
	}
	
	private boolean checkSnakeEating(){
		if(snakeList.get(0).equals(getFoodCell()))return true;
		return false;
	}

	/**
	 * abrunebs cells
	 */
	public Cell getFoodCell() {
		return this.cell;
	}

}
