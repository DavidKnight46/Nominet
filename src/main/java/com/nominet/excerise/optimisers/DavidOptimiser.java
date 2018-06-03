package com.nominet.excerise.optimisers;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.nominet.excerise.model.Result;
import com.nominet.excerise.model.Scenario;

import smile.math.distance.ChebyshevDistance;

public class DavidOptimiser implements PowerOptimiser {

	private static Logger log = Logger.getLogger(DavidOptimiser.class);

	/**
	 * Ensure all receivers to receive a signal from the transmitters
	 * 
	 */
	@Override
	public Result optimise(Scenario scenario) {
		int countTr = 0;

		while (isAllReceiversInRange(scenario)) {

			int positionTransmitterX = scenario.transmitters.get(0).location.x;
			int positionTransmitterY = scenario.transmitters.get(0).location.y;

			int positionTransmissionPower = scenario.transmitters.get(0).getPower();

			double[] chebyTransmitter = { Integer.valueOf(positionTransmitterX).doubleValue(),
					Integer.valueOf(positionTransmitterY).doubleValue() };

			// Check that receiver is not out of coverage
			if (scenario.receivers.get(countTr).getIsInCoverage()) {

				// Find an receiver that is range of the transmitter
				int positionRecieverX = scenario.receivers.get(countTr).location.x;
				int positionRecieverY = scenario.receivers.get(countTr).location.y;

				double[] chebyReciever = { Integer.valueOf(positionRecieverX).doubleValue(),
						Integer.valueOf(positionRecieverY).doubleValue() };

				// Receiver is in range of a transmitter
				if (calcuateChebyshevDistance(chebyTransmitter, chebyReciever) <= positionTransmissionPower) {
					scenario.receivers.get(countTr).setIsInCoverage(true);
					log.log(Level.INFO, "Reciever " + scenario.receivers.get(countTr).id + " connected."
							+ "Connected to transmitter 1");
				}
				// Receiver is not in range thus we increase power of closest transmitter
				// until in range
				else {
					this.findClosestTransmitter(scenario, countTr);
				}

				countTr++;
			}//End of In coverage loop
			else {
				log.log(Level.INFO, scenario.receivers.get(countTr).id + " not in coverage.");
			}
		}

		return new Result(scenario.transmitters);
	}

	/**
	 * Calculate Chebyshev Distance between a transmitter and receiver
	 * 
	 * @param tr
	 * @param re
	 * @return
	 */
	private double calcuateChebyshevDistance(double[] tr, double[] re) {
		ChebyshevDistance chebyshevDistanceResult = new ChebyshevDistance();

		return chebyshevDistanceResult.d(tr, re);
	}

	/**
	 * Find the closest transmitter to a receiver and increase power required.
	 * 
	 * @param trans
	 * @param rece
	 */
	private void findClosestTransmitter(Scenario sce, int recId) {
		double powerIncreaseRequired = 0.0;
		int index = 0;

		double[] rec = { sce.receivers.get(recId).location.x, sce.receivers.get(recId).location.y };

		double[] trans = { sce.transmitters.get(0).location.x, sce.transmitters.get(0).location.y };

		double range = calcuateChebyshevDistance(rec, trans);
		powerIncreaseRequired = range - sce.transmitters.get(0).getPower();

		//
		for (int count = 1; count <= sce.transmitters.size() - 1; count++) {
			int power = sce.transmitters.get(count).getPower();

			double[] transI = { sce.transmitters.get(count).location.x, sce.transmitters.get(count).location.y };

			if (powerIncreaseRequired > calcuateChebyshevDistance(rec, transI) - power) {
				powerIncreaseRequired = range - power;
				index = count;
			}

		}

		sce.receivers.get(recId).setIsInCoverage(true);
		sce.transmitters.get(index).increasePower((int) powerIncreaseRequired);

		log.log(Level.INFO, "Reciever " + sce.receivers.get(recId).id + " connected." + "Connected to transmitter "
				+ sce.transmitters.get(index).id);

	}

	/**
	 * Confirm that all receivers are in range of a transmitter
	 * 
	 * @param scenario
	 * @return
	 */
	private boolean isAllReceiversInRange(Scenario scenario) {
		return scenario.receivers.stream().anyMatch(e -> e.getIsConnectedToRec() == false &&
				                                    e.getIsInCoverage() ==  true);

	}

}
