
public class Game {
	private Referee ref;
	private Snake snake;
	private Player player;
	private Direction dir;
	private Gardener gardener;
	private Board board;
	private Presenter presenter;
	private Stat stat;

	public Game(Board b, Stat st, Snake sn, Player pl, Gardener g, Presenter pr) {
	}

	public void Play() {
		while (ref.isAlive(snake)) {
			dir = player.getDirection();
			snake.move(dir);
			gardener.addRemoveFood();
			presenter.show(board, snake, gardener);
			// pause();
		}
		stat.save(player.getName(), ref.getScore());
		presenter.showBoardStats(player.getName(), ref.getScore(), stat);

	}
}
