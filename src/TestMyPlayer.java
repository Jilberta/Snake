import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import javax.swing.Box;

import org.junit.Before;
import org.junit.Test;


public class TestMyPlayer {
	@Test
	public void testMyPlayer(){

		MyPlayer mp = new MyPlayer();

		// add additional test code here
		assertNotNull(mp);
		assert(mp.getName().getClass() == String.class);
	}

	@Test
	public void testGetDirection() {
		MyPlayer fixture = new MyPlayer();

		Direction result = fixture.getDirection();

		assertNotNull(result);
		assert(result == Direction.moveToRight);
	}

	@Test
	public void testGetName_1(){
		MyPlayer fixture = new MyPlayer();

		String result = fixture.getName();

		assert(result != null);
	}

	@Test
	public void testKeyPressed_1(){
		MyPlayer p = new MyPlayer();
		KeyEvent up = new KeyEvent(Box.createGlue(), KeyEvent.KEY_PRESSED, 0L, 1, 38);
		
		p.keyPressed(up);
		assert(p.getDirection() != Direction.moveToUp);
		
	}

	@Test
	public void testKeyPressed_2(){
		MyPlayer p = new MyPlayer();
		KeyEvent down = new KeyEvent(Box.createGlue(), KeyEvent.KEY_PRESSED, 0L, 1, 40);
		
		p.keyPressed(down);
		assert(p.getDirection() != Direction.moveToDown);
		
	}

	@Test
	public void testKeyPressed_3(){
		MyPlayer p = new MyPlayer();
		KeyEvent right = new KeyEvent(Box.createGlue(), KeyEvent.KEY_PRESSED, 0L, 1, 39);
		
		p.keyPressed(right);
		assert(p.getDirection() != Direction.moveToRight);
		
	}

	@Test
	public void testKeyPressed_4(){
		MyPlayer p = new MyPlayer();
		KeyEvent left = new KeyEvent(Box.createGlue(), KeyEvent.KEY_PRESSED, 0L, 1, 37);
		
		p.keyPressed(left);
		assert(p.getDirection() != Direction.moveToRight);
		
	}

}
