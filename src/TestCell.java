import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>CellTest</code> contains tests for the class <code>{@link Cell}</code>.
 *
 * @generatedBy CodePro at 12/4/12 9:41 PM
 * @author Hashimashi
 * @version $Revision: 1.0 $
 */
public class TestCell {
	/**
	 * Run the Cell(int,int,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/12 9:41 PM
	 */
	@Test
	public void testCell_1()
		throws Exception {
		int x = 3;
		int y = 5;
		int value = 0;

		Cell result = new Cell(x, y, value);

		assertNotNull(result);
		assertEquals(0, result.getValue());
		assertEquals(3, result.getX());
		assertEquals(5, result.getY());
	}

	/**
	 * Run the int getValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/12 9:41 PM
	 */
	@Test
	public void testGetValue_1()
		throws Exception {
		Cell fixture = new Cell(1, 1, 13);

		int result = fixture.getValue();

		assertEquals(13, result);
	}

	/**
	 * Run the int getX() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/12 9:41 PM
	 */
	@Test
	public void testGetX_1()
		throws Exception {
		Cell fixture = new Cell(20000, 1, 1);

		int result = fixture.getX();

		assertEquals(20000, result);
	}

	/**
	 * Run the int getY() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 12/4/12 9:41 PM
	 */
	@Test
	public void testGetY_1()
		throws Exception {
		Cell fixture = new Cell(1, 374, 1);

		int result = fixture.getY();

		assertEquals(374, result);
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 12/4/12 9:41 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TestCell.class);
	}
}