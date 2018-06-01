package com.nominet.excerise.optimisers;

import com.nominet.excerise.model.Result;
import com.nominet.excerise.model.Scenario;
import com.nominet.excerise.model.Transmitter;

import java.util.stream.Collectors;

public class AddTenOptimiser implements PowerOptimiser {
    // This is fairly obviously not a very good implementation

    public AddTenOptimiser() {
    }

    @Override
    public Result optimise(Scenario scenario) {
        return new Result(
                scenario.transmitters.stream().map(t -> new Transmitter(t.id, t.location, t.getPower() + 10)).collect(Collectors.toList())
        );
    }
}
