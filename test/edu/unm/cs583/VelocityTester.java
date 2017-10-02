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
	
	public void testReverseY()	{
		Velocity v;
		
		// positive test cases
		v = new Velocity(0, 90);
		v.reverseY();
		assertEquals(0, v.getSpeedY());
		assertEquals(270, v.getDirection());
		
		v = new Velocity(100, 0);
		v.reverseY();
		assertEquals(0, v.getSpeedY());
		assertEquals(0, v.getDirection());
		
		v = new Velocity(100, 90);
		v.reverseY();
		assertEquals(-99, v.getSpeedY());
		assertEquals(270, v.getDirection());
		
		v = new Velocity(100, 360);
		v.reverseY();
		assertEquals(6, v.getSpeedY());
		assertEquals(0, v.getDirection());
		
		v = new Velocity(100, 480);
		v.reverseY();
		assertEquals(-90, v.getSpeedY());
		assertEquals(-120, v.getDirection());
		
		
		// negative test cases
		v = new Velocity(-100, 0);
		v.reverseY();
		assertEquals(0, v.getSpeedY());
		assertEquals(0, v.getDirection());
		
		v = new Velocity(-100, 90);
		v.reverseY();
		assertEquals(99, v.getSpeedY());
		assertEquals(270, v.getDirection());
		
		v = new Velocity(-100, 360);
		v.reverseY();
		assertEquals(-6, v.getSpeedY());
		assertEquals(0, v.getDirection());
		
		v = new Velocity(-100, 480);
		v.reverseY();
		assertEquals(90, v.getSpeedY());
		assertEquals(-120, v.getDirection());
	}

	/**
	 * public void test() { fail("Not yet implemented");
	 **/
	public void testSetDirection() {
		Velocity out = new Velocity();
		out.setDirection(45);
		assertEquals("Result", 45, out.getDirection());
	}

	@Test
	public void testSetSpeed() {
		Velocity v = new Velocity(2, 0);
		int expected = 5;
		v.setSpeed(5);
		assertEquals(expected, v.speed);
		assertEquals(expected, v.getSpeedX());
		assertEquals(0, v.getSpeedY());
	}

	@Test
	public void testGetSpeedX() {
		Velocity v = new Velocity(2, 0);
		assertEquals(2, v.getSpeedX());

		Velocity v2 = new Velocity(360, 90);
		assertEquals(0, v2.getSpeedX());

	}

	@Test
	public void testGetSpeedY() {
		Velocity v = new Velocity(2, 0);
		assertEquals(0, v.getSpeedY());

		Velocity v2 = new Velocity(360, 90);
		assertEquals(360, v2.getSpeedY());
	}
	
	@Test
	public void testDecomposeSpeed()
	{
		Velocity v = new Velocity();
		assertEquals(0, v.getSpeedX());
		assertEquals(0, v.getSpeedY());
		
		v.setSpeed(360);
		assertEquals(360, v.getSpeedX());
		assertEquals(0, v.getSpeedY());
		
		v.setDirection(90);
		v.decomposeSpeed();
		assertEquals(0, v.getSpeedX());
		assertEquals(360, v.getSpeedY());
		
		v.setDirection(200);
		v.decomposeSpeed();
		assertEquals(-338, v.getSpeedX());
		assertEquals(-123, v.getSpeedY());
		
	}
}
