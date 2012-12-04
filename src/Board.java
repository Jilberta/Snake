public class Board {

	private Cell[][] board;
	private int rows;
	private int cols;
	// qmnis dafas, romelic aris Cell-ebis 2-d array
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		board = new Cell[rows][cols];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				board[i][j] = new Cell(i, j, 0);
			}
		}
	}
	
	public Cell getCellAt(int x, int y) {
		return board[x][y];
	}

	public int getWidth() {
		return cols;
	}

	public int getHeight() {
		return rows;
	}
}
