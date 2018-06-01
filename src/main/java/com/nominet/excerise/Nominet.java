package com.nominet.excerise;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nominet.excerise.model.Point;
import com.nominet.excerise.model.Receiver;
import com.nominet.excerise.model.Scenario;
import com.nominet.excerise.model.Transmitter;
import com.nominet.excerise.optimisers.DavidOptimiser;

/**
 * Hello world!
 *
 */
public class Nominet
{
	private static Logger log = Logger.getLogger(Nominet.class);
	
    public static void main( String[] args )
    {
    	List<Transmitter> tList = new ArrayList<Transmitter>();
    	List<Receiver> rList = new ArrayList<Receiver>();
    	
    	Receiver testReceiver_1 = new Receiver(1, new Point(1, 0));
    	Receiver testReceiver_2 = new Receiver(2, new Point(2, 0));
    	
    	Transmitter testTran_1 = new Transmitter(1, new Point(3, 0), 1);
    	
    	Scenario scenario = new Scenario( tList, rList );
    	
    	tList.add(testTran_1);
		
    	rList.add(testReceiver_1);
    	rList.add(testReceiver_2);
    	
    	DavidOptimiser opti = new DavidOptimiser();
    	opti.optimise(scenario);
    	
    	
    }
}
