package edu.unm.cs583;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VelocityTester {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	/** public void test() {
		fail("Not yet implemented"); **/
	public void testSetDirection() {
		Velocity out = new Velocity();
		   out.setDirection(45);
		   assertEquals("Result", 45, out.getDirection());
		}
	
	@Test
	public void testReverseX()	{
		Velocity v;
		
		// positive test cases
		v = new Velocity(100, 0);
		v.reverseX();
		assertEquals(-100, v.getSpeedX());
		assertEquals(180, v.getDirection());
	
		
		v = new Velocity(0, 0);
		v.reverseX();
		assertEquals(0, v.getSpeedX());
		assertEquals(180, v.getDirection());
		
		
		v = new Velocity(100, 45);
		v.reverseX();
		assertEquals(-71, v.getSpeedX());
		assertEquals(135, v.getDirection());
		
		
		v = new Velocity(50, 200);
		v.reverseX();
		assertEquals(47, v.getSpeedX());
		assertEquals(340, v.getDirection());
		
		// negative test case
		v = new Velocity(-100, 0);
		v.reverseX();
		assertEquals(100, v.getSpeedX());
		assertEquals(180, v.getDirection());
	}

}