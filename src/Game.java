public class Game {

	private Board board;
	private Stat stats;
	private Snake snake;
	private Player player;
	private Gardener gardener;
	private Presenter presenter;
	private Referee referee;
	
	public Game(Board b, Stat st, Snake sn, Player pl, Gardener g, 
			Presenter pr, Referee ref) {
		this.board=b;
		this.stats=st;
		this.snake=sn;
		this.player=pl;
		this.gardener=g;
		this.referee=ref;
	}

	public void Play(){
		while(referee.isAlive(snake)){
			Direction dir = player.getDirection();
			snake.move(dir);
			gardener.addRemoveFood();
			presenter.showBoard(board);
		}
		stats.save(referee.getScore(),player.getName());
		presenter.showBoardStats(player.getName(), referee.getScore(), stats);
	}
}
