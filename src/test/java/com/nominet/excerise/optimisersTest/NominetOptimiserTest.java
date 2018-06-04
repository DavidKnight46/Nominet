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
	 * Test case for supplied scenario 1
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
	 *  Test case for supplied scenario 2
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
	 * Test case for supplied scenario 3
	 */
	@Test
	public void scenario_3() {
		Receiver testReceiver_1 = new Receiver(1, new Point(0, 1), true);
		Receiver testReceiver_2 = new Receiver(2, new Point(8, 8), true);
		Receiver testReceiver_3 = new Receiver(3, new Point(6, 5), true);
		
		Transmitter testTran_1 = new Transmitter(1, new Point(2, 4), 1);
		Transmitter testTran_2 = new Transmitter(2, new Point(0, 6), 1);
		Transmitter testTran_3 = new Transmitter(3, new Point(1, 2), 1);
		Transmitter testTran_4 = new Transmitter(4, new Point(3, 5), 1);
		
		trans.add(testTran_1);
		trans.add(testTran_2);
		trans.add(testTran_3);
		trans.add(testTran_4);
		
		rec.add(testReceiver_1);
		rec.add(testReceiver_2);
		rec.add(testReceiver_3);
		
		Scenario scen1 = new Scenario(trans, rec);
		
		DavidOptimiser optimitise = new DavidOptimiser();
		Result result = optimitise.optimise(scen1);
		
		assertEquals( result.transmitters.get(0).getPower(), 1 );
		assertEquals( result.transmitters.get(1).getPower(), 3 );
		assertEquals( result.transmitters.get(2).getPower(), 2 );
		assertEquals( result.transmitters.get(3).getPower(), 5 );
	}
	
	/**
	 * Test case for supplied scenario 4
	 * 
	 * 
	 */
	@Test
	public void scenario_4() {
		Receiver testReceiver_1 = new Receiver(1, new Point(12, 6), true);
		Receiver testReceiver_2 = new Receiver(2, new Point(6, 12), true);
		Receiver testReceiver_3 = new Receiver(3, new Point(18, 12), true);
		Receiver testReceiver_4 = new Receiver(4, new Point(12, 18), true);
		
		Transmitter testTran_1 = new Transmitter(1, new Point(12, 12), 1);
		Transmitter testTran_2 = new Transmitter(2, new Point(12, 1), 1);
		Transmitter testTran_3 = new Transmitter(3, new Point(12, 23), 1);
		Transmitter testTran_4 = new Transmitter(4, new Point(1, 12), 1);
		Transmitter testTran_5 = new Transmitter(5, new Point(23, 12), 1);
		
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
		
		assertEquals( result.transmitters.get(0).getPower(), 6 );
		assertEquals( result.transmitters.get(1).getPower(), 1 );
		assertEquals( result.transmitters.get(2).getPower(), 1 );
		assertEquals( result.transmitters.get(3).getPower(), 1 );
		assertEquals( result.transmitters.get(4).getPower(), 1 );
	}
	
	/**
	 * Test case for supplied scenario 5
	 * 
	 */
	@Test
	public void scenario_5() {
		Receiver testReceiver_1 = new Receiver(1, new Point(12, 6), true);
		Receiver testReceiver_2 = new Receiver(2, new Point(6, 12), true);
		Receiver testReceiver_3 = new Receiver(3, new Point(18, 12), true);
		Receiver testReceiver_4 = new Receiver(4, new Point(12, 18), true);
		Receiver testReceiver_5 = new Receiver(5, new Point(12, 6), true);
		Receiver testReceiver_6 = new Receiver(6, new Point(6, 12), true);
		Receiver testReceiver_7 = new Receiver(7, new Point(18, 12), true);
		Receiver testReceiver_8 = new Receiver(8, new Point(12, 18), true);
		
		Transmitter testTran_1 = new Transmitter(1, new Point(18, 23), 2);
		Transmitter testTran_2 = new Transmitter(2, new Point(34, 30), 4);
		Transmitter testTran_3 = new Transmitter(3, new Point(22, 21), 3);
		Transmitter testTran_4 = new Transmitter(4, new Point(13, 14), 2);
		Transmitter testTran_5 = new Transmitter(5, new Point(32, 27), 4);
		Transmitter testTran_6 = new Transmitter(6, new Point(16, 19), 3);
		
		trans.add(testTran_1);
		trans.add(testTran_2);
		trans.add(testTran_3);
		trans.add(testTran_4);
		trans.add(testTran_5);
		trans.add(testTran_6);
		
		rec.add(testReceiver_1);
		rec.add(testReceiver_2);
		rec.add(testReceiver_3);
		rec.add(testReceiver_4);
		rec.add(testReceiver_5);
		rec.add(testReceiver_6);
		rec.add(testReceiver_7);
		rec.add(testReceiver_8);
		
		Scenario scen1 = new Scenario(trans, rec);
		
		DavidOptimiser optimitise = new DavidOptimiser();
		Result result = optimitise.optimise(scen1);
		
		assertEquals( result.transmitters.get(0).getPower(), 2 );
		assertEquals( result.transmitters.get(1).getPower(), 4 );
		assertEquals( result.transmitters.get(2).getPower(), 3 );
		assertEquals( result.transmitters.get(3).getPower(), 2 );
		assertEquals( result.transmitters.get(4).getPower(), 4 );
		assertEquals( result.transmitters.get(5).getPower(), 20 );
		
	}
	
	/**
	 * Test case for supplied scenario 6
	 * 
	 */
	@Test
	public void scenario_6() {
		Transmitter testTran_1 = new Transmitter(1, new Point(2, 5), 1);
		Transmitter testTran_2 = new Transmitter(2, new Point(0, 6), 3);
		Transmitter testTran_3 = new Transmitter(3, new Point(1, 2), 2);
		Transmitter testTran_4 = new Transmitter(4, new Point(6, 8), 1);
		
		Receiver testReceiver_1 = new Receiver(1, new Point(0, 1), true);
		Receiver testReceiver_2 = new Receiver(2, new Point(9, 8), true);
		Receiver testReceiver_3 = new Receiver(3, new Point(6, 5), true);
		
		trans.add(testTran_1);
		trans.add(testTran_2);
		trans.add(testTran_3);
		trans.add(testTran_4);
		
		rec.add(testReceiver_1);
		rec.add(testReceiver_2);
		rec.add(testReceiver_3);
		
		Scenario scen1 = new Scenario(trans, rec);
		
		DavidOptimiser optimitise = new DavidOptimiser();
		Result result = optimitise.optimise(scen1);
		
		assertEquals( result.transmitters.get(0).getPower(), 1 );
		assertEquals( result.transmitters.get(1).getPower(), 3 );
		assertEquals( result.transmitters.get(2).getPower(), 4 );
		assertEquals( result.transmitters.get(3).getPower(), 4 );
	}
	
	/**
	 * Test case for supplied scenario 7
	 * 
	 */
	@Test
	public void scenario_7() {
		Transmitter testTran_1 = new Transmitter(1, new Point(18, 23), 2);
		Transmitter testTran_2 = new Transmitter(2, new Point(34, 30), 4);
		Transmitter testTran_3 = new Transmitter(3, new Point(22, 21), 3);
		
		Receiver testReceiver_1 = new Receiver(1, new Point(12, 6), true);
		Receiver testReceiver_2 = new Receiver(2, new Point(6, 12), true);
		
		trans.add(testTran_1);
		trans.add(testTran_2);
		trans.add(testTran_3);
		
		rec.add(testReceiver_1);
		rec.add(testReceiver_2);
		
		Scenario scen1 = new Scenario(trans, rec);
		
		DavidOptimiser optimitise = new DavidOptimiser();
		Result result = optimitise.optimise(scen1);
		
		assertEquals( result.transmitters.get(0).getPower(), 2 );
		assertEquals( result.transmitters.get(1).getPower(), 4 );
		assertEquals( result.transmitters.get(2).getPower(), 12 );
	}

}
