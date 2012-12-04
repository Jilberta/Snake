import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BoardTest</code> contains tests for the class <code>{@link Board}</code>.
 *
 * @generatedBy CodePro at 12/4/12 9:46 PM
 * @author Hashimashi
 * @version $Revision: 1.0 $
 */
public class TestBoard {
	/**
	 * Run the Board(int,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/12 9:46 PM
	 */
	@Test
	public void testBoard_1()
		throws Exception {
		int rows = 1;
		int cols = 1;

		Board result = new Board(rows, cols);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getHeight());
		assertEquals(1, result.getWidth());
	}

	/**
	 * Run the Cell getCellAt(int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/12 9:46 PM
	 */
	@Test
	public void testGetCellAt_1()
		throws Exception {
		Board fixture = new Board(1, 1);
		int x = 0;
		int y = 0;

		Cell result = fixture.getCellAt(x, y);

		assertNotNull(result);
	}

	/**
	 * Run the int getHeight() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/12 9:46 PM
	 */
	@Test
	public void testGetHeight_1()
		throws Exception {
		Board fixture = new Board(13, 15);

		int result = fixture.getHeight();

		assertEquals(13, result);
	}

	/**
	 * Run the int getWidth() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/12 9:46 PM
	 */
	@Test
	public void testGetWidth_1()
		throws Exception {
		Board fixture = new Board(23, 100);

		int result = fixture.getWidth();

		assertEquals(100, result);
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 12/4/12 9:46 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TestBoard.class);
	}
}