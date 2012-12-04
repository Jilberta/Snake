import static org.junit.Assert.*;

import java.util.ArrayList;


import org.easymock.EasyMock;
import org.junit.Test;


/**
 * TODO Put here a description of what this class does.
 *
 * @author Kote.
 *         Created Dec 4, 2012.
 */
public class TestReferee {
	
	@Test
	/// when snake head is out of bounds
	public void testSnakeDeath1(){
		Board b = EasyMock.createNiceMock(Board.class);
		Snake s = EasyMock.createNiceMock(Snake.class);
		ArrayList<Cell> body = new ArrayList<Cell>();
		Cell c1 = new Cell(9, 9, -1);
		Cell c2 = new Cell(9, 10, -1);
		body.add(c1);
		body.add(c2);
		EasyMock.expect(b.getWidth()).andStubReturn(10);
		EasyMock.expect(b.getHeight()).andStubReturn(10);
		EasyMock.expect(s.getSnakeBody()).andStubReturn(body);
		EasyMock.replay(b);
		EasyMock.replay(s);
		Referee target = new Referee(b, s);
		assertFalse(target.isAlive(s));
	}
	
	@Test
	// when snake hits himself
	public void testSnakeDeath2(){
		Board b = EasyMock.createNiceMock(Board.class);
		Snake s = EasyMock.createNiceMock(Snake.class);
		ArrayList<Cell> body = new ArrayList<Cell>();
		Cell c2 = new Cell(5, 5, -1);
		Cell c3 = new Cell(6, 5, -1);
		Cell c4 = new Cell(7, 5, -1);
		Cell c5 = new Cell(7, 6, -1);
		Cell c6 = new Cell(7, 7, -1);
		Cell c7 = new Cell(6, 7, -1);
		Cell c8 = new Cell(5, 7, -1);
		Cell c9 = new Cell(5, 6, -1);
		Cell c10 = new Cell(5, 5, -1);
		body.add(c2);body.add(c3);body.add(c4);
		body.add(c5);body.add(c6);body.add(c7);
		body.add(c8);body.add(c9);body.add(c10);
		EasyMock.expect(b.getWidth()).andStubReturn(10);
		EasyMock.expect(b.getHeight()).andStubReturn(10);
		EasyMock.expect(s.getSnakeBody()).andStubReturn(body);
		EasyMock.replay(b);
		EasyMock.replay(s);
		Referee target = new Referee(b, s);
		assertFalse(target.isAlive(s));
	}
	
	@Test
	// snake is alive
	public void testSnakeALive(){
		Board b = EasyMock.createNiceMock(Board.class);
		Snake s = EasyMock.createNiceMock(Snake.class);
		ArrayList<Cell> body = new ArrayList<Cell>();
		Cell c1 = new Cell(4, 5, -1);
		Cell c2 = new Cell(5, 5, -1);
		Cell c3 = new Cell(6, 5, -1);
		Cell c4 = new Cell(7, 5, -1);
		body.add(c1);body.add(c2);body.add(c3);body.add(c4);
		EasyMock.expect(b.getWidth()).andStubReturn(9);
		EasyMock.expect(b.getHeight()).andStubReturn(8);
		EasyMock.expect(s.getSnakeBody()).andStubReturn(body);
		EasyMock.replay(b);
		EasyMock.replay(s);
		Referee target = new Referee(b, s);
		assertTrue(target.isAlive(s));
	}
	
	@Test
	public void testGetScore(){
		Board b = EasyMock.createNiceMock(Board.class);
		Snake s = EasyMock.createNiceMock(Snake.class);
		EasyMock.expect(s.getSnakeLength()).andStubReturn(11);
		EasyMock.replay(b);
		EasyMock.replay(s);
		Referee target = new Referee(b, s);
		assertEquals(8, target.getScore());
	}

}
