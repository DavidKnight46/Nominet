package com.nominet.excerise.modelTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nominet.excerise.model.Point;
import com.nominet.excerise.model.Receiver;

public class ReceiverTest {
	
	Receiver recieverTest;
	

	/**
	 * Test to ensure that receiver is not connected 
	 * to a transmitter
	 */
	@Test
	public void isConnectedToAReceiverTest() {
		
		recieverTest = new Receiver(1, new Point(1, 2), true);
		
		assertFalse(recieverTest.getIsConnectedToRec());
		
	}
	
	/**
	 * Test to ensure that receiver is in
	 * coverage 
	 * 
	 */
	@Test
	public void isInCoverageTest() {
		
		recieverTest = new Receiver(1, new Point(1, 2), true);
		
		assertTrue(recieverTest.getIsInCoverage());
		
		recieverTest = new Receiver(1, new Point(1, 2), false);
		
		assertFalse(recieverTest.getIsInCoverage());
		
	}

}
