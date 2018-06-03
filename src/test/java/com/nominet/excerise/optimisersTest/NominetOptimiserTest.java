package com.nominet.excerise.optimisersTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nominet.excerise.model.Point;
import com.nominet.excerise.model.Receiver;
import com.nominet.excerise.model.Result;
import com.nominet.excerise.model.Scenario;
import com.nominet.excerise.model.Transmitter;
import com.nominet.excerise.optimisers.DavidOptimiser;

public class NominetOptimiserTest {
	
	List<Transmitter> trans = new ArrayList<Transmitter>();
	List<Receiver> rec = new ArrayList<Receiver>();
	
	Scenario sc =  new Scenario(trans, rec);
	
	@Before
	public void before() {
		trans.clear();
		rec.clear();
	}
	
	/**
	 * 
	 */
	@Test
	public void scenario_1() {
		Receiver testReceiver_1 = new Receiver(1, new Point(0, 2), true);
		
		Transmitter testTran_1 = new Transmitter(1, new Point(0, 0), 1);
		
		trans.add(testTran_1);
		
		rec.add(testReceiver_1);
		
		Scenario scen1 = new Scenario(trans, rec);
		
		DavidOptimiser optimitise = new DavidOptimiser();
		Result result = optimitise.optimise(scen1);
		
		assertEquals( result.getTotalPower(), 2 );
		
	}
	
	/**
	 * 
	 */
	@Test
	public void scenario_2() {
		Receiver testReceiver_1 = new Receiver(1, new Point(0, 3), true);
		
		Transmitter testTran_1 = new Transmitter(1, new Point(0, 0), 1);
		Transmitter testTran_2 = new Transmitter(2, new Point(0, 6), 2);
		
		trans.add(testTran_1);
		trans.add(testTran_2);
		
		rec.add(testReceiver_1);
		
		Scenario scen1 = new Scenario(trans, rec);
		
		DavidOptimiser optimitise = new DavidOptimiser();
		Result result = optimitise.optimise(scen1);
		
		assertEquals( result.transmitters.get(0).getPower(), 1 );
		assertEquals( result.transmitters.get(1).getPower(), 3 );
	}
	
	/**
	 * 
	 */
	@Test
	public void scenario_3() {
		Receiver testReceiver_1 = new Receiver(1, new Point(0, 1), false);
		Receiver testReceiver_2 = new Receiver(2, new Point(9, 9), false);
		Receiver testReceiver_3 = new Receiver(3, new Point(7, 6), false);
		Receiver testReceiver_4 = new Receiver(4, new Point(7, 6), false);
		
		Transmitter testTran_1 = new Transmitter(1, new Point(3, 6), 1);
		Transmitter testTran_2 = new Transmitter(2, new Point(0, 7), 1);
		Transmitter testTran_3 = new Transmitter(3, new Point(2, 3), 1);
		Transmitter testTran_4 = new Transmitter(4, new Point(4, 6), 1);
		Transmitter testTran_5 = new Transmitter(5, new Point(4, 6), 1);
		
		trans.add(testTran_1);
		trans.add(testTran_2);
		trans.add(testTran_3);
		trans.add(testTran_4);
		trans.add(testTran_5);
		
		rec.add(testReceiver_1);
		rec.add(testReceiver_2);
		rec.add(testReceiver_3);
		rec.add(testReceiver_4);
		
		Scenario scen1 = new Scenario(trans, rec);
		
		DavidOptimiser optimitise = new DavidOptimiser();
		Result result = optimitise.optimise(scen1);
		
		assertTrue( rec.stream().allMatch(e -> e.getIsInCoverage() == true ||
				                               e.getIsConnectedToRec() == false) );
	}
	
	/**
	 * 
	 */
	@Test
	public void scenario_4() {
	}
	
	/**
	 * 
	 */
	@Test
	public void scenario_5() {
		//fail("Not yet implemented");
	}
	
	/**
	 * 
	 */
	@Test
	public void scenario_6() {
		//fail("Not yet implemented");
	}

}
