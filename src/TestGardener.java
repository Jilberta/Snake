import static org.junit.Assert.*;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Test;


public class TestGardener {
	
	@Test
	public void testSnakeEating1(){
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
		EasyMock.expect(b.getWidth()).andStubReturn(100);
		EasyMock.expect(b.getHeight()).andStubReturn(100);
		EasyMock.expect(s.getSnakeBody()).andStubReturn(body);
		EasyMock.expect(s.getSnakeLength()).andStubReturn(body.size());
		EasyMock.replay(b);
		EasyMock.replay(s);
		
		Gardener garden = new Gardener(b, s);
		assertFalse(s.getSnakeBody().contains(garden.getFoodCell()));
	}
	
	@Test
	public void testSnakeEating2(){
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
		
		EasyMock.expect(b.getWidth()).andStubReturn(100);
		EasyMock.expect(b.getHeight()).andStubReturn(100);
		EasyMock.expect(s.getSnakeBody()).andStubReturn(body);
		EasyMock.expect(s.getSnakeLength()).andStubReturn(body.size());
		EasyMock.replay(b);
		EasyMock.replay(s);
		
		Gardener garden = new Gardener(b, s);
		Cell cl = garden.getFoodCell();
		body.add(cl);
		
		assertTrue(s.getSnakeBody().contains(garden.getFoodCell()));
	}
	
	@Test
	public void testAddRemoveFood(){
		Board b = EasyMock.createNiceMock(Board.class);
		Snake s = EasyMock.createNiceMock(Snake.class);
		ArrayList<Cell> body = new ArrayList<Cell>();
		Cell c2 = new Cell(5, 5, -1);
		Cell c3 = new Cell(6, 5, -1);
		body.add(c2);
		body.add(c3);
		EasyMock.expect(b.getWidth()).andStubReturn(100);
		EasyMock.expect(b.getHeight()).andStubReturn(100);
		EasyMock.expect(s.getSnakeBody()).andStubReturn(body);
		EasyMock.expect(s.getSnakeLength()).andStubReturn(body.size());
		EasyMock.replay(b);
		EasyMock.replay(s);
		
		Gardener garden = new Gardener(b, s);
		Cell cl = garden.getFoodCell();
		body.add(cl);
		
		assertTrue(s.getSnakeBody().contains(garden.getFoodCell()));
		garden.addRemoveFood();
		assertFalse(s.getSnakeBody().contains(garden.getFoodCell()));
	}
}
