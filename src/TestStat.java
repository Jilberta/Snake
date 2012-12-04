import static org.junit.Assert.*;

import org.junit.Test;


public class TestStat {

	@Test
	public void test() {
		Stat s = new Stat();
		s.save(5,"kervala");
		System.out.println(s.getTop5List().get(0));
		assertEquals(s.getTop5List().get(0),"kervala 5");
		s.save(15,"kervalaa");
		s.save(18,"kervalaa");
		s.save(19,"kervalaa");
		s.save(25,"kervalaa");
		s.save(39,"kervalaa");

	}

}
