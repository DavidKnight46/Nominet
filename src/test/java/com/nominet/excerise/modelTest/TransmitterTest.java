package com.nominet.excerise.modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.nominet.excerise.model.Point;
import com.nominet.excerise.model.Transmitter;

public class TransmitterTest {
	
	Transmitter transTest;
	final int powerIncreasedRequired = 2;
	final int EXPECTED_RESULT_INT = 4; 
	
	@Before
	public void before() {
		transTest = new Transmitter(1, new Point(1, 1), 2);
	}

	/**
	 * Ensure that the transmission power can be 
	 * increased
	 * 
	 */
	@Test
	public void increaseTransmissionPower() {
		transTest.increasePower(powerIncreasedRequired);
		
		assertEquals(transTest.getPower(), EXPECTED_RESULT_INT);
	}

}
